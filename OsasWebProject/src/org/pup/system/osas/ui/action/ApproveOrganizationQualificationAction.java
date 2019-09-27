package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationQualification;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class ApproveOrganizationQualificationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8495140342055540043L;
	
	private int organizationQualificationId;
	
	private int organizationId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			if (organization != null) {
				pageName = "Manage Organization > " + organization.getOrganizationName() + " > Qualifications";
			}
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			OrganizationQualification organizationQualification = organizationRequirementQualificationManager.getOrganizationQualification(organizationQualificationId);
			
			organizationQualification.setQualified(true);
			
			organizationRequirementQualificationManager.saveOrganizationQualification(organizationQualification);
			notificationMessage = "Scholar Requirement has been approved.";
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

	public int getOrganizationQualificationId() {
		return organizationQualificationId;
	}

	public void setOrganizationQualificationId(int organizationQualificationId) {
		this.organizationQualificationId = organizationQualificationId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	
}
