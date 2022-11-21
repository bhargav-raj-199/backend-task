package com.pdftotext.exceptions;

/**
 * @author BhargavRajJinka
 *
 */
public class CannotParseException extends RuntimeException {

	/**
	 * 
	 */
	public CannotParseException() {
		super();
		
	}

	/**
	 * @param message to give message for user
	 */
	public CannotParseException(String message) {
		super(message);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
