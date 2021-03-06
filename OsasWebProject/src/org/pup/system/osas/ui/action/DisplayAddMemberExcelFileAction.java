package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayAddMemberExcelFileAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;

	private List<Organization> organizationList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Member";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			OrganizationManager organizationManager = new OrganizationManager();
			organizationList = organizationManager.getOrganizationList(getCurrentActiveTerm().getSemTermId());	
		} catch (BusinessException be) {
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}
		
		return actionResult;
	}

	/**
	 * @return the organizationList
	 */
	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	/**
	 * @param organizationList the organizationList to set
	 */
	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

}
