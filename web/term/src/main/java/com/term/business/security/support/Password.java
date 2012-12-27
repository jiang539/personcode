package com.term.business.security.support;

import org.springframework.dao.DataAccessException;
import org.springframework.security.providers.encoding.PasswordEncoder;

import com.term.utils.Utilities;

/**
 * 用户登陆密码加密后,与数据库比较.验证用户合法性
 * 
 * @author 李国江
 * @date 2009-4-10 上午11:42:52
 */
public class Password implements PasswordEncoder {

	@Override
	public String encodePassword(String rawPass, Object salt)
			throws DataAccessException {
		return Utilities.encoderByMd5For32Bit(salt + rawPass);
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt)
			throws DataAccessException {
		if (encPass.equals(encodePassword(rawPass, salt))) {
			return true;
		}
		return false;
	}

}
