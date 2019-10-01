package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class EditScholarshipQualificationAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;

	private static final String FORWARD_DISPLAYEDITSCHOLARSHIPQUALIFICATION = "displayEditScholarshipQualification";

	private int scholarshipQualificationId;

	private String scholarshipQualificationName;

	private int scholarshipProgramId;

	private String yearlyCheck;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();

			ScholarshipQualification existingScholarshipQualification = null;
			existingScholarshipQualification = scholarshipQualificationManager.validate(scholarshipQualificationName, scholarshipProgramId);

			if (existingScholarshipQualification != null
					&& scholarshipQualificationId != existingScholarshipQualification.getScholarshipQualificationId()) {
				notificationMessage = "Scholarship qualification already exist.";
				return FORWARD_DISPLAYEDITSCHOLARSHIPQUALIFICATION;
			} else {
				ScholarshipQualification scholarshipQualification = scholarshipQualificationManager
						.getScholarshipQualification(scholarshipQualificationId);

				scholarshipQualification.setScholarshipQualificationId(scholarshipQualificationId);
				scholarshipQualification.setScholarshipQualificationName(scholarshipQualificationName);
				scholarshipQualification.setYearlyCheck("on".equalsIgnoreCase(yearlyCheck));

				scholarshipQualificationManager.saveScholarshipQualification(scholarshipQualification);

				notificationMessage = "Changes to scholarship qualification has been saved successfully.";
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

	public int getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	/**
	 * @param scholarshipQualificationName the scholarshipQualificationName to set
	 */
	public void setScholarshipQualificationId(int scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}

	public String getScholarshipQualificationName() {
		return scholarshipQualificationName;
	}

	public void setScholarshipQualificationName(String scholarshipQualificationName) {
		this.scholarshipQualificationName = scholarshipQualificationName;
	}

	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}

	public String getYearlyCheck() {
		return yearlyCheck;
	}

	public void setYearlyCheck(String yearlyCheck) {
		this.yearlyCheck = yearlyCheck;
	}

}
