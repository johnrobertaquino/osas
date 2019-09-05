package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class AddOrganizationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;

	private String organizationId;
	
	private String organizationName;
	
	private String organizationTypeCode;
	
	private String program;
	
	private String adviser;
	 
	private String logoFileName;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			
			Organization organization = new Organization();
			OrganizationManager organizationManager = new OrganizationManager();
			organization = organizationManager.validate(organizationName);
			
			if(organization != null) { 
				notificationMessage = "Organization is already exist.";
			}
			else
			{
				organization = new Organization();
				organization.setOrganizationName(organizationName);
				organization.setOrganizationType(new OrganizationType());
				organization.getOrganizationType().setOrganizationTypeCode(organizationTypeCode);
				organization.setProgram(program);
				organization.setAdviser(adviser);
				organization.setLogoFileName(logoFileName);
				organization.setSemTerm(getCurrentActiveTerm());
				organizationManager.insertOrganization(organization);
				notificationMessage = "Organization has been saved successfully added.";
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
	 * @return the organizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the organizationType
	 */
	public String getOrganizationTypeCode() {
		return organizationTypeCode;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationTypeCode(String organizationTypeCode) {
		this.organizationTypeCode = organizationTypeCode;
	}


	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @return the adviser
	 */
	public String getAdviser() {
		return adviser;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}
	
	/**
	 * @return the adviser
	 */
	public String getLogoFileName() {
		return logoFileName;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

}
