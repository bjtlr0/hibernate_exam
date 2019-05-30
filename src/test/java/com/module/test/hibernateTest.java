package com.module.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.module.database.config.HibernateSessionManager;
import com.module.database.dao.AccountDaoImpl;
import com.module.database.model.Account;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/resources/hibernate.cfg.xml"}
		)
public class hibernateTest {
	
	@Test @Ignore
	public void test(){
		/*sessionFactory = manager.buildSessionFactory();
		Session session = manager.getCurrentSession();
		Account account = new Account();
		account = (Account)session.get(Account.class,1);
		
		System.out.println(account.getAccountName());*/
	}
	@Test
	public void test2(){
		HibernateSessionManager.buildSessionFactory();
		AccountDaoImpl accountDao = new AccountDaoImpl();
		List<Account> list = accountDao.getAccountList();
		System.out.println(list.size());
	}
}
