package com.bankapp.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.AccountDao;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAppException;
import com.bankapp.util.MyLogging;

@Transactional
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@PostConstruct
	public void doAfterBeanIsInit() {
		System.out.println("---------------------");
	}
	
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account = accountDao.getById(id);
		if (account == null)
			throw new BankAppException("account with id " + id + " is not found");
		return account;
	}

	@MyLogging
	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {

		Account fromAcc = getById(fromAccId);

		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance() - amount);

		toAcc.setBalance(toAcc.getBalance() + amount);

		accountDao.updateAccount(fromAcc);

		accountDao.updateAccount(toAcc);

	}

	@Override
	public void deposit(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance() + amount);
		accountDao.updateAccount(acc);

	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance() - amount);
		accountDao.updateAccount(acc);
	}

	@Override
	public void addAccount(Account account) {

	}

	@Override
	public void deleteAccount(int id) {

	}

}
