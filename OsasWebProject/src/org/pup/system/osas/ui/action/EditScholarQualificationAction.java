package org.pup.system.osas.ui.action;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class EditScholarQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;

	private int scholarQualificationId;

	private String notes;
	
	private String dateSubmitted;

	private File fileName;
	
	private String fileNameContentType;
	
	private String fileNameFileName;
	
	private int scholarId;
	
	private String addAttachment;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";

		String actionResult = FORWARD_SUCCESS;
		
		File fileToCreate = null;

		try {
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > Qualifications";
			}
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			ScholarQualification scholarQualification = scholarScholarshipQualificationManager.getScholarQualification(scholarQualificationId);
			
			scholarQualification.setNotes(notes);
			scholarQualification.setDateSubmitted(new SimpleDateFormat("MM/dd/yyyy").parse(dateSubmitted));
			scholarQualification.setQualified(false);
			
			if("on".equalsIgnoreCase(addAttachment)) {
				scholarQualification.setFilename(fileNameFileName);
			
				String filePath = "C:/OSAS/Scholar/ScholarAttachment";
				fileToCreate = new File(filePath, fileNameFileName);
			
				FileUtils.copyFile(fileName, fileToCreate);
			}
			
			scholarScholarshipQualificationManager.saveScholarQualification(scholarQualification);

			notificationMessage = "Scholar Requirement has been saved.";
		} catch (BusinessException be) {
			if("on".equalsIgnoreCase(addAttachment)) {
				if (fileToCreate != null) {
					fileToCreate.delete();
				}
			}
			
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			ScholarQualification scholarQualification = scholarScholarshipQualificationManager.getScholarQualification(scholarQualificationId);
			
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarQualification.getScholarshipQualificationId());
			
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
			
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			ScholarQualification scholarQualification = scholarScholarshipQualificationManager.getScholarQualification(scholarQualificationId);
			
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarQualification.getScholarshipQualificationId());
			
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

	/**
	 * @return the scholarQualificationId
	 */
	public int getScholarQualificationId() {
		return scholarQualificationId;
	}

	/**
	 * @param scholarQualificationId the scholarQualificationId to set
	 */
	public void setScholarQualificationId(int scholarQualificationId) {
		this.scholarQualificationId = scholarQualificationId;
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
	
	

}
