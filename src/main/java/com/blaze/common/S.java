package com.blaze.common;

public class S {

	public static <T> T get(Class<T> clazz) {
		return SpringContext.getBean(clazz);
	}

	public static Object get(String beanId) {
		return SpringContext.getBean(beanId);
	}

	public static <T> T get(String beanId, Class<T> clazz) {
		return (T) SpringContext.getBean(beanId);
	}
}
