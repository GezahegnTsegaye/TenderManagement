package com.tms.exceptions;

/**
 * 
 * @author Gezahegn
 *
 */
public final class UnauthorizedRequestedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public UnauthorizedRequestedException(String messages) {
		super(messages);
	}

}
