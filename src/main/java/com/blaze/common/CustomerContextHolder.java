package com.blaze.common;

public class CustomerContextHolder {

	public final static String SESSION_FACTORY_SUNRISE = "sunrise";
	public final static String SESSION_FACTORY_NEWTG = "newtg";
	public final static String SESSION_FACTORY_OMSTG = "oms_tg";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setContextType(String contextType) {
		contextHolder.set(contextType);
	}

	public static String getContextType() {
		return contextHolder.get();
	}

	public static void clearContextType() {
		contextHolder.remove();
	}
}
