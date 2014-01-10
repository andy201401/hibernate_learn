package com.hibernate.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Programer {
	
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
	@EmbeddedId
	//use many of columns be ID
	public ProgramerPK getPp() {
		return pp;
	}
	public void setPp(ProgramerPK pp) {
		this.pp = pp;
	}

	private ProgramerPK pp;
	private String name;
	private String title;
	
}
