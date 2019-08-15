package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchScholarAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777267392504750903L;

	private String scholarSearchText;
	
	private List<Scholar> scholarList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarManager scholarManager = new ScholarManager();
			setScholarList(scholarManager.getScholarListByScholarSearchText(scholarSearchText));
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
	 * @return the scholarSearchText
	 */
	public String getScholarSearchText() {
		return scholarSearchText;
	}

	/**
	 * @param scholarSearchText the scholarSearchText to set
	 */
	public void setScholarSearchText(String scholarSearchText) {
		this.scholarSearchText = scholarSearchText;
	}

	/**
	 * @return the scholarList
	 */
	public List<Scholar> getScholarList() {
		return scholarList;
	}

	/**
	 * @param scholarList the scholarList to set
	 */
	public void setScholarList(List<Scholar> scholarList) {
		this.scholarList = scholarList;
	}
}
