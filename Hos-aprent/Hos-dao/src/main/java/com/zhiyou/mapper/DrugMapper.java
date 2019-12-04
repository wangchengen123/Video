package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import com.zhiyou.model.Drug;

public interface DrugMapper {
	List<Drug> findAll(Map<String, String> map);

	void addDrug(Drug drug);
	
	Drug selDrug(String id);
	
	void upDrug(Drug drug);

	
	
	
	int deleteByPrimaryKey(String drugNum);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(String drugNum);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);








}