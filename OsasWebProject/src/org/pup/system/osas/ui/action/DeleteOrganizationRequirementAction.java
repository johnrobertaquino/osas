package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteOrganizationRequirementAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4998330923614620844L;
	
	private int organizationRequirementId;
	
	private int organizationId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Requirements";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationRequirementId);
			organizationRequirementManager.deleteOrganizationRequirement(organizationRequirement);
			notificationMessage = "Organization requirement has been successfully deleted.";
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
	 * @return the OrganizationRequirementId
	 */
	public int getOrganizationRequirementId() {
		return organizationRequirementId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setOrganizationRequirementId(int organizationRequirementId) {
		this.organizationRequirementId = organizationRequirementId;
	}

	/**
	 * @return the organizationId
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

