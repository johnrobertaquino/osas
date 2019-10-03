package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.YearlyTerm;
import org.pup.system.osas.core.manager.YearlyTermManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayOrganizationReportAction extends AbstractAction {
	
	private static final long serialVersionUID = 4251608337401003937L;
	
	private List<YearlyTerm> yearlyTermList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Organization Report";

		String actionResult = FORWARD_SUCCESS;

		try {
			YearlyTermManager yearlyTermManager = new YearlyTermManager();
			setYearlyTermList(yearlyTermManager.getYearlyTermList());

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
	 * @return the yearlyTermList
	 */
	public List<YearlyTerm> getYearlyTermList() {
		return yearlyTermList;
	}

	/**
	 * @param yearlyTermList the yearlyTermList to set
	 */
	public void setYearlyTermList(List<YearlyTerm> yearlyTermList) {
		this.yearlyTermList = yearlyTermList;
	}

}
