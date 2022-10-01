package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
@RestController
@RequestMapping(path = "api")
public class AccountTxRestApi {

	private AccountService  accountService;

	@Autowired
	public AccountTxRestApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//---------------transfer fund--------
	
	@PostMapping(path = "transfer")
	public String transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),  transferDto.getToAccId(), transferDto.getAmount());
		return "transfer is done";
	}
	
	
	//---------------deposit fund--------
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "withdraw is done";
	}
	
	//---------------withdraw fund--------
	@PostMapping(path = "deposit")
	public String deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "deposit is done";
	}
}

