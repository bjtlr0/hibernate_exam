package com.module.database.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration; // 이게 일반적인 spring properties annotation이 아닌것에 포인트
import org.hibernate.internal.util.config.ConfigurationException;
import org.hibernate.service.ServiceRegistry;

/**
 * 많이 돌아왔는데 그냥 Manager클래스가 static함수를 활용하기로..
 * 
 * */
public class HibernateSessionManager {
	private static SessionFactory sessionFactory;
	public static void buildSessionFactory(){
		try{
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}catch(ConfigurationException configError){
			System.err.println(configError.getMessage());
		}catch(HibernateException hibernateError){
			System.err.println(hibernateError.getMessage());
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory creation Failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Session getSession(){
		// session 생서 시 추가할 내용이 있을까?
		return sessionFactory.openSession();
	}
}
