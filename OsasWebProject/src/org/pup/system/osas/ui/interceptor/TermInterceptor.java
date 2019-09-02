package org.pup.system.osas.ui.interceptor;

import java.util.Map;

import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.core.manager.SemTermManager;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TermInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8129348136864572718L;

	private static final String SEMTERM = "SEMTERM";

	private static final String USER = "USER";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> userSession = invocation.getInvocationContext().getSession();

		if (userSession.get(USER) != null) {
			String actionName = invocation.getInvocationContext().getName();
			if (	
					"processLogin".equalsIgnoreCase(actionName) ||
					"displayFirstTimeLogin".equalsIgnoreCase(actionName) ||
					"firstTimeLogin".equalsIgnoreCase(actionName) ||
					"displayPasswordReset".equalsIgnoreCase(actionName) ||
					"passwordReset".equalsIgnoreCase(actionName) ||
					"home".equalsIgnoreCase(actionName)
					) {

				SemTerm semTerm = null;

				try {
					SemTermManager semTermManager = new SemTermManager();

					semTerm = semTermManager.getCurrentActiveSemTerm();

					if (semTerm != null) {
						userSession.put(SEMTERM, semTerm);
						System.out.println("Current Sem Term is " + semTerm.getSemTermName());
					} else {
						System.out.println("No Active Term.");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}

		return invocation.invoke();
	}

}
