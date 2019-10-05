package org.pup.system.osas.ui.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayScholarListAction extends AbstractAction
{

	private static final long serialVersionUID = 4251608337401003937L;
	
	private List<Scholar> scholarList;
	
	private List<ScholarshipProgram> scholarshipProgramList;
	
	private String filter;
	
	private String scholarshipProgramFilter;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			scholarshipProgramList = scholarshipProgramManager.getScholarshipProgramList(getCurrentActiveTerm().getSemTermId());
			
			ScholarManager scholarshipManager = new ScholarManager();
			if(StringUtils.isEmpty(filter) || StringUtils.isEmpty(scholarshipProgramFilter)) {
				scholarList = scholarshipManager.getScholarList(getCurrentActiveTerm().getSemTermId());
			} else {
				scholarList = scholarshipManager.getScholarList(getCurrentActiveTerm().getSemTermId(), filter, scholarshipProgramFilter);
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

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	/**
	 * @return the scholarshipProgramList
	 */
	public List<ScholarshipProgram> getScholarshipProgramList() {
		return scholarshipProgramList;
	}

	/**
	 * @param scholarshipProgramList the scholarshipProgramList to set
	 */
	public void setScholarshipProgramList(List<ScholarshipProgram> scholarshipProgramList) {
		this.scholarshipProgramList = scholarshipProgramList;
	}

	public String getScholarshipProgramFilter() {
		return scholarshipProgramFilter;
	}

	public void setScholarshipProgramFilter(String scholarshipProgramFilter) {
		this.scholarshipProgramFilter = scholarshipProgramFilter;
	}
	
	

}
