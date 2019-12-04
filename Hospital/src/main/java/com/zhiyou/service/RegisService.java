package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.RegistrationInfor;

public interface RegisService {

	List<RegistrationInfor> findAll();

	void delRegis(String id);

	RegistrationInfor selRegis(int id);

	boolean upRegis(int id);

	void addRegis(RegistrationInfor regis);


}
