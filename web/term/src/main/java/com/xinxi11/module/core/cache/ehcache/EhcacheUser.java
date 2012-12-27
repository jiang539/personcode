package com.xinxi11.module.core.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinxi11.module.core.cache.ICacheUser;
import com.xinxi11.module.core.cache.LoginUserInfo;
import com.xinxi11.web.qx.service.IUserService;

/**
 * ehcache缓存
 * 
 * @author 李国江
 * @date 2012-9-13 下午5:09:17
 */
@Service
public class EhcacheUser implements ICacheUser {

	@Autowired
	private IUserService userService;
	private static String cache_key = "loginUserId_";

	@Override
	public void cacheUser(String userId) throws Exception {
		LoginUserInfo loginUser = userService.findLoginUserInfo(userId);
		Element element = new Element(cache_key + userId, loginUser);
		findEhcache().put(element);
	}

	@Override
	public LoginUserInfo findCacheUser(String userId) {
		Element element = findEhcache().get(cache_key + userId);
		if (element == null || element.getValue() == null) {
			// 缓存中不存在用户,从数据库中查询
			return userService.findLoginUserInfo(userId);
		}
		return (LoginUserInfo) element.getValue();
	}

	@Override
	public void deleteCacheUser(String userId) {
		findEhcache().remove(cache_key + userId);
	}

	private Cache findEhcache() {
		CacheManager cacheManager = CacheManager.create();
		return cacheManager.getCache("loginUserCache");
	}

}
