package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAppException;
import com.bankapp.repository.AccountRepo;
import com.bankapp.util.MyLogging;

@Transactional
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;

	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int id) {
		return accountRepo.findById(id).orElseThrow(() -> new BankAppException("bank account " + id + " is not found"));
	}

	@MyLogging
	@Override
	public void transfer(int fromAccId, int toAccId, double amount) {

		Account fromAcc = getById(fromAccId);

		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance() - amount);

		toAcc.setBalance(toAcc.getBalance() + amount);

		accountRepo.save(fromAcc);

		accountRepo.save(toAcc);

	}

	@Override
	public void deposit(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance() + amount);
		accountRepo.save(acc);

	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance() - amount);
		accountRepo.save(acc);
	}

	@Override
	public void addAccount(Account account) {
		accountRepo.save(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account account=getById(id);
		accountRepo.delete(account);
	}
}
