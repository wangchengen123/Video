package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.Doctor;

public interface DoctorMapper {
	
	List<Doctor> findAll();

	Doctor selDoctor(int id);
	
	int addDoctor(Doctor doctor);
	
	void upDoctor(Doctor doctor);
	

	
	
    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);












}