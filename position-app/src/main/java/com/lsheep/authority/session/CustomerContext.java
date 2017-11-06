package com.lsheep.authority.session;

public class CustomerContext {

	private static final ThreadLocal<CustomerSession> CUSTOMER_SESSION = new ThreadLocal<>();

	public static void setSession(CustomerSession session) {
		CUSTOMER_SESSION.set(session);
	}

	public static CustomerSession getSession() {
		return CUSTOMER_SESSION.get();
	}

	public static void remove() {
		CUSTOMER_SESSION.remove();
	}

}
