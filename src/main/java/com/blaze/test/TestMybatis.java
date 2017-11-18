package com.blaze.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blaze.biz.Proxy;
import com.blaze.service.ProxyService;
import com.blaze.service.UserService;

import junit.framework.TestCase;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMybatis extends TestCase {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private ProxyService proxyService;

	 @Before
	 public void before() {
	 ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//	 userService = (UserService) ac.getBean("userService");
	 }

	public void test1() {
		System.out.println(1);
//		Proxy proxy = proxyService.findById(1);
//		System.out.println(proxy.getIp());
		
//		Proxy proxy = new Proxy();
//		Proxy proxy = proxyService.get(1);
//		System.out.println(proxy.getIp());
		// logger.info("值："+user.getUserName());
		// logger.info(JSON.toJSONString(user));
	}

}
