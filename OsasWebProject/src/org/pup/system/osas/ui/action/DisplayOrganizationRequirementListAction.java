package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayOrganizationRequirementListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426112992716352970L;
	
	private List<OrganizationRequirement> organizationRequirementList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Requirement";
		
		String actionResult = FORWARD_SUCCESS;

		try {			
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			setOrganizationRequirementList(organizationRequirementManager.getOrganizationRequirementList(getCurrentActiveTerm().getSemTermId()));
			
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
	 * @return the OrganizationRequirementList
	 */
	public List<OrganizationRequirement> getOrganizationRequirementList() {
		return organizationRequirementList;
	}

	/**
	 * @param OrganizationRequirementList the OrganizationRequirementList to set
	 */
	public void setOrganizationRequirementList(List<OrganizationRequirement> organizationRequirementList) {
		this.organizationRequirementList = organizationRequirementList;
	}

}
