package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountUpdateDto;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
@Service
@Transactional
public class AccountServiceImp implements AccountService {

	private AccountRepo accountRepo;

	@Autowired
	public AccountServiceImp(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public void transfer(int from, int to, BigDecimal amount) {
		Account fromAccount = getById(from);
		Account toAccount = getById(to);

		fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
		toAccount.setBalance(toAccount.getBalance().add(amount));

		accountRepo.save(fromAccount);
		accountRepo.save(toAccount);

	}

	@Override
	public void deposit(int id, BigDecimal amount) {
		Account account = getById(id);
		account.setBalance(account.getBalance().add(amount));
		accountRepo.save(account);
	}

	@Override
	public Account getById(int id) {
		return accountRepo.findById(id)
				.orElseThrow(()-> new BankAccountNotFoundException("account with id "+ id +" is not found"));
	}

	@Override
	public void withdraw(int id, BigDecimal amount) {
		Account account = accountRepo.getById(id);
		account.setBalance(account.getBalance().add(amount));
		accountRepo.save(account);
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public void deleteAccount(int id) {
		Account accountToDelete= getById(id);
		accountRepo.delete(accountToDelete);
	}

	@Override
	public Account updateAccount(int accId, AccountUpdateDto accountUpdateDto) {
		Account accountToUpdate= getById(accId);
		accountToUpdate.setAddress(accountUpdateDto.getAddress());
		accountToUpdate.setPhone(accountUpdateDto.getPhone());
		accountRepo.save(accountToUpdate);
		return accountToUpdate;
	}
}






