package org.pup.system.osas.ui.interceptor;

import java.util.Map;

import org.pup.system.osas.core.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class FirstTimeLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5010482362494444016L;
	
	private static final String USER = "USER";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> userSession = invocation.getInvocationContext().getSession();
		
		if (userSession.get(USER) != null) {
			String actionName = invocation.getInvocationContext().getName();
			if(!(
					"logout".equalsIgnoreCase(actionName) ||
					"displayFirstTimeLogin".equalsIgnoreCase(actionName) ||
					"firstTimeLogin".equalsIgnoreCase(actionName) ||
					"displayPasswordReset".equalsIgnoreCase(actionName) ||
					"passwordReset".equalsIgnoreCase(actionName)
				)) {
				User user = (User) userSession.get(USER);
				
				if("FL".equals(user.getFirstTimeLoginReference().getFirstTimeLoginCode())) {
					return "redirectToFirstTimeLogin";
				}
				else if("PR".equals(user.getFirstTimeLoginReference().getFirstTimeLoginCode())) {
					return "redirectToPasswordReset";
				}
			}
			
		}
		
		return invocation.invoke();
	}

}
