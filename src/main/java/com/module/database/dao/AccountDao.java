package com.module.database.dao;

import java.util.List;

import com.module.database.model.Account;

public interface AccountDao{
	public void save(Account a);
	public List<Account> getAccountList();
}
