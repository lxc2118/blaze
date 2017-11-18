package com.blaze.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class TestBase extends TestCase {

	protected static ApplicationContext ac;

	public TestBase() {
		try {
			ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
