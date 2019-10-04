package org.pup.system.osas.ui.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarScholarshipQualification;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarScholarshipQualificationManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayScholarQualificationListAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426112992716352970L;
	
	private List<ScholarScholarshipQualification> scholarScholarshipQualificationList;
	
	private int scholarId;
	
	private String search;
	
	private String scholarQualificationSearchText;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar > Qualifications";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarScholarshipQualificationManager scholarshipQualificationManager = new ScholarScholarshipQualificationManager();
			if ("Y".equals(search) && !StringUtils.isBlank(scholarQualificationSearchText)) {
				scholarScholarshipQualificationList = scholarshipQualificationManager.searchScholarScholarshipQualificationList(scholarQualificationSearchText, scholarId, getCurrentActiveTerm().getSemTermId());
			}else {
				scholarScholarshipQualificationList = scholarshipQualificationManager.getScholarScholarshipQualificationList(scholarId, getCurrentActiveTerm().getSemTermId());
			}
			
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			if (scholar != null) {
				pageName = "Manage Scholar > " + scholar.getFirstName() + " " + scholar.getLastName() + " > Qualifications";
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

	public List<ScholarScholarshipQualification> getScholarScholarshipQualificationList() {
		return scholarScholarshipQualificationList;
	}

	public void setScholarScholarshipQualificationList(
			List<ScholarScholarshipQualification> scholarScholarshipQualificationList) {
		this.scholarScholarshipQualificationList = scholarScholarshipQualificationList;
	}

	public int getScholarId() {
		return scholarId;
	}

	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getScholarQualificationSearchText() {
		return scholarQualificationSearchText;
	}

	public void setScholarQualificationSearchText(String scholarQualificationSearchText) {
		this.scholarQualificationSearchText = scholarQualificationSearchText;
	}
	
}
