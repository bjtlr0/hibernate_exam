package com.module.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.module.database.config.HibernateSessionManager;
import com.module.database.model.Account;

public class AccountDaoImpl implements AccountDao{
	@Override
	public void save(Account a) {
		//
	}

	@Override
	public List<Account> getAccountList() {
		List<Account> list = new ArrayList<Account>();
		Session session=null;
		try{
			session = HibernateSessionManager.getSession();
			list = session.createCriteria(Account.class).list();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			if (session != null) {
				session.close();
				session = null;
			}
		}
		return list;
	}

}
