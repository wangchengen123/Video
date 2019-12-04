package com.zhiyou.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou.service.UserService;
import com.zhiyou.service.UserServiceImpl;

public class TestSpring {

	public static void main(String[] args) {
		// 创建业务层对象
		UserService us = new UserServiceImpl();
		us.insertUser();
		us.deleteUser();
	}

	@Test
	public void testIOC() {
		// 1.读取Spring的配置文件,获得Spring的容器
		String path = "applicationContext.xml";
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(path);
		System.out.println("创建了Spring容器");
		// 2.从Spring的容器中获得创建的对象
		// 通过bean标签的id获取
		UserService us = (UserService) app.getBean("userServiceImpl");
		System.out.println("从Spring容器获得了对象");
		System.out.println("对象地址:" + us);
		us.deleteUser();
		// 关闭容器
		app.close();
		/*
		 * 1.Bean在Spring容器加载的时候就会被创建 
		 * 2.创建后随即进行初始化 
		 * 3.从容器中获得创建的对象,开始使用
		 * 4.当应用程序从服务器卸载,或者服务器宕机,或者手动关闭Spring容器,就会消耗该对象
		 */

	}

}
