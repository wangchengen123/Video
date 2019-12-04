package com.zhiyou.mapper;

import com.zhiyou.model.Drug;

public interface DrugMapper {
    int deleteByPrimaryKey(String drugNum);

    int insert(Drug record);

    int insertSelective(Drug record);

    Drug selectByPrimaryKey(String drugNum);

    int updateByPrimaryKeySelective(Drug record);

    int updateByPrimaryKey(Drug record);
}