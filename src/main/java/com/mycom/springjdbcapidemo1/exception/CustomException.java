package com.mycom.springjdbcapidemo1.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private int errorCode = 400; // default error code
	private boolean printStackTrace = false;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public CustomException(int errorCode, String message, boolean printStackTrace) {
		super(message);
		this.errorCode = errorCode;
		this.printStackTrace = printStackTrace;
	}

}