package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchAgencyAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777267392504750903L;

	private String agencySearchText;
	
	private List<Agency> agencyList;

	@Override
	public String execute() throws Exception {
		pageName = "Student Scholarship - Agency";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			AgencyManager agencyManager = new AgencyManager();
			setAgencyList(agencyManager.getAgencyListByAgencySearchText(agencySearchText));
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
	 * @return the agencySearchText
	 */
	public String getAgencySearchText() {
		return agencySearchText;
	}

	/**
	 * @param agencySearchText the agencySearchText to set
	 */
	public void setAgencySearchText(String agencySearchText) {
		this.agencySearchText = agencySearchText;
	}

	/**
	 * @return the agencyList
	 */
	public List<Agency> getAgencyList() {
		return agencyList;
	}

	/**
	 * @param agencyList the agencyList to set
	 */
	public void setAgencyList(List<Agency> agencyList) {
		this.agencyList = agencyList;
	}
}
