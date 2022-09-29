package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountUpdateDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class AccountCrudApi {

	private AccountService accountService;

	@Autowired
	public AccountCrudApi(AccountService accountService) {
		this.accountService = accountService;
	}

	// --------get all accounts-----------
	@GetMapping(path = "accounts")
	public List<Account> getAll() {
		return accountService.getAll();
	}

	// --------get by account id-----------
	@GetMapping(path = "accounts/{id}")
	public Account getAnAccount(@PathVariable(name = "id") int id) {
		return accountService.getById(id);
	}

	// --------add new account-----------
	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount(@RequestBody @Valid Account  account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addAccount(account));
	}

	// -------delete an existing account-----------
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleteAnAccount(@PathVariable(name = "id") int id) {
		accountService.deleteAccount(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	// --------update account details-----------

	@PutMapping(path = "accounts/{id}")
	public Account updateAccount(@PathVariable(name = "id") int id, @RequestBody AccountUpdateDto accountUpdateDto) {
		return accountService.updateAccount(id, accountUpdateDto);
	}

	
}
