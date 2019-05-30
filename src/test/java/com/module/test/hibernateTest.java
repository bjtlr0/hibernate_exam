package com.module.test;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.module.database.config.HibernateSessionManager;
import com.module.database.dao.AccountDaoImpl;
import com.module.database.model.Account;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( // Autowired가 왜 안되는지 모르고 삽질하다가, 필요한 class를 선언해주면 된다는걸 알게됐다...
		classes={HibernateSessionManager.class,
				AccountDaoImpl.class
				}
		/*locations={"file:src/main/resources/hibernate.cfg.xml"}*/
		)
public class hibernateTest {
	@Autowired
	HibernateSessionManager hsManager;
	
	@Autowired
	AccountDaoImpl accountDao;
	
	@Test @Ignore
	public void test(){
		/*sessionFactory = manager.buildSessionFactory();
		Session session = manager.getCurrentSession();
		Account account = new Account();
		account = (Account)session.get(Account.class,1);
		
		System.out.println(account.getAccountName());*/
	}
	
	@Before
	public void setUp(){
		hsManager.buildSessionFactory();
	}
	
	@Test
	public void test2(){
//		AccountDaoImpl accountDao = new AccountDaoImpl();
		List<Account> list = accountDao.getAccountList();
		System.out.println(list.size());
	}
}
