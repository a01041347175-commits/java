package com.office.session;

import java.util.HashMap;

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

	public void removeAttribute(String signinedMemberId) {
		attribute.remove(signinedMemberId);
		
	}
	
}
