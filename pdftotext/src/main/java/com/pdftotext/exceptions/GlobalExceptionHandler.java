package com.pdftotext.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pdftotext.model.ApiErrors;


/**
 * @author BhargavRajJinka
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/**
	 *
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String error="Request Method not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error="Media Type not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error="Missing PathVariable not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error="Missing Request Parameter not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error="Type mismatch";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	
	/**
	 * @param exception it will get thrown exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(CannotParseException.class)
	public ResponseEntity<Object> handleCannotParseException(CannotParseException exception){
		String error="Text Not Found (given file does not contains text)";
		String message=exception.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message, HttpStatus.EXPECTATION_FAILED,HttpStatus.EXPECTATION_FAILED.value(), error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
	}
	
	/**
	 * @param exception it will get thrown exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(EmptyFileException.class)
	public ResponseEntity<Object> handleEmptyFileException(EmptyFileException exception){
		String error="File Field is Empty or Giving Blank file or giving file with single image";
		String message=exception.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message, HttpStatus.EXPECTATION_FAILED,HttpStatus.EXPECTATION_FAILED.value(), error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
	}
	
	/**
	 * @param exception it will get thrown exception
	 * @return ResponseEntity
	 */
	@ExceptionHandler(InvalidFileException.class)
	public ResponseEntity<Object> handleInvalidFileException(InvalidFileException exception){
		String error="Providing wrong file";
		String message=exception.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message, HttpStatus.EXPECTATION_FAILED,HttpStatus.EXPECTATION_FAILED.value(), error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(errors);
	}
	
	

}
