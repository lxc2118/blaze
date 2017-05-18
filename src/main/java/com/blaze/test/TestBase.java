package com.blaze.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class TestBase extends TestCase {

	protected static ApplicationContext ac;

	public TestBase() {
		try {
			new ClassPathXmlApplicationContext("applicationContext.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
