package com.zhiyou.model;


import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable{
	
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;
	// 多对1 每个员工都有部门信息
	private Dept dept;
	
	
	public Emp(Object object, String string, String string2, Object object2, Date date, Object object3, Object object4,
			int i, Dept dept) {
		// TODO Auto-generated constructor stub
	}

}
