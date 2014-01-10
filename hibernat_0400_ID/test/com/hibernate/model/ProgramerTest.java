package com.hibernate.model;

import static com.hibernate.model.Util4Test.colseSessionfactory;
import static com.hibernate.model.Util4Test.createSessionfactory;
import static com.hibernate.model.Util4Test.getSession;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProgramerTest {
	
	@BeforeClass
	public static void beforClass(){
		createSessionfactory();
	}
	

	@AfterClass
	public static void afterClass(){
		colseSessionfactory();
	}
	
	@Test
	public void testProgramerSave() {
		ProgramerPK pp = new ProgramerPK();
		pp.setId(1);
		pp.setSid("111");
		Programer p = new Programer();
		p.setPp(pp);
		p.setName("andy");
		p.setTitle("ÖÐ¼¶");
		
		Session session = getSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

}
