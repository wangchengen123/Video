package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.User;

public interface UserMapper {

	List<User> getAll();

	User getUserById(int id);

	int addUser(User user);

	int deleteUserById(int id);

	int updateUserById(User user);

}
