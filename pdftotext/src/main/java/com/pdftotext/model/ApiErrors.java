package com.pdftotext.model;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;



/**
 * @author BhargavRajJinka
 *
 */
public class ApiErrors {

	LocalDateTime timestamp;
	String message;
	HttpStatus status;
	int statusCode;
	String error;
	
	
	
	
	
	/**
	 * @param timestamp set timestamp
	 * @param message to set message
	 * @param status to set status
	 * @param statusCode to set status code
	 * @param error to set error
	 */
	public ApiErrors(LocalDateTime timestamp, String message, HttpStatus status, int statusCode, String error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.error = error;
	}
	/**
	 * 
	 */
	public ApiErrors() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 *
	 */
	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", message=" + message + ", status=" + status + ", statusCode="
				+ statusCode + ", error=" + error + "]";
	}
	
	
}
