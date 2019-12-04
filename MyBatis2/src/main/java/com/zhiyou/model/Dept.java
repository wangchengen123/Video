package com.zhiyou.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable{
	
	private Integer deptno;
	private String dname;
	private String loc;
	//一个部门中需要注入多个员工
	private List<Emp> emps;
	
	public Dept(Object object, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

}
