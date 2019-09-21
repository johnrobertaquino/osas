package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.core.manager.ScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditScholarQualificationAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private int scholarQualificationId;
	
	private int scholarId;
	
	private ScholarQualification scholarQualification;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			scholarQualification = scholarScholarshipQualificationManager.getScholarQualification(scholarQualificationId);		
			
			ScholarshipQualificationManager scholarshipQualificationManager = new ScholarshipQualificationManager();
			ScholarshipQualification scholarshipQualification = scholarshipQualificationManager.getScholarshipQualification(scholarQualification.getScholarshipQualificationId());
			
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > " + scholarshipQualification.getScholarshipQualificationName() + " " ;
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
	
	public int getScholarId() {
		return scholarId;
	}
	
	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}

	public int getScholarQualificationId() {
		return scholarQualificationId;
	}

	public void setScholarQualificationId(int scholarQualificationId) {
		this.scholarQualificationId = scholarQualificationId;
	}

	public ScholarQualification getScholarQualification() {
		return scholarQualification;
	}

	public void setScholarQualification(ScholarQualification scholarQualification) {
		this.scholarQualification = scholarQualification;
	}
	
	
	
}
