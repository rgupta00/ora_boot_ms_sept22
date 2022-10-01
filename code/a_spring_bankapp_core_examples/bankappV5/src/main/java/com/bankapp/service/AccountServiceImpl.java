package com.bankapp.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountUpdateDto;
import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionHistory;
import com.bankapp.exceptions.BankAppException;
import com.bankapp.repository.AccountRepo;
import com.bankapp.util.MyLogging;

@Transactional
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;

	private TransactionHistoryService transactionHistoryService;
	

	public AccountServiceImpl(AccountRepo accountRepo, TransactionHistoryService transactionHistoryService) {
		this.accountRepo = accountRepo;
		this.transactionHistoryService = transactionHistoryService;
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int id) {
		return accountRepo.findById(id)
				.orElseThrow(() -> new BankAppException("bank account " + id + " is not found"));
	}

	@MyLogging
	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {

		Account fromAcc = getById(fromAccId);

		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));

		toAcc.setBalance(toAcc.getBalance().add(amount));

		accountRepo.save(fromAcc);

		accountRepo.save(toAcc);
		
		transactionHistoryService
		.addTransactionHistory(new TransactionHistory(fromAccId, toAccId, amount, "transfer", LocalDateTime.now()));

	}

	@Override
	public void deposit(int id, BigDecimal amount) {
		Account acc = getById(id);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.save(acc);
		transactionHistoryService
		.addTransactionHistory(new TransactionHistory(id, id, amount, "deposit", LocalDateTime.now()));
	}

	@Override
	public void withdraw(int id, BigDecimal amount) {
		Account acc = getById(id);

		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.save(acc);
		
		transactionHistoryService
		.addTransactionHistory(new TransactionHistory( id, id, amount, "withdraw", LocalDateTime.now()));
	}

	@Override
	public Account addAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public void deleteAccount(int id) {
		Account account=getById(id);
		accountRepo.delete(account);
	}

	@Override
	public Account updateAccount(int accId, AccountUpdateDto accountUpdateDto) {
		Account accountToUpdate=getById(accId);
		accountToUpdate.setAddress(accountUpdateDto.getAddress());
		accountToUpdate.setPhone(accountUpdateDto.getPhone());
		accountRepo.save(accountToUpdate);
		
		return accountToUpdate;
	}
}
