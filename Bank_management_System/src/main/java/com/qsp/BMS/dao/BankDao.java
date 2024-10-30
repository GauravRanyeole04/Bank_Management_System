package com.qsp.BMS.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.qsp.BMS.dto.Bank;

public class BankDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("developer");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveBank(Bank bank) {
		et.begin();
		em.merge(bank);
		et.commit();
	}
	public void upadateBank(Bank bank) {
		et.begin();
		em.merge(bank);
		et.commit();
	}
	public void deleteBank(Bank bank) {
			et.begin();
			em.remove(bank);
			et.commit();
	}
	public Bank findBankById(int id) {
		Bank bank =em.find(Bank.class,id);
		return bank;
	}
	public List<Bank> getAllBanks(){
		Query query = em.createQuery("select a from bank a");
		return query.getResultList();
	}
}
