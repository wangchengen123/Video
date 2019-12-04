package com.zhiyou.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.LoginMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper mapper;
	
	public User findUserByLogin(String accounts, String password) {
	/*	Map<String,String> map = new HashMap<String,String>();
		map.put("accounts", accounts);
		map.put("password", password);*/
		//调用数据访问层查询
		User user = mapper.findUserByLogin(accounts,password);
		return user;
	}

}
