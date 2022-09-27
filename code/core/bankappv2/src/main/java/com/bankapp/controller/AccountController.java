package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.service.AccountService;
@Controller
public class AccountController {
	private AccountService  accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}


	@GetMapping(path = "allaccounts")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("accounts");
		mv.addObject("accountsList", accountService.getAll());
		return mv;
	}
	
	
	
//	@GetMapping(path = "hello")
//	public ModelAndView hello(ModelAndView mv) {
//		mv.setViewName("show");
//		mv.addObject("message", "we all are champs");
//		return mv;
//	}
}
