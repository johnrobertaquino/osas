package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.exception.BusinessException;	

public class EditOrganizationRequirementAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private int organizationRequirementId;
	
	private String organizationRequirementName;
	
	private String organizationId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Requirements";

		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationRequirementId);
			
			organizationRequirement.setOrganizationRequirementId(organizationRequirementId);
			organizationRequirement.setOrganizationRequirementName(organizationRequirementName);
			
			organizationRequirementManager.saveOrganizationRequirement(organizationRequirement);
			
			notificationMessage = "Changes to organization requirement has been saved successfully.";
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

	public int getOrganizationRequirementId() {
		return organizationRequirementId;
	}
	/**
	 * @param OrganizationRequirementName the OrganizationRequirementName to set
	 */
	public void setOrganizationRequirementId(int organizationRequirementId) {
		this.organizationRequirementId = organizationRequirementId;
	}
	
	public String getOrganizationRequirementName() {
		return organizationRequirementName;
	}

	public void setOrganizationRequirementName(String organizationRequirementName) {
		this.organizationRequirementName = organizationRequirementName;
	}

	/**
	 * @return the address
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param address the address to set
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

}
