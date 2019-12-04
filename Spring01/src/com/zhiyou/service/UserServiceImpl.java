package com.zhiyou.service;

import com.zhiyou.dao.Dao;
import com.zhiyou.dao.DaoImpl;

public class UserServiceImpl implements UserService{

	
	// 之前控制器在直接自己创建对象
	Dao dao = new DaoImpl();
	
	@Override
	public void insertUser() {
		dao.insertUser();
	}

	@Override
	public void deleteUser() {
		dao.deleteUser();
	}

	public UserServiceImpl() {
		System.out.println("创建UserServiceImpl对象 ");
	}
	
	// 自定义初始化的方法
	public void myInit() {
		System.out.println("UserServiceImpl 初始化方法执行了");
	}
	
	// 自定义销毁的方法
	public void myDestroy() {
		System.out.println("UserServiceImpl 销毁的方法执行了");
	}
	
}
