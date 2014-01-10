package com.hibernate.model;

import static com.hibernate.model.Util4Test.colseSessionfactory;
import static com.hibernate.model.Util4Test.createSessionfactory;
import static com.hibernate.model.Util4Test.getSession;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DoctorTest {
	
	@BeforeClass
	public static void beforClass(){
		createSessionfactory();
	}
	

	@AfterClass
	public static void afterClass(){
		colseSessionfactory();
	}
	
	@Test
	public void testTecherSave() {
		Doctor d = new Doctor();
		d.setName("andy");
		d.setTitle("ÖÐ¼¶");
		
		Session session = getSession();
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		session.close();
	}

}
