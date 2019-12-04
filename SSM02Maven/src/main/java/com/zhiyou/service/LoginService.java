package com.zhiyou.service;

import com.zhiyou.model.User;

public interface LoginService {

	User findUserByLogin(String username, String password);

	User findUserByUsername(String principal);

}
