package com.hibernate.model;

public class Student {
	private StudentPK stp;
	private String name;
	private int age;
	public StudentPK getStp() {
		return stp;
	}
	public void setStp(StudentPK stp) {
		this.stp = stp;
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
}
