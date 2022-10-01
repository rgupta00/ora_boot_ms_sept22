package com.bankapp.util;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorInfoDto;
import com.bankapp.exceptions.BankAppException;

@RestControllerAdvice //used to tranfer the flow using AOP
public class BankAppExHandler {

	@ExceptionHandler(BankAppException.class)
	public ResponseEntity<ErrorInfoDto> handle404(BankAppException exception){
		ErrorInfoDto dto=new ErrorInfoDto();
		dto.setDateTime(LocalDateTime.now());
		dto.setErrorcode("404");
		dto.setTocontact("admin.oracle@oracle.com");
		dto.setMessage(exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfoDto> handle400(MethodArgumentNotValidException exception){
		ErrorInfoDto dto=new ErrorInfoDto();
		dto.setDateTime(LocalDateTime.now());
		dto.setErrorcode("400");
		dto.setTocontact("admin.oracle@oracle.com");
		//extract out the validation message
		String errorMessage= exception.getBindingResult()
				.getAllErrors()
				.stream()
				.map(x-> x.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		
		dto.setMessage(errorMessage);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}
	
	
	//catch all
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfoDto> handle500(Exception exception){
		ErrorInfoDto dto=new ErrorInfoDto();
		dto.setDateTime(LocalDateTime.now());
		dto.setErrorcode("500");
		dto.setTocontact("admin.oracle@oracle.com");
		dto.setMessage("pls try afer some time");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}
}
