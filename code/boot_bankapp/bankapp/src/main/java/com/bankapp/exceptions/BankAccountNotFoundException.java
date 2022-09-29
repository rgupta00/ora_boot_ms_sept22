package com.bankapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BankAccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6115120847499794478L;

	public BankAccountNotFoundException(String message) {
		super(message);
	}
}
