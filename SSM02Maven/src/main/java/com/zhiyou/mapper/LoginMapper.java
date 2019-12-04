package com.zhiyou.mapper;

import java.util.Map;

import com.zhiyou.model.User;

public interface LoginMapper {

	User findUserByLogin(Map<String, String> map);

	User findUserByUsername(String principal);

}
