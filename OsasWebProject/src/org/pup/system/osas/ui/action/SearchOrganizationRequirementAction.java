package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchOrganizationRequirementAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2343186915653890118L;
	
	private String organizationRequirementSearchText;
	
	private List<OrganizationRequirement> organizationRequirementList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Requirements";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			setOrganizationRequirementList(organizationRequirementManager.getOrganizationRequirementListByOrganizationRequirementSearchText(organizationRequirementSearchText));
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
	 * @return the agencySearchText
	 */
	public String getOrganizationRequirementSearchText() {
		return organizationRequirementSearchText;
	}

	/**
	 * @param agencySearchText the agencySearchText to set
	 */
	public void setOrganizationRequirementSearchText(String organizationRequirementSearchText) {
		this.organizationRequirementSearchText = organizationRequirementSearchText;
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
