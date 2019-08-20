package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteOrganizationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2914771763486431991L;

	private int organizationId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organizaton = organizationManager.getOrganization(organizationId);
			organizationManager.deleteOrganization(organizaton);
			notificationMessage = "User has been successfully deleted.";
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
	 * @return the agencyId
	 */
	public int getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	
}
