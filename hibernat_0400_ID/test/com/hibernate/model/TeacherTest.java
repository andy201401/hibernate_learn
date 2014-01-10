package com.hibernate.model;

import static com.hibernate.model.Util4Test.colseSessionfactory;
import static com.hibernate.model.Util4Test.createSessionfactory;
import static com.hibernate.model.Util4Test.getSession;

import java.util.Date;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	
	//创建SessionFactory
	@BeforeClass
	//use @BeforeClass This method will always execute before the Object be instantiate 
	public static void beforClass(){
		createSessionfactory();
	}
	
	//关闭SessionFactory
	@AfterClass
	//use @AfterClass This method will always execute after the Object be recycled 
	public static void afterClass(){
		colseSessionfactory();
	}
	
	@Test
	public void testTecherSave() {
		//Instance an object Which typed Teacher for save
		Teacher t = new Teacher();
		t.setName("andy");
		t.setTitle("中级");
		t.setBrithDate(new  Date());
		t.setZhicheng(Zhicheng.A);
		
		//open session and save data
		Session session = getSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}
}
