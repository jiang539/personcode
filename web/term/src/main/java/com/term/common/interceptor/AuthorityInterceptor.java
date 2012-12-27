package com.term.common.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 验证用户是不登陆
 * 
 * @author 李国江
 * @date 2009-6-5
 */
public class AuthorityInterceptor extends AbstractInterceptor {
	private Log log = LogFactory.getLog(getClass());

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		Object user = session.get("user");
		String actionName = invocation.getProxy().getActionName();
		if (user != null || actionName.equals("login")
				|| actionName.equals("loginin")) {
			try {
				return invocation.invoke();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw e;
			}
		}
		return Action.LOGIN;
	}

}
