package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.entities.Account;

public interface AccountService {
	public List<Account> getAll();
	public Account getById(int id);
	public void transfer(int fromAccId, int toAccId, BigDecimal amount);
	public void deposit(int id , BigDecimal amount);
	public void withdraw(int id , BigDecimal amount);
	
	public Account addAccount(Account account);
	public void deleteAccount(int id);
}
