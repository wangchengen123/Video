package com.zhiyou.service;

import java.util.List;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.RegistrationInforMapper;
import com.zhiyou.model.RegistrationInfor;

@Service
public class RegisServiceImpl implements RegisService{

	@Autowired
	private RegistrationInforMapper mapper;
	
	@Override
	public List<RegistrationInfor> findAll() {
		return mapper.findAll();
	}

	@Override
	public void delRegis(String id) {
		mapper.delRegis(id);
	}

	@Override
	public RegistrationInfor selRegis(int id) {
		
		return mapper.selRegis(id);
	}

	@Override
	public boolean upRegis(int id) {
		int num = mapper.upRegis(id);
		if(num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void addRegis(RegistrationInfor regis) {
		mapper.addRegis(regis);
	}

}
