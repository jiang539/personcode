package com.xinxi11.module.core.cache;


public interface ICacheUser {

	public void cacheUser(String userId) throws Exception;

	public LoginUserInfo findCacheUser(String userId);

	public void deleteCacheUser(String userId);
	
}
