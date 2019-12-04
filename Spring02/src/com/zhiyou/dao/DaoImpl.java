package com.zhiyou.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {

	@Override
	public void insertUser() {
		System.out.println("添加用户");

	}

	@Override
	public void deleteUser() {
		System.out.println("删除用户");
		
	}

}
