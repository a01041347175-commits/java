package com.office.session;

import java.util.HashMap;

public class Session {

	private static Session session;
	
	final private HashMap<String, Object> attributies;
	
	private Session() {
		this.attributies = new HashMap<String, Object>();
	}
	
	public static Session getInstance () {
		if (session == null) {
			session = new Session();
			
		}
		return session;
	}

	public HashMap<String, Object> getAttributies() {
		return attributies;
		
	}
	
	public void setAttribute(String name, Object object) {
		attributies.put(name, object);
	}
	
	public void removeAttribute(String name) {
		attributies.remove(name);
	}
	
}
