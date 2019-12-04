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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void upDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}


	

}
