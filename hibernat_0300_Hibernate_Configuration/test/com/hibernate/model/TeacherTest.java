package com.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {

	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforClass(){
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
	
	@Test
	public void testTeacherSave() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("andy");
		t.setTitle("ÖÐ¼¶");
		t.setBrithDate(new Date());
		t.setZhicheng(Zhicheng.A);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testStudentSave() {
		Student s = new Student();
		s.setId(1);
		s.setName("andy");
		s.setAge(12);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

}
