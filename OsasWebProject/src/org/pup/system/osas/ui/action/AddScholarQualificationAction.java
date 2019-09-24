package org.pup.system.osas.ui.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;	
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class AddScholarQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 89102832466116810L; 
	
	private String notes;

	private File fileName;
	
	private String fileNameContentType;
	
	private String fileNameFileName;
	
	private int scholarshipQualificationId;

	private int scholarId;
	
	private String addAttachment;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";

		String actionResult = FORWARD_SUCCESS;
		
		File fileToCreate = null;

		try {
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > Qualifications";
			}
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			ScholarQualification scholarQualification = new ScholarQualification();
			
			scholarQualification.setScholarId(scholarId);
			scholarQualification.setScholarshipQualificationId(scholarshipQualificationId);
			scholarQualification.setNotes(notes);
			scholarQualification.setQualified(false);
			if("on".equalsIgnoreCase(addAttachment)) {
				scholarQualification.setFilename(fileNameFileName);
			
				String filePath = "C:/OSAS/scholarAttachment";
				fileToCreate = new File(filePath, fileNameFileName);
			
				FileUtils.copyFile(fileName, fileToCreate);
			}
			
			scholarScholarshipQualificationManager.insertScholarQualification(scholarQualification);
			
			notificationMessage = "Scholar Requirement has been submitted.";
		} catch (BusinessException be) {
			if("on".equalsIgnoreCase(addAttachment)) {
				if (fileToCreate != null) {
					fileToCreate.delete();
				}
			}
			
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarshipQualificationId);
			
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > " + scholarshipQualification.getScholarshipQualificationName() + " " ;
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
			
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarshipQualificationId);
			
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > " + scholarshipQualification.getScholarshipQualificationName() + " " ;
			}
			
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}

		return actionResult;
	}

	/**
	 * @return the scholarshipQualificationId
	 */
	public int getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	/**
	 * @param scholarshipQualificationId the scholarshipQualificationId to set
	 */
	public void setScholarshipQualificationId(int scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getScholarId() {
		return scholarId;
	}

	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
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

}
