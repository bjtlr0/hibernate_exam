package com.module.database.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration; // 이게 일반적인 spring properties annotation이 아닌것에 포인트
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateSessionManager {
	@Autowired
	private static SessionFactory sessionFactory;
	@Autowired
	private static Session session;
	
	public static void buildSessionFactory(){
		// config instance생성 
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		// hibernate cfg파일에 설정한 내용을 서비스레지스트에 등록한다.
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		// hibernate SessionFactory Instance를 생성한다.
		sessionFactory = config.buildSessionFactory(serviceRegistry);
//		return sessionFactory;
	}
	
	public Session getSession(){
		if (!session.isConnected()){
			buildSessionFactory();
		}
		if (!session.isOpen()){
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public void closeSession(Session session){
		/*if(session.isConnected()){
			session.disconnect();
		}*/
		if(session != null){
			if(session.isOpen()){
				session.close();
			}
			session = null;
		}
	}
}
