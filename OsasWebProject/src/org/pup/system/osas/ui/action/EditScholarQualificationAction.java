package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class EditScholarQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;

	private static final String FORWARD_DISPLAYEDITSCHOLARSHIPQUALIFICATION = "displayEditScholarshipQualification";

	private int scholarQualificationId;
	
	private int scholarshipQualificationId;

	private String notes;

	private String fileName;
	
	private int scholarId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > Qualifications";
			}
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			ScholarQualification scholarQualification = scholarScholarshipQualificationManager.getScholarQualification(scholarQualificationId);
			scholarQualification.setScholarQualificationId(scholarQualificationId);
			scholarQualification.setNotes(notes);
			scholarQualification.setQualified(false);
			
			scholarScholarshipQualificationManager.saveScholarQualification(scholarQualification);

		     notificationMessage = "Changes to scholarship qualification has been saved successfully.";
			
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

	public int getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	/**
	 * @param scholarshipQualificationName the scholarshipQualificationName to set
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

}
