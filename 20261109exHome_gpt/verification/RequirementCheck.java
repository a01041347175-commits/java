import com.office.Container;
import com.office.config.Config;
import com.office.db.DiaryDb;
import com.office.member.*;
import com.office.diary.*;
import com.office.session.Session;

public class RequirementCheck {
    private static int count;
    private static void check(boolean condition, String label) {
        if (!condition) throw new AssertionError(label);
        count++;
        System.out.println("PASS: " + label);
    }
    private static MemberDto member(String id, String pw) {
        return new MemberDto(id, pw, "test@example.com", "010-0000-0000");
    }
    private static void login(String id) {
        Session.getInstance().setAttribute(Config.SIGNINED_MEMBER_ID, id);
    }
    private static void logout() {
        Session.getInstance().removeAttribute(Config.SIGNINED_MEMBER_ID);
    }
    public static void main(String[] args) {
        MemberService members = Container.getInstance().getMemberService();
        DiaryService diaries = Container.getInstance().getDiaryService();
        DiaryDb db = DiaryDb.getInstance();
        db.getMembers().clear(); db.getDiaries().clear(); logout();
        check(members.signUp(member("alice", "123")) == 0, "reject short password");
        check(members.signUp(member("", "1234")) == 0, "reject empty ID");
        check(members.signUp(member("alice", "1234")) == 1, "sign up Alice");
        check(members.signUp(member("alice", "9999")) == 0, "reject duplicate ID");
        check(members.signIn(member("alice", "1234")) != null, "duplicate signup did not overwrite account");
        check(members.signUp(member("bob", "5678")) == 1, "sign up Bob");
        check(members.signIn(member("unknown", "1234")) == null, "reject unknown ID");
        check(members.signIn(member("alice", "wrong")) == null, "reject wrong password");
        check(members.modify(member("alice", "9999"), "1234") == 0, "reject guest modification");
        check(members.delete(member("alice", "1234")) == 0, "reject guest deletion");
        boolean writeBlocked = false, readBlocked = false;
        try { diaries.write("title", "body"); } catch (IllegalStateException e) { writeBlocked = true; }
        try { diaries.readList(); } catch (IllegalStateException e) { readBlocked = true; }
        check(writeBlocked, "reject guest diary write");
        check(readBlocked, "reject guest diary list");
        login("alice");
        check(!diaries.write("", "body"), "reject empty title");
        check(!diaries.write("title", "   "), "reject blank body");
        check(!diaries.write("   ", "body"), "reject blank title");
        check(!diaries.write("title", ""), "reject empty body");
        check(diaries.readList().isEmpty(), "invalid diaries were not saved");
        check(diaries.write("Alice title with spaces", "Alice body with spaces"), "save Alice diary");
        check(diaries.readList().size() == 1, "list Alice diary");
        check(diaries.readList().get(0).getDiaryBody().equals("Alice body with spaces"), "preserve spaces in content");
        check(diaries.readList().get(0).getDiaryRegDate() != null, "record diary time");
        check(members.modify(member("bob", "9999"), "5678") == 0, "reject modification of another member");
        check(members.delete(member("bob", "5678")) == 0, "reject deletion of another member");
        check(members.modify(member("alice", "9999"), "wrong") == 0, "check current password before modification");
        check(members.modify(member("alice", "123"), "1234") == 0, "reject short replacement password");
        MemberDto changed = new MemberDto("alice", "9999", "changed@example.com", "010-1111-2222");
        check(members.modify(changed, "1234") == 1, "modify own member information");
        check(members.signIn(member("alice", "1234")) == null, "old password no longer works");
        check(members.signIn(member("alice", "9999")).getMemMail().equals("changed@example.com"), "save new password and email");
        check(members.signIn(member("alice", "9999")).getMemPhone().equals("010-1111-2222"), "save phone");
        logout();
        check(Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID) == null, "logout clears session");
        login("bob");
        check(diaries.readList().isEmpty(), "Bob cannot see Alice diary");
        check(diaries.write("Bob title", "Bob body"), "save Bob diary");
        check(diaries.readList().size() == 1 && diaries.readList().get(0).getDiaryTitle().equals("Bob title"), "Bob sees only own diary");
        login("alice");
        check(diaries.readList().size() == 1 && diaries.readList().get(0).getDiaryTitle().startsWith("Alice"), "Alice cannot see Bob diary");
        check(members.delete(member("alice", "wrong")) == 0, "reject deletion with wrong password");
        check(members.delete(member("alice", "9999")) == 1, "delete own account");
        check(!db.getMembers().containsKey("alice"), "remove member data");
        check(!db.getDiaries().containsKey("alice"), "remove member diaries");
        check(Session.getInstance().getAttribute(Config.SIGNINED_MEMBER_ID) == null, "deletion clears session");
        check(members.signIn(member("alice", "9999")) == null, "deleted account cannot log in");
        check(db.getMembers().containsKey("bob") && db.getDiaries().get("bob").size() == 1, "preserve other member and diaries");
        check(members.signUp(member("alice", "1111")) == 1, "allow signup after deletion");
        login("alice");
        check(diaries.readList().isEmpty(), "reused ID cannot access deleted diaries");
        System.out.println("ALL " + count + " CHECKS PASSED");
    }
}