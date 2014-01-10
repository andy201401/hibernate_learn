package com.hibernate.model;

import static com.hibernate.model.Util4Test.colseSessionfactory;
import static com.hibernate.model.Util4Test.createSessionfactory;
import static com.hibernate.model.Util4Test.getSession;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	
	//´´½¨SessionFactory
	@BeforeClass
	//use @BeforeClass This method will always execute before the Object be instantiate 
	public static void beforClass(){
		createSessionfactory();
	}
	
	//¹Ø±ÕSessionFactory
	@AfterClass
	//use @AfterClass This method will always execute after the Object be recycled 
	public static void afterClass(){
		colseSessionfactory();
	}
	
	@Test
	public void testTecherSave() {
		//Instance an object Which typed Teacher for save
		StudentPK stp = new StudentPK();
		stp.setId(1);
		stp.setSid("123");
		Student s = new Student();
		s.setStp(stp); 
		s.setName("andy");
		s.setAge(12);
		
		//open session and save data
		Session session = getSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
}
