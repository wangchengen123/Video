package com.zhiyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

	
	
	@Override
	public void insertUser() {
		System.out.println("业务层 插入用户");
	}

	@Override
	public void deleteUser() {
		System.out.println("业务层 删除用户");
	}

}
