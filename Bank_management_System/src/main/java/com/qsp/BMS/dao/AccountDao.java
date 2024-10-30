package com.qsp.BMS.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.qsp.BMS.dto.Account;

public class AccountDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("developer");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveAccount(Account account) {
		et.begin();
		em.merge(account);
		et.commit();
	}
	public void upadateAccount(Account account) {
		et.begin();
		em.merge(account);
		et.commit();
	}
	public boolean deleteAccount(Account account) {
		Account account2 = findAccountById(account.getId());
		if(account2!=null) {
			et.begin();
			em.remove(account);
			et.commit();
			return true;
		}
		return false;
	}
	public Account findAccountById(int id) {
		Account account =em.find(Account.class,id);
		return account;
	}
	public List<Account> getAllAccounts(){
		Query query = em.createQuery("select a from Account a");
		return query.getResultList();
	}
} 
