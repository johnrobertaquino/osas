package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.core.manager.JobManager;
import org.pup.system.osas.core.manager.SemTermManager;
import org.pup.system.osas.exception.BusinessException;

public class ChangeSemesterAction extends AbstractAction 	{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8741110329697444667L;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Semester";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			SemTerm semTerm = getCurrentActiveTerm();
			SemTermManager semTermManager = new SemTermManager();
			JobManager jobManager = new JobManager();
			
			if(semTerm != null && semTerm.getSemTermName() != null) {
				String semTermName = semTerm.getSemTermName();
				
				if (semTermName.contains("1st")) {
					jobManager.generateNewSecondSem();
				} else if (semTermName.contains("2nd")) {
					jobManager.generateNewFirstSem();
				}
				
				semTerm = semTermManager.getCurrentActiveSemTerm();
				
				setCurrentActiveTerm(semTerm);
				
				notificationMessage = "You have successfully generated a new semester: " + semTerm.getSemTermName();
				
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

}
