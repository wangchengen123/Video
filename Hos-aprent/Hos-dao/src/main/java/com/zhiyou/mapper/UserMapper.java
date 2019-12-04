package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou.model.User;

public interface UserMapper {

	List<User> findAll(Map<String,String> map );

	int addUser(User user);

	int upUser(User user);

	User seleUser(int id);

	void delUser(int id);

}
