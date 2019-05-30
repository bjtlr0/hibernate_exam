package com.module.database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.module.database.dao.AccountDaoImpl;

/**
 * Autowired를 수동으로 적용할 수 있는 방법으로 보인다.
 * JUnit 테스트에서 Autowired가 적용이 안되서 찾다보니 이 방법이 잇는데,
 * 결론 : 이것도 안된다.
 * */
/*@Configuration
public class ApplicationContextAutowiredType {
	@Bean
	public static AccountDaoImpl autowiredAccountDao(){
		AccountDaoImpl autowiredAccountDao = new AccountDaoImpl();
		return autowiredAccountDao;
	}
	
	@Bean
	public static HibernateSessionManager autowiredSessionManager(){
		HibernateSessionManager autowiredSessionManager = new HibernateSessionManager();
		return autowiredSessionManager;
	}
}
*/