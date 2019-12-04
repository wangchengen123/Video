package com.zhiyou.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.User;

public interface LoginMapper {

	//User findUserByLogin(Map<String, String> map);
	User findUserByLogin(@Param("accounts")String accounts, @Param("password")String password);
}
