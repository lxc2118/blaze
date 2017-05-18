package com.blaze.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blaze.biz.Proxy;
import com.blaze.service.ProxyService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static Logger logger = Logger.getLogger(TestMybatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private ProxyService proxyService;

	// @Before
	// public void before() {
	// ApplicationContext ac = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (UserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
//		Proxy proxy = proxyService.findById(1);
//		System.out.println(proxy.getIp());
		
//		Proxy proxy = new Proxy();
		Proxy proxy = proxyService.get(1);
		System.out.println(proxy.getIp());
		// logger.info("值："+user.getUserName());
		// logger.info(JSON.toJSONString(user));
	}

}
