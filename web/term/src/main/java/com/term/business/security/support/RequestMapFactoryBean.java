package com.term.business.security.support;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.intercept.web.DefaultFilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.RequestKey;
import org.springframework.security.util.AntUrlPathMatcher;
import org.springframework.security.util.UrlMatcher;

import com.term.business.security.ISecurityManager;

/**
 * 请在此加入你的功能说明
 * 
 * @author 李国江
 * @date 2009-4-9 下午01:21:57
 */
public class RequestMapFactoryBean implements FactoryBean {

	private ISecurityManager securityManager;

	@Autowired
	public void setSecurityManager(ISecurityManager securityManager) {
		this.securityManager = securityManager;
	}

	@Override
	public Object getObject() throws Exception {
		LinkedHashMap<RequestKey, ConfigAttributeDefinition> requestMap = securityManager
				.loadUrlAuthorities();
		UrlMatcher matcher = getUrlMatcher();
		DefaultFilterInvocationDefinitionSource definitionSource = new DefaultFilterInvocationDefinitionSource(
				matcher, requestMap);
		return definitionSource;
	}

	@Override
	public Class getObjectType() {
		return FilterInvocationDefinitionSource.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	private UrlMatcher getUrlMatcher() {
		return new AntUrlPathMatcher();
	}

}
