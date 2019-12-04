package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.DoctorMapper;
import com.zhiyou.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorMapper mapper;
	
	
	@Override
	public List<Doctor> findAll() {
		return mapper.findAll();
	}


	@Override
	public Doctor selDoctor(int id) {
		return mapper.selDoctor(id);
	}


	@Override
	public boolean addDoctor(Doctor doctor) {
		int num = mapper.addDoctor(doctor);
		if(num > 0) {
			return true;
		}
		return false;
	}


	@Override
	public void upDoctor(Doctor doctor) {
		mapper.upDoctor(doctor);
	}

}
