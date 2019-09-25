package org.pup.system.osas.ui.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class EditOrganizationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private int organizationId;
	
	private String organizationName;
	
	private String organizationTypeCode;
	
	private String program;
	
	private String adviser;
	
	private File logoFileName;
	
	private String logoFileNameContentType;

	private String logoFileNameFileName;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		File fileToCreate = null;

		String actionResult = FORWARD_SUCCESS;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			
			organization.setOrganizationId(organizationId);
			organization.setOrganizationName(organizationName);
			organization.setOrganizationType(new OrganizationType());
			organization.getOrganizationType().setOrganizationTypeCode(organizationTypeCode);
			organization.setProgram(new Program(program));
			organization.setAdviser(adviser);
			
			if(!StringUtils.isEmpty(logoFileNameFileName)) {
				organization.setLogoFileName(logoFileNameFileName);
				
				String filePath = "C:/OSAS/Organization/Logo";
				fileToCreate = new File(filePath, logoFileNameFileName);
				
				FileUtils.copyFile(logoFileName, fileToCreate);
			}
			
			organizationManager.saveOrganization(organization);
			
			notificationMessage = "Changes to organization has been saved successfully.";
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
	public int getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(int organizationId) {
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
	 * @return the organizationTypeCode
	 */
	public String getOrganizationTypeCode() {
		return organizationTypeCode;
	}

	/**
	 * @param organizationTypeCode the organizationTypeCode to set
	 */
	public void setOrganizationTypeCode(String organizationTypeCode) {
		this.organizationTypeCode = organizationTypeCode;
	}

	public File getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(File logoFileName) {
		this.logoFileName = logoFileName;
	}

	public String getLogoFileNameContentType() {
		return logoFileNameContentType;
	}

	public void setLogoFileNameContentType(String logoFileNameContentType) {
		this.logoFileNameContentType = logoFileNameContentType;
	}

	public String getLogoFileNameFileName() {
		return logoFileNameFileName;
	}

	public void setLogoFileNameFileName(String logoFileNameFileName) {
		this.logoFileNameFileName = logoFileNameFileName;
	}	

}
