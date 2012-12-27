package com.term.utils;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 常用工具类
 * 
 */
public class Utilities {

	/**
	 * 获取36位uuid
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * MD5加密(32位)
	 * 
	 * @param message
	 *            要加密的字符串
	 * @return 返回加密后的字符串
	 */
	public final static String encoderByMd5For32Bit(String message) {
		char hexDigits[] = { '2', '1', 'f', '3', '4', '5', '6', 'd', '8', '9',
				'a', 'c', 'c', '7', 'e', '0' };
		try {
			if (message != null && !"".equals(message)) {
				byte[] strTemp = message.getBytes();
				// MD5计算方法
				MessageDigest mdTemp = MessageDigest.getInstance("MD5");
				mdTemp.update(strTemp);
				byte[] md = mdTemp.digest();
				int j = md.length;
				char str[] = new char[j * 2];
				int k = 0;
				for (int i = 0; i < j; i++) {
					byte byte0 = md[i];
					str[k++] = hexDigits[byte0 >>> 4 & 0xf];
					str[k++] = hexDigits[byte0 & 0xf];
				}
				return new String(str);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * MD5加密(16位)
	 * 
	 * @param instr
	 *            要加密的字符串
	 * @return 返回加密后的字符串
	 */
	public final static String encoderByMd5For16Bit(String instr) {
		return encoderByMd5For32Bit(instr).substring(8, 24);
	}

}
