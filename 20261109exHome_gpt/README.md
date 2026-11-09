# 20261109exHome_gpt

20261106ex_pf의 Java 파일 15개를 복사하여 기존 패키지와 Controller → Service → DAO 구조를 유지하면서 완성한 콘솔 프로그램입니다.

## 실행
Eclipse에서 src/com/office/MainClass.java를 선택하고 Run As → Java Application으로 실행합니다.

- 비로그인: 1 회원가입, 2 로그인, 99 종료
- 로그인: 3 로그아웃, 4 정보수정, 5 탈퇴, 6 일기작성, 7 일기목록, 99 종료
- 정보수정: 현재 비밀번호, 새 비밀번호, 이메일, 전화번호를 순서대로 입력합니다. 아이디는 변경하지 않습니다.
- 일기 제목과 내용은 각각 한 줄로 입력합니다. 단어 사이 공백은 허용하며 빈 입력/공백만 있는 입력은 거절합니다.
- 회원탈퇴 시 해당 회원의 일기도 함께 삭제하고 로그아웃합니다.
- 기존 HashMap 기반 메모리 저장 방식을 유지하므로 프로그램 종료 시 회원과 일기가 사라집니다.

## 구현 내용
아이디 중복 방지, 비밀번호 최소 4자리, 아이디/비밀번호 로그인 검사, 로그인 상태별 메뉴와 실행 권한 검사, 본인 정보수정/탈퇴, 본인 일기 작성/목록, 필수 입력 검사, 잘못된 메뉴 입력 처리.

## 검증
verification/RequirementCheck.java: 서비스·저장소 동작 43개 검증. verification/console-check.txt: 실제 콘솔 입력 시나리오 결과.

프로젝트 루트에서 PowerShell로 검증을 다시 실행할 수 있습니다.
```powershell
$javaSources = @(Get-ChildItem src -Recurse -Filter '*.java' | ForEach-Object FullName)
javac -encoding UTF-8 -d verification $javaSources verification\RequirementCheck.java
java -cp verification RequirementCheck
```
검증은 별도 Java 프로세스의 메모리에서 수행됩니다.