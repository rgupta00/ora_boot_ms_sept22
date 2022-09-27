package com.bankapp.api;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
//i want to write curd application for REST

//@RestController //=@Controller+ @ResponseBody
//@Controller
//@ResponseBody
@RestController
@RequestMapping(path = "api")
public class AccountRestApi {
	private AccountService  accountService;

	@Autowired
	public AccountRestApi(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = "accounts")
	public List<Account> allAccounts() {
		return accountService.getAll();
	}
	
	//spring REST: pathvariable vs RequestParam
	
	@GetMapping(path = "accounts/{id}")
	public Account getById( @PathVariable(name = "id") int accId) {
		return accountService.getById(accId);
	}
	
	
//	@GetMapping(path = "hello")
//	public ModelAndView hello(ModelAndView mv) {
//		mv.setViewName("show");
//		mv.addObject("message", "we all are champs");
//		return mv;
//	}
}
