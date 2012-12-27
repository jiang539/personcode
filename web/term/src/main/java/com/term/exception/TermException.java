package com.term.exception;

import com.term.common.config.Resource;

/**
 * TERM项目根异常
 */
public class TermException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TermException() {
		super();
	}

	public TermException(String key, Throwable cause) {
		super(Resource.getString(key), cause);
	}

	public TermException(String key) {
		super(Resource.getString(key));
	}

	public TermException(Throwable cause) {
		super(cause);
	}

}
