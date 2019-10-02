package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayAddOrganizationQualificationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	
	private int organizationRequirementId;
	
	private int organizationId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Requirements";

		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationRequirementId);
			
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			if (organization != null) {
				pageName = "Manage Organization > " + organization.getOrganizationName() + " > " + organizationRequirement.getOrganizationRequirementName() + " " ;
			}		
			
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
	 * @return the organizationRequirementId
	 */
	public int getOrganizationRequirementId() {
		return organizationRequirementId;
	}

	/**
	 * @param organizationRequirementId the organizationRequirementId to set
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
