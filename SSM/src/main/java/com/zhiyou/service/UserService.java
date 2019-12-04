package com.zhiyou.service;

import java.util.List;
import java.util.Map;

import com.zhiyou.model.User;

public interface UserService {
	void add(User user);	
	void update(User user); 
	void delete(int id);
	List<User> selectAll(Map<String, Object> map); 
	User selectByID(int id);
	User selectByName(String name);
}
