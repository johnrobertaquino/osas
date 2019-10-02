package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.core.manager.SemTermManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayScholarshipReportAction extends AbstractAction {
	
	private static final long serialVersionUID = 4251608337401003937L;

	private List<SemTerm> semTermList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Scholarship Report";

		String actionResult = FORWARD_SUCCESS;

		try {
			SemTermManager semTermManager = new SemTermManager();
			semTermList = semTermManager.getSemTermList();

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

	public List<SemTerm> getSemTermList() {
		return semTermList;
	}

	public void setSemTermList(List<SemTerm> semTermList) {
		this.semTermList = semTermList;
	}

}
