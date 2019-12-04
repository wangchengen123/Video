package com.zhiyou.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	@Test
	public void testAOP() {
		// 加载配置文件
		String path = "com/zhiyou/service/applicationContextAnnoAOP.xml";
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext();
		// 获得对象
		UserService userServiceImpl = (UserService) app.getBean("userServiceImpl");
		userServiceImpl.deleteUser();
		System.out.println("----");
		userServiceImpl.insertUser();
	
	}
	

}

   



