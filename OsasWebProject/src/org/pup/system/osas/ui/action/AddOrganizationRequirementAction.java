package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;

public class AddOrganizationRequirementAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89102832466116810L;

	private String organizationRequirementName;

	private String organizationId;


	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Requirement";

		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(Integer.parseInt(organizationId));
			
			OrganizationRequirement organizationRequirement = new OrganizationRequirement();
			organizationRequirement.setOrganizationRequirementName(organizationRequirementName);
			organizationRequirement.setOrganization(organization);

			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			organizationRequirementManager.insertOrganizationRequirement(organizationRequirement);

			notificationMessage = "Scholarship Qualification has been saved successfully added.";
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
	public String getOrganizationRequirementName() {
		return organizationRequirementName;
	}

	/**
	 * @param OrganizationRequirementId the OrganizationRequirementId to set
	 */
	public void setOrganizationRequirementName(String organizationRequirementName) {
		this.organizationRequirementName = organizationRequirementName;
	}
	
	/**
	 * @return the OrganizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param OrganizationRequirementId the OrganizationRequirementId to set
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}


}
