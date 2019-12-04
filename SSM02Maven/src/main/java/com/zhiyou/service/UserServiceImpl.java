package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	
	@Override
	public List<User> findAll() {
		
		return mapper.findAll();
	}


	@Override
	public boolean addUser(User user) {
		int rowNum = mapper.addUser(user);
		if(rowNum > 0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean upUser(User user) {
		
		int rowNum = mapper.upUser(user);
		if(rowNum > 0) {
			return true;
		}
		return false;
	}


	@Override
	public User seleUser(int id) {
		
		return mapper.seleUser(id);
	}


	@Override
	public void delUser(int id) {
		mapper.delUser(id);
	}

}
