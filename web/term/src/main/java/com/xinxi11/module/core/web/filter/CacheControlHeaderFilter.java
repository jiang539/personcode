package com.xinxi11.module.core.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.xinxi11.module.core.web.servlet.ServletUtils;

/**
 * 为Response设置客户端缓存控制Header的Filter.
 * 
 * eg.在web.xml中设置
 * 	<filter>
 * 		<filter-name>cacheControlHeaderFilter</filter-name>
 * 		<filter-class>org.springside.modules.web.CacheControlHeaderFilter</filter-class>
 * 		<init-param>
 * 			<param-name>expiresSeconds</param-name>
 * 			<param-value>31536000</param-value>
 * 		</init-param>
 * 	</filter>
 * 	<filter-mapping>
 * 		<filter-name>cacheControlHeaderFilter</filter-name>
 * 		<url-pattern>/images/*</url-pattern>
 * 	</filter-mapping>
 * 
 * @author calvin
 */
public class CacheControlHeaderFilter implements Filter {

	private static final String PARAM_EXPIRES_SECONDS = "expiresSeconds";
	private long expiresSeconds;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		ServletUtils.setExpiresHeader((HttpServletResponse) res, expiresSeconds);
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) {
		String expiresSecondsParam = filterConfig.getInitParameter(PARAM_EXPIRES_SECONDS);
		if (expiresSecondsParam != null) {
			expiresSeconds = Long.valueOf(expiresSecondsParam);
		} else {
			expiresSeconds = ServletUtils.ONE_YEAR_SECONDS;
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}
}

