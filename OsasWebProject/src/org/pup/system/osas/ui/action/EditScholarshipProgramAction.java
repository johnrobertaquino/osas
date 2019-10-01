package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;	

public class EditScholarshipProgramAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private static final String FORWARD_DISPLAYEDITSCHOLARSHIPPROGRAM = "displayEditScholarshipProgram";
	
	private int scholarshipProgramId;
	
	private String scholarshipProgramName;
	
	private String agencyId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship";

		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();

			ScholarshipProgram existingScholarshipProgram = null;
			existingScholarshipProgram = scholarshipProgramManager.validate(scholarshipProgramName, getCurrentActiveTerm().getSemTermId());
		
			if (existingScholarshipProgram != null && scholarshipProgramId != existingScholarshipProgram.getScholarshipProgramId()) {
				notificationMessage = "Scholarship program already exist.";
				return FORWARD_DISPLAYEDITSCHOLARSHIPPROGRAM;
			} else {
				ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholarshipProgramId);
				
				scholarshipProgram.setScholarshipProgramName(scholarshipProgramName);
				scholarshipProgramManager.saveScholarshipProgram(scholarshipProgram);
				
				notificationMessage = "Changes to scholarship program has been saved successfully.";
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

	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}
	/**
	 * @param scholarshipProgramName the scholarshipProgramName to set
	 */
	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}
	
	public String getScholarshipProgramName() {
		return scholarshipProgramName;
	}

	public void setScholarshipProgramName(String scholarshipProgramName) {
		this.scholarshipProgramName = scholarshipProgramName;
	}

	/**
	 * @return the address
	 */
	public String getAgencyId() {
		return agencyId;
	}

	/**
	 * @param address the address to set
	 */
	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
	}

}
