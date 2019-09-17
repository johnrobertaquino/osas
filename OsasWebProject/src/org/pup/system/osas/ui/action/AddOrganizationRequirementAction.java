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
	
	private static final String FORWARD_DISPLAYADDORGANIZATIONREQUIREMENT = "displayAddOrganizationRequirement";

	private int organizationRequirementId;
	
	private String organizationRequirementName;

	private String organizationId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Requirements";

		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(Integer.parseInt(organizationId));
	
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			
			OrganizationRequirement existingOrganizationRequirement = null;
			existingOrganizationRequirement = organizationRequirementManager.validate(organizationRequirementName);
			
			if(existingOrganizationRequirement != null && organizationRequirementId != existingOrganizationRequirement.getOrganizationRequirementId())
			{
				notificationMessage = "Organization Requirement already exist.";
				return FORWARD_DISPLAYADDORGANIZATIONREQUIREMENT;
			}
			else {
				OrganizationRequirement organizationRequirement = new OrganizationRequirement();
				organizationRequirement.setOrganizationRequirementName(organizationRequirementName);
				organizationRequirement.setOrganization(organization);

				organizationRequirementManager = new OrganizationRequirementManager();
				organizationRequirementManager.insertOrganizationRequirement(organizationRequirement);

				notificationMessage = "Organization Requirement has been successfully added.";
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


}
