package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditOrganizationRequirementAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String organizationRequirementId;
	
	private OrganizationRequirement organizationRequirement;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Requirement";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			setOrganizationRequirement(organizationRequirementManager.getOrganizationRequirement(Integer.parseInt(organizationRequirementId)));
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
	 * @return the OrganizationRequirement
	 */
	public String getOrganizationRequirementId() {
		return organizationRequirementId;
	}

	public void setOrganizationRequirementId(String organizationRequirementId) {
		this.organizationRequirementId = organizationRequirementId;
	}
	
	
	public OrganizationRequirement getOrganizationRequirement() {
		return organizationRequirement;
	}

	/**
	 * @param OrganizationRequirement the OrganizationRequirement to set
	 */
	public void setOrganizationRequirement(OrganizationRequirement OrganizationRequirement) {
		this.organizationRequirement = OrganizationRequirement;
	}
	
}
