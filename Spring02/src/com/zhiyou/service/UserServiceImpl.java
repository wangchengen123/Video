package com.zhiyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.Dao;
import com.zhiyou.dao.DaoImpl;
import com.zhiyou.dao.UserDao;
/*
 * @Service 相当于写了<bean class="">
 * @Service("userServiceImpl")相当于写了<bean id="userServiceImpl"class="">
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Value("1001")
	private int id;
	@Value("张三")
	private String name;
	
	
	/*
	 * 默认是按类型注入属性
	 * 在Spring的容器中有该类型(UserDao类型的)的对象存在
	 */
	
	@Autowired
	private UserDao dao;
	
	@Override
	public void insertUser() {
		dao.insertUser();
	}

	@Override
	public void deleteUser() {
		System.out.println(id+"-"+name);
		dao.deleteUser();
	}

}
