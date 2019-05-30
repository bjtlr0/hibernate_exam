package com.module.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.module.database.config.HibernateSessionManager;
import com.module.database.model.Account;

public class AccountDaoImpl implements AccountDao{
	@Autowired
	private HibernateSessionManager sessionManager;
	
	@Override
	public void save(Account a) {
	}

	@Override
	public List<Account> getAccountList() {
		List<Account> list = new ArrayList<Account>();
		Session session = null;
		try{
			session = sessionManager.getSession();
			list = session.createCriteria(Account.class).list();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			sessionManager.closeSession(session);
		}
		return list;
	}

}
