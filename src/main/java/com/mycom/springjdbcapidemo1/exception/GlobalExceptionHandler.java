package com.mycom.springjdbcapidemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	private record ErrorResponseDto(int error_code, String error_message) {
	};

	// ดักจับ CustomException ที่เราสร้างเอง
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException ex) {

		ErrorResponseDto error = new ErrorResponseDto(
				ex.getErrorCode(),
				ex.getMessage());

		if (ex.isPrintStackTrace()) {
			log.error(ex.getMessage(), ex);
		} else {
			log.error(ex.getMessage());
		}

		return new ResponseEntity<>(error, ex.getErrorCode() == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.valueOf(ex.getErrorCode()));
	}

	// ดักจับ Exception ทั่วไปที่ไม่ได้คาดคิด (เช่น NullPointerException)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex) {

		ErrorResponseDto error = new ErrorResponseDto(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"เกิดข้อผิดพลาดบางอย่างในระบบ: " + ex.getMessage());
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}