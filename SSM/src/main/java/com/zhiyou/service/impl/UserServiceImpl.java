package com.zhiyou.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper mapper;
	
	public void add(User user) {
		mapper.add(user);
	}

	public void update(User user) {
		mapper.update(user);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<User> selectAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.selectAll(map);
	}

	public User selectByID(int id) {
		// TODO Auto-generated method stub
		return mapper.selectByID(id);
	}

	public User selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}
