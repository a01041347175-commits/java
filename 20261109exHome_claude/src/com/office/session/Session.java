package com.office.session;

import java.util.HashMap;

import com.office.config.Config;

public class Session {

	private static Session session;

	final private HashMap<String, Object> attribute;

	private Session() {
		attribute = new HashMap<String, Object>();
	}

	public static Session getInstance() {
		if (session == null)
			session = new Session();

		return session;

	}

	public Object getAttribute(String name) {
		return attribute.get(name);

	}

	public void setAttribute(String name, Object object) {
		attribute.put(name, object);

	}

	public void removeAttribute(String name) {
		attribute.remove(name);

	}

	/*
	 * 로그인한 회원 ID 반환 (로그인하지 않았으면 null)
	 */
	public String getSignInedMemberId() {
		return (String) attribute.get(Config.SIGNINED_MEMBER_ID);

	}

	public boolean isSignIned() {
		return getSignInedMemberId() != null;

	}

}
