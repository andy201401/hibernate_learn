package com.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="_teacher")
public class Teacher {
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Transient
	public String getYourWifeName() {
		return yourWifeName;
	}
	public void setYourWifeName(String yourWifeName) {
		this.yourWifeName = yourWifeName;
	}
	@Temporal(TemporalType.DATE)//just save date and type int database is Date
	public Date getBrithDate() {
		return brithDate;
	}
	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}
	@Enumerated(EnumType.STRING)
	//use STRING will save a string in database witch you wrote in enumerate£»
	//use ORDINAL will save a integer type in database order by enumerate elements;
	public Zhicheng getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(Zhicheng zhicheng) {
		this.zhicheng = zhicheng;
	}


	private int id;
	private String name;
	private String title;
	private String yourWifeName;
	private Date brithDate;
	private Zhicheng zhicheng;
	
}
