package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(
		name="DOCTOR_GEN",
	    table="GENERATOR_TABLE",
	    pkColumnName = "pk_key",
	    valueColumnName = "hi",
	    pkColumnValue="doctor",
	    allocationSize=1
)
/*Use TableGenerator
 * Create a table which is named GENERATOR_TABLE and includes two column
 * Column "Key" and column "hi"
 * set a value in column Key which is named teacher
 * then the table which is named teacher create id will get it form GENERATOR_TABLE
 * at the last the value of column hi do add by allocationSize
 * */
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="DOCTOR_GEN")
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	private int id;
	private String name;
	private String title;
	
}
