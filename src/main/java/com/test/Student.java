package com.test;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private int age;
	private String sex;
	private Date birth;

	public Student() {
		super();
	}

	public Student(int id, String name, int age, String sex, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
}