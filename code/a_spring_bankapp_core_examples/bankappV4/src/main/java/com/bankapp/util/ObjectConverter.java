package com.bankapp.util;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;

public class ObjectConverter {
	
	public static Account convertToAccountFromAccountDto(AccountDto dto) {
		Account account=new Account();
		account.setBalance(dto.getBalance());
		account.setId(dto.getId());
		account.setName(dto.getName());
		return account;
	}
	public static AccountDto convertToAccountDtoFromAccount(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setName(account.getName());
		return accountDto;
	}
}
