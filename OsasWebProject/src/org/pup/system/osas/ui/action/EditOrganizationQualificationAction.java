package org.pup.system.osas.ui.action;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationQualification;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.OrganizationRequirementManager;
import org.pup.system.osas.core.manager.OrganizationRequirementQualificationManager;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class EditOrganizationQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;

	private int organizationQualificationId;

	private String notes;
	
	private String dateSubmitted;

	private File fileName;
	
	private String fileNameContentType;
	
	private String fileNameFileName;
	
	private int organizationId;
	
	private String addAttachment;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";

		String actionResult = FORWARD_SUCCESS;
		
		File fileToCreate = null;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(organizationId);
			if (organization != null) {
				pageName = "Manage Scholar > " + organization.getOrganizationName() + " > Qualifications";
			}
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			OrganizationQualification organizationQualification = new OrganizationQualification();
			
			organizationQualification.setNotes(notes);
			organizationQualification.setDateSubmitted(new SimpleDateFormat("MM/dd/yyyy").parse(dateSubmitted));
			organizationQualification.setQualified(false);
			if("on".equalsIgnoreCase(addAttachment)) {
				organizationQualification.setFileName(fileNameFileName);
			
				String filePath = "C:/OSAS/scholarAttachment";
				fileToCreate = new File(filePath, fileNameFileName);
			
				FileUtils.copyFile(fileName, fileToCreate);
			}
			organizationRequirementQualificationManager.saveOrganizationQualification(organizationQualification);

			notificationMessage = "Scholar Requirement has been saved.";
		} catch (BusinessException be) {
			if("on".equalsIgnoreCase(addAttachment)) {
				if (fileToCreate != null) {
					fileToCreate.delete();
				}
			}
			
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			OrganizationQualification organizationQualification = organizationRequirementQualificationManager.getOrganizationQualification(organizationQualificationId);
			
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationQualification.getOrganizationRequirementId());
			
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
			
			OrganizationRequirementQualificationManager organizationRequirementQualificationManager = new OrganizationRequirementQualificationManager();
			OrganizationQualification organizationQualification = organizationRequirementQualificationManager.getOrganizationQualification(organizationQualificationId);
			
			OrganizationRequirementManager organizationRequirementManager = new OrganizationRequirementManager();
			OrganizationRequirement organizationRequirement = organizationRequirementManager.getOrganizationRequirement(organizationQualification.getOrganizationRequirementId());
			
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

	public String getAddAttachment() {
		return addAttachment;
	}

	public void setAddAttachment(String addAttachment) {
		this.addAttachment = addAttachment;
	}

	/**
	 * @return the dateSubmitted
	 */
	public String getDateSubmitted() {
		return dateSubmitted;
	}

	/**
	 * @param dateSubmitted the dateSubmitted to set
	 */
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	/**
	 * @return the organizationQualificationId
	 */
	public int getOrganizationQualificationId() {
		return organizationQualificationId;
	}

	/**
	 * @param organizationQualificationId the organizationQualificationId to set
	 */
	public void setOrganizationQualificationId(int organizationQualificationId) {
		this.organizationQualificationId = organizationQualificationId;
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
	
	

}
