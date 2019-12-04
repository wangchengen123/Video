package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.Emp;

public interface EmpMapper {
	
	void add(Emp emp);
	void delete(int id);
	void update(Emp emp);
	List<Emp> selectAll();
	Emp selectByID(int id);
}
