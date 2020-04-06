package com.sample.tms.exceptions;

/**
 * 
 * @author Gezahegn Tsegaye
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
