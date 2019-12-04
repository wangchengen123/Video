package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.RegistrationInfor;

public interface RegistrationInforMapper {
    int insert(RegistrationInfor record);

    int insertSelective(RegistrationInfor record);

	List<RegistrationInfor> findAll();

	void delRegis(String id);

	RegistrationInfor selRegis(int id);

	int upRegis(int id);

	void addRegis(RegistrationInfor regis);
}