package com.zhiyou.model;

public class User {
	private Integer id;
	private String truename;
	private String username;
	private String password;
	private double money;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTruename() {
		return truename;
	}

	
	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", truename=" + truename + ", username=" + username + ", password=" + password
				+ ", money=" + money + ", age=" + age + "]";
	}

	public User(Integer id, String truename, String username, String password, double money, Integer age) {
		super();
		this.id = id;
		this.truename = truename;
		this.username = username;
		this.password = password;
		this.money = money;
		this.age = age;
	}

	public User() {
		super();
	}

}
