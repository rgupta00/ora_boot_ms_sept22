package com.bankapp.api;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import com.bankapp.util.ObjectConverter;
//i want to write curd application for REST

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

	// ---------get------getting all accounts--------
	@GetMapping(path = "accounts")
	public List<AccountDto> allAccounts() {
		return accountService.getAll().stream().map(ObjectConverter::convertToAccountDtoFromAccount)
				.collect(Collectors.toList());
	}

	// spring REST: pathvariable vs RequestParam
	// -------get--------getting one account by id--------
	@GetMapping(path = "accounts/{id}")
	public AccountDto getById(@PathVariable(name = "id") int accId) {
		return ObjectConverter.convertToAccountDtoFromAccount(accountService.getById(accId));
	}

	// ---------------add account--------
	@PostMapping(path = "accounts")
	public ResponseEntity<AccountDto> addAccount(@RequestBody @Valid AccountDto accountDto) {
		Account accountToSave = ObjectConverter.convertToAccountFromAccountDto(accountDto);
		accountToSave= accountService.addAccount(accountToSave);
		AccountDto accountDtoSaved = ObjectConverter.convertToAccountDtoFromAccount(accountToSave);
		return ResponseEntity.status(HttpStatus.CREATED).body(accountDtoSaved);
	}

	// ---------------delete account--------
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleleAccount(@PathVariable(name = "id") int accId) {
		accountService.deleteAccount(accId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
