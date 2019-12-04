package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Role;
import com.zhiyou.model.User;

public interface UserService {

	List<User> findAll(String username);

	boolean addUser(User user);

	boolean upUser(User user);

	User seleUser(int id);

	void delUser(int id);

}
