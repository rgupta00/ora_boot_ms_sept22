package com.bankapp.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorInfoDto {
	private String message;
	private String errorcode;
	private String tocontact;
	private LocalDateTime dateTime;
}
