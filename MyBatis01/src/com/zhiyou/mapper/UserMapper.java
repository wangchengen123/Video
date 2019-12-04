package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.User;

/**
 * @author Administrator
 * 定义数据访问层的方法
 */
public interface UserMapper {
	
	//根据名字模糊查询
	List<User> findUserByKeyword(String keyword);
	
	// 查全部
	List<User> findAllUser();
	
	// 查一个
	User findUserById(int id);

	//根据名字 查询用户
	User findUserByName(String name);
	
	//插入用户
	void insertUser(User user);
	
	//根据用户名和密码
	/*
	 * 使用注解解决多个参数的问题
	 * @parem() 
	 */
	User findUserByNameAndPassword(String name,String password);
	
	
	List<User> findUserByKeywordDynamicSQL(String keyword);
	
	
}
