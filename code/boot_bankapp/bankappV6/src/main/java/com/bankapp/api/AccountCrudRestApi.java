package com.bankapp.api;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountUpdateDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

//@RestController //=@Controller+ @ResponseBody
//@Controller
//@ResponseBody
@RestController
@RequestMapping(path = "api")
public class AccountCrudRestApi {
	private AccountService accountService;

	@Autowired
	public AccountCrudRestApi(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = "accounts")
	public List<Account> allAccounts() {
		return accountService.getAll();
	}

	
	@GetMapping(path = "accounts/{id}")
	public Account getById(@PathVariable(name = "id") int accId) {
		return accountService.getById(accId);
	}

	
	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount(@RequestBody @Valid Account account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addAccount(account));
	}

	// ---------------delete account--------
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleleAccount(@PathVariable(name = "id") int accId) {
		accountService.deleteAccount(accId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
	
	@PutMapping(path = "accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(name = "id")int accId, 
			AccountUpdateDto accountUpdateDto) {
		Account updateAccount = accountService.updateAccount(accId, accountUpdateDto);
		return ResponseEntity.status(HttpStatus.OK).body(updateAccount);

	}

}
