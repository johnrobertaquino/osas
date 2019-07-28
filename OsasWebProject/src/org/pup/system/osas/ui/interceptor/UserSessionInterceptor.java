package org.pup.system.osas.ui.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserSessionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8129348136864572718L;
	
	private static final String USER = "USER";
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> userSession = invocation.getInvocationContext().getSession();
			
		if 	(userSession.get(USER) == null) {
				return "redirectToLogin";
		}
		return invocation.invoke();
	}

}
