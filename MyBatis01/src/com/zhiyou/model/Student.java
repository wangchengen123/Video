package com.zhiyou.model;

import java.util.Date;

public class Student {
	
	private int sid;
	private String sname;
	private int age;
	private int score;
	private int cid;
	private int groupLeaderId;
	private String gender;
	private Date sbirthday;
	
	//添加 存储查询出的班级信息字段
	private ClassRoom classroom;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getGroupLeaderId() {
		return groupLeaderId;
	}

	public void setGroupLeaderId(int groupLeaderId) {
		this.groupLeaderId = groupLeaderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getSbirthday() {
		return sbirthday;
	}

	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}

	public ClassRoom getClassroom() {
		return classroom;
	}

	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + ", score=" + score + ", cid=" + cid
				+ ", groupLeaderId=" + groupLeaderId + ", gender=" + gender + ", sbirthday=" + sbirthday
				+ ", classroom=" + classroom + "]";
	}

	
	
	
}
