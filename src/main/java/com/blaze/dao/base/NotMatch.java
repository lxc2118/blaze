package com.blaze.dao.base;

public class NotMatch {
	private static SimpleCdt instance = new SqlCdt("1=2");

	public static SimpleCdt get() {
		return instance;
	}
}
