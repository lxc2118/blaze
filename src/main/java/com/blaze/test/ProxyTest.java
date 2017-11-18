package com.blaze.test;

import java.util.List;
import java.util.Random;

import com.blaze.biz.Proxy;
import com.blaze.common.S;
import com.blaze.dao.ProxyDao;
import com.blaze.dao.base.Query;

public class ProxyTest extends TestBase {

	public void test() {
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			System.out.println(random.nextInt(33)+1);
		}
		System.out.println(random.nextInt(16)+1);
	}
	
//	<constructor-arg index="0" ref="org.mybatis.spring.SqlSessionTemplate" />
//	<!-- DAO�ӿ����ڰ�����Spring���Զ��������µ��� -->
//	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
//		<property name="basePackage" value="com.blaze.dao" />
//		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
//	</bean>
}
