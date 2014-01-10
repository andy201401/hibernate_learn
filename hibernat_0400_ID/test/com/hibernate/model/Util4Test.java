package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util4Test {

	private static SessionFactory sf;
	
	public static void createSessionfactory(){
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static void colseSessionfactory(){
		sf.close();
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
}
