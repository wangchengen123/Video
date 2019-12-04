package com.zhiyou.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou.service.UserService;

public class TestSpring {
	@Test
	public void testAnno() {
		// 加载配置文件
		String path = "applicateionContextAnno.xml";
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext();
		//从容器中获取对象
		UserService us = (UserService) app.getBean("userServiceImpl");
		us.deleteUser();
	}

}
