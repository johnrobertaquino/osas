package org.pup.system.osas.ui.action;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationQualification;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.core.manager.OrganizationRequirementQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class AddOrganizationQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89102832466116810L; 
	
	private String notes;

	private File fileName;
	
	private String fileNameContentType;
	
	private String fileNameFileName;
	
	private String dateSubmitted;
	
	private int organizationRequirementId;

	private int organizationId;
	
	private String addAttachment;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization > Qualifications";

		String actionResult = FORWARD_SUCCESS;
		
		File fileToCreate = null;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			if (organization != null) {
				pageName = "Manage Organization > " + organization.getOrganizationName() + " > Qualifications";
			}
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			OrganizationQualification organizationQualification = new OrganizationQualification();
			
			organizationQualification.setOrganizationId(organizationId);
			organizationQualification.setOrganizationRequirementId(organizationRequirementId);
			organizationQualification.setNotes(notes);
			organizationQualification.setDateSubmitted(new SimpleDateFormat("MM/dd/yyyy").parse(dateSubmitted));
			organizationQualification.setQualified(false);
			if("on".equalsIgnoreCase(addAttachment)) {
				organizationQualification.setFileName(fileNameFileName);
			
				String filePath = "C:/OSAS/Organization/OrganizationAttachment";
				fileToCreate = new File(filePath, fileNameFileName);
			
				FileUtils.copyFile(fileName, fileToCreate);
			}
			
			organizationRequirementQualificationManager.insertOrganizationQualification(organizationQualification);
			
			notificationMessage = "Organization Requirement has been submitted.";
		} catch (BusinessException be) {
			if("on".equalsIgnoreCase(addAttachment)) {
				if (fileToCreate != null) {
					fileToCreate.delete();
				}
			}
			
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationRequirementId);
			
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			
			if (organization != null) {
				pageName = "Manage Organization > " + organization.getOrganizationName() + " > " + organizationRequirement.getOrganizationRequirementName() + " " ;
			}
			
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			if("on".equalsIgnoreCase(addAttachment)) {
				if (fileToCreate != null) {
					fileToCreate.delete();
				}
			}
			
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationRequirementId);
			
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			
			if (organization != null) {
				pageName = "Manage Organization > " + organization.getOrganizationName() + " > " + organizationRequirement.getOrganizationRequirementName() + " " ;
			}
			
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}

		return actionResult;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public File getFileName() {
		return fileName;
	}

	public void setFileName(File fileName) {
		this.fileName = fileName;
	}

	public String getFileNameContentType() {
		return fileNameContentType;
	}

	public void setFileNameContentType(String fileNameContentType) {
		this.fileNameContentType = fileNameContentType;
	}

	public String getFileNameFileName() {
		return fileNameFileName;
	}

	public void setFileNameFileName(String fileNameFileName) {
		this.fileNameFileName = fileNameFileName;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public int getOrganizationRequirementId() {
		return organizationRequirementId;
	}

	public void setOrganizationRequirementId(int organizationRequirementId) {
		this.organizationRequirementId = organizationRequirementId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getAddAttachment() {
		return addAttachment;
	}

	public void setAddAttachment(String addAttachment) {
		this.addAttachment = addAttachment;
	}
}
