package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Drug;

public interface MedicineService {

	List<Drug> findAll(String drugName);

	void addDrug(Drug drug);

	Drug selDrug(String id);

	void upDrug(Drug drug);

}
