package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping("api")
public class AccountTxApi {
	private AccountService accountService;

	@Autowired
	public AccountTxApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//--------transfer-----------
	
	@PostMapping(path = "transfer")
	public String transfer(@RequestBody TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(), transferDto.getAmount());
		return "transfer is done";
	}
	
	@PostMapping(path = "deposit")
	public String deposit(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "deposit done successfully";
	}
	
	//--------withdraw-----------
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody WithdrawDto withdrawDto) {
		accountService.deposit(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "withdraw done successfully";
	}
}
