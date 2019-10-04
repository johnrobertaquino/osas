package org.pup.system.osas.ui.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationRequirementQualification;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayOrganizationQualificationListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426112992716352970L;
	
	private List<OrganizationRequirementQualification> organizationRequirementQualificationList;
	
	private int organizationId;
	
	private String search;
	
	private String organizationQualificationSearchText;


	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			if ("Y".equals(search) && !StringUtils.isBlank(organizationQualificationSearchText)) {
				organizationRequirementQualificationList = organizationRequirementQualificationManager.searchOrganizationRequirementQualificationList(organizationQualificationSearchText, organizationId, getCurrentActiveTerm().getSemTermId());
			}else {
				organizationRequirementQualificationList = organizationRequirementQualificationManager.getOrganizationRequirementQualificationList(organizationId, getCurrentActiveTerm().getSemTermId());
			}
			
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			if (organization != null) {
				pageName = "Manage Organization > " + organization.getOrganizationName() + " > Qualifications";
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
	 * @return the organizationRequirementQualificationList
	 */
	public List<OrganizationRequirementQualification> getOrganizationRequirementQualificationList() {
		return organizationRequirementQualificationList;
	}

	/**
	 * @param organizationRequirementQualificationList the organizationRequirementQualificationList to set
	 */
	public void setOrganizationRequirementQualificationList(List<OrganizationRequirementQualification> organizationRequirementQualificationList) {
		this.organizationRequirementQualificationList = organizationRequirementQualificationList;
	}
	
	
	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getOrganizationQualificationSearchText() {
		return organizationQualificationSearchText;
	}

	public void setOrganizationQualificationSearchText(String organizationQualificationSearchText) {
		this.organizationQualificationSearchText = organizationQualificationSearchText;
	}
	
	
}
