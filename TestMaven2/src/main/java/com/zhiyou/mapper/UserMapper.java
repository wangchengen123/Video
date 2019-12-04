package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.User;

public interface UserMapper {

	List<User> findAll();

	int addUser(User user);

	int upUser(User user);

	User seleUser(int id);

	void delUser(int id);

}
