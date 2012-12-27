/**
 * 
 */
package com.term.business.security;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.intercept.web.RequestKey;

public interface ISecurityManager {

	LinkedHashMap<RequestKey, ConfigAttributeDefinition> loadUrlAuthorities();

	Map<String, String> loadStringUrlAuthorities();

}
