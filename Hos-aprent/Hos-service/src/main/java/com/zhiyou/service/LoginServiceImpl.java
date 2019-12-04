package com.zhiyou.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.LoginMapper;
import com.zhiyou.model.User;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper mapper;
	
	public User findUserByLogin(String username, String password) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		//调用数据访问层查询
		User user = mapper.findUserByLogin(map);
		return user;
	}

}
