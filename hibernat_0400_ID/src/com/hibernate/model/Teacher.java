package com.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="_teacher")
//If Object name is not same as table's name£¬ use this annotate
public class Teacher {
	@Id
	@GeneratedValue
	//if you want to automate id. Just use @GeneratedValue
	//by default all database can automate id
	//When use Database which suport identity. just use @GeneratedValue(strategy = GenerationType.IDENTITY)
	//When use database which suport sequence. just use @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="_name")
	//If Object name is not same as column use this annotate
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
	//When you don't need to save this object to DB, just use @Transient
	public String getYourWifeName() {
		return yourWifeName;
	}
	public void setYourWifeName(String yourWifeName) {
		this.yourWifeName = yourWifeName;
	}
	
	@Temporal(TemporalType.DATE)
	//just save date and type integer database is Date
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
