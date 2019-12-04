package com.zhiyou.springAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.Dao;
import com.zhiyou.dao.DaoImpl;
import com.zhiyou.dao.UserDao;

public class UserServiceImpl implements UserService{
	
	@Override
	public void insertUser() {
		System.out.println("业务层插入用户");
	}

	@Override
	public void deleteUser() {
		System.out.println("业务层删除用户");
	}

}
