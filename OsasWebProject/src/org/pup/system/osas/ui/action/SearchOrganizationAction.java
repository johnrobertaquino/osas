package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchOrganizationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777267392504750903L;

	private String organizationSearchText;
	
	private List<Organization> organizationList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			setOrganizationList(organizationManager.getOrganizationListByOrganizationSearchText(organizationSearchText));
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
	public String getOrganizationSearchText() {
		return organizationSearchText;
	}

	/**
	 * @param agencySearchText the agencySearchText to set
	 */
	public void setOrganizationSearchText(String organizationSearchText) {
		this.organizationSearchText = organizationSearchText;
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
