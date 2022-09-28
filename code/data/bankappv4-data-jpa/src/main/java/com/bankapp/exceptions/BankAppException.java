package com.bankapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BankAppException extends RuntimeException{

	private static final long serialVersionUID = 7399390285313579019L;

	public BankAppException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
