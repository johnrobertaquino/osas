package org.pup.system.osas.ui.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class AddOrganizationAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;

	private static final String FORWARD_DISPLAYADDORGANIZATION = "displayAddOrganization";
	
	private String organizationName;
	
	private String organizationTypeCode;
	
	private String logoFileNameContentType;

	private String logoFileNameFileName;
	
	private String program;
	
	private String adviser;
	 
	private File logoFileName;
	
	private String addAttachment;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization";
		
		String actionResult = FORWARD_SUCCESS;
		File fileToCreate = null;
		
		try {
			
			Organization organization = new Organization();
			OrganizationManager organizationManager = new OrganizationManager();
			organization = organizationManager.validate(organizationName, getCurrentActiveTerm().getSemTermId());
			
			if(organization != null) { 
				notificationMessage = "Organization already exist.";
				return FORWARD_DISPLAYADDORGANIZATION;
			}
			else
			{
				organization = new Organization();
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
				
				organization.setSemTerm(getCurrentActiveTerm());
				organizationManager.insertOrganization(organization);
				notificationMessage = "Organization has been successfully added.";
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
	public File getLogoFileName() {
		return logoFileName;
	}

	/**
	 * @param adviser the adviser to set
	 */
	public void setLogoFileName(File logoFileName) {
		this.logoFileName = logoFileName;
	}
	

	public String getLogoFileNameContentType() {
		return logoFileNameContentType;
	}
	
	public void setLogoFileNameContentType(String logoFileNameContentType) {
		this.logoFileNameContentType = logoFileNameContentType;
	}
	
	/**
	 * @return the addAttachment
	 */
	public String getAddAttachment() {
		return addAttachment;
	}
	/**
	 * @param addAttachment the addAttachment to set
	 */
	public void setAddAttachment(String addAttachment) {
		this.addAttachment = addAttachment;
	}
	/**
	 * @return the logoFileNameFileName
	 */
	public String getLogoFileNameFileName() {
		return logoFileNameFileName;
	}
	/**
	 * @param logoFileNameFileName the logoFileNameFileName to set
	 */
	public void setLogoFileNameFileName(String logoFileNameFileName) {
		this.logoFileNameFileName = logoFileNameFileName;
	}

}
