package com.jogadavelha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jogadavelha.exception.ResourceException.ResponseCode;


public class JogoDaVelhaResponseCode<T extends MessageCodeable> extends ResponseEntity<T> {
	public JogoDaVelhaResponseCode(T responseObject, ResponseCode responseCode, String message) {
		super(responseObject, HttpStatus.valueOf(responseCode.getHttpStatus()));
		responseObject.setCode(responseCode.getInternalCode());
		responseObject.setMessage(message);
	}
}