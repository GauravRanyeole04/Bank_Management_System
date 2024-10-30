package com.qsp.BMS.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.qsp.BMS.dao.AccountDao;
import com.qsp.BMS.dao.BankDao;
import com.qsp.BMS.dto.Account;
import com.qsp.BMS.dto.Bank;

public class BMSController {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	AccountDao accountDao = new AccountDao();
	BankDao bankDao = new BankDao();

	do
	{
		System.out.println("1.Create Bank");
		System.out.println("2.Update Bank");
		System.out.println("3.Delete Bank");
		System.out.println("4.Fetch Bank");
		System.out.println("5.Fetch All");
		System.out.println("6.Give Account to Bank");
		switch (sc.nextInt()) {
		case 1: {
			Bank bank = new Bank();
			System.out.println("Enter bank name : ");
			bank.setName(sc.next());
			sc.nextLine();
			System.out.println("Enter bank Location : ");
			bank.setLocation(sc.nextLine());
			bankDao.saveBank(bank);
			System.out.println("Created");
		}
		break;
		case 2: {
			System.out.println("Enter id to Update : ");
			Bank bank = bankDao.findBankById(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter new Location : ");
			bank.setLocation(sc.nextLine());
			bankDao.upadateBank(bank);
			System.out.println("Updated");
		}
		break;
		case 3: {
			System.out.println("Enter id to Delete : ");
			Bank bank = bankDao.findBankById(sc.nextInt());
			bankDao.deleteBank(bank);
			System.out.println("Deleted");
		}
		break;
		case 4: {
			System.out.println("Enter id : ");
			Bank bank = bankDao.findBankById(sc.nextInt());
			System.out.println(bank);
		}
		break;
		case 5: {
			List<Bank> banks = bankDao.getAllBanks();
			for (Bank bank : banks) {
				System.out.println(bank);
				System.out.println("-----------------");
			}
		}
		break;
		case 6: {
			System.out.println("Enter Bank id : ");
			Bank bank = bankDao.findBankById(sc.nextInt());
			Account account = new Account();
			System.out.println("Enter Account Holder Name : ");
			account.setUserName(sc.next());
			System.out.println("Enter phone Number : ");
			account.setPhone(sc.nextLong());
			System.out.println("Enter Balance : ");
			account.setBalance(sc.nextDouble());

			account.setBank(bank);
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(account);

			bank.setAccounts(accounts);
			bankDao.upadateBank(bank);
			System.out.println("Account added");
		}
		break;
		default: {
			System.out.println("Wrong option");
			break;
		}
		}System.out.println("Enter Y to continue : ");
	}while("Y".equalsIgnoreCase(sc.next().toUpperCase()));
}}
