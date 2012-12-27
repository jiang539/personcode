/**
 * 
 */

package com.term.exception.web;

import com.term.exception.TermException;

/**
 * action 层,前台处理抛出的异常
 */
public class WebException extends TermException {

	public WebException() {
		super();
	}

	public WebException(String s) {
		super(s);
	}

	public WebException(String s, Throwable t) {
		super(s, t);
	}

	public WebException(Throwable t) {
		super(t);
	}
}
