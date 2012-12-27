package com.term.common.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.term.business.security.UserHolder;

/**
 * 如果当前用户没有登陆,url会重定向到login.jsp页面
 */
public class EffectiveUserFilter implements Filter {

	private String loginUrl = "login.action";

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		String requestUrl = ((HttpServletRequest) request).getRequestURL()
				.toString();
		if ((!(requestUrl.contains("login.jsp") || requestUrl
				.contains("login.action")))
				&& UserHolder.getCurrentUser() == null
				&& response instanceof HttpServletResponse) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect(loginUrl);
			return;
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
