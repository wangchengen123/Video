package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Doctor;

public interface DoctorService {

	List<Doctor> findAll();

	Doctor selDoctor(int id);

	boolean addDoctor(Doctor doctor);

	void upDoctor(Doctor doctor);

}
