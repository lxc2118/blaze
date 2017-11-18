package blaze;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blaze.biz.Proxy;
import com.blaze.service.ProxyService;
import com.blaze.test.TestBase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis extends TestBase{
	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Resource
	private ProxyService proxyService;

//	 @Before
//	 public void before() {
//		 ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		 userService = (UserService) ac.getBean("userService");
//	 }

	@Test
	public void test1() {
		Proxy proxy = proxyService.get(1);
		System.out.println(proxy.getIp());
	}
}