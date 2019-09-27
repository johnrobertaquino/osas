package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationQualification;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.core.manager.OrganizationRequirementQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditOrganizationQualificationAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private int organizationQualificationId;
	
	private int organizationId;
	
	private OrganizationQualification organizationQualification;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			organizationQualification = organizationRequirementQualificationManager.getOrganizationQualification(organizationQualificationId);		
			
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationQualification.getOrganizationRequirementId());
			
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

	/**
	 * @return the organizationQualification
	 */
	public OrganizationQualification getOrganizationQualification() {
		return organizationQualification;
	}

	/**
	 * @param organizationQualification the organizationQualification to set
	 */
	public void setOrganizationQualification(OrganizationQualification organizationQualification) {
		this.organizationQualification = organizationQualification;
	}
	
}
