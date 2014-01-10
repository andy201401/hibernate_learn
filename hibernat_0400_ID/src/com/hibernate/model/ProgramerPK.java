package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

public class ProgramerPK implements Serializable{
	private int id;
	private String sid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof ProgramerPK){
			ProgramerPK sp = (ProgramerPK)o;
			if(this.id == sp.getId() && this.sid == sp.getSid()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.sid.hashCode();
	}
}
