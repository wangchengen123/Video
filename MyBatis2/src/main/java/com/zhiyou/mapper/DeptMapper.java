package com.zhiyou.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.Dept;

public interface DeptMapper {
	
	void add(Dept dept);
	void delete(int id);
	void update(Dept dept);
	List<Dept> selectAll();
	Dept selectByID(int id);
	Dept selectByNameAndByLoc(String danme,String loc);
	Dept selectByNameAndByLoc(Map<String, String> map);
	Dept selectByNmaeAndByLoc(@Param("dname")String dname,@Param("locc")String loc);
	List<Dept> selectAllOrderBy(@Param("n")String n);
	
}
