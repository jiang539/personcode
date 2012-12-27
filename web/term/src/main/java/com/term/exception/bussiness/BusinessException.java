/**
 * 
 */

package com.term.exception.bussiness;

import com.term.exception.TermException;

/**
 * 业务层根异常
 */
public class BusinessException extends TermException {

	public BusinessException(String key) {
		super(key);
	}

	public BusinessException(String key, Throwable t) {
		super(key, t);
	}

}
