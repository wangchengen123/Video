package com.zhiyou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.DrugMapper;
import com.zhiyou.model.Drug;

@Service
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private DrugMapper mapper;
	
	
	@Override
	public List<Drug> findAll(String drugName) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("drugName", drugName);
		return mapper.findAll(map);
	}


	@Override
	public void addDrug(Drug drug) {
		mapper.addDrug(drug);
	}


	@Override
	public Drug selDrug(String id) {
		
		return mapper.selDrug(id);
	}


	@Override
	public void upDrug(Drug drug) {
		mapper.upDrug(drug);
	}

}
