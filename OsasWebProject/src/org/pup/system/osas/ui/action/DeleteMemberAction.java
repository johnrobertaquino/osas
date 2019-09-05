package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.exception.BusinessException;

public class DeleteMemberAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2914771763486431991L;

	private int memberId;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Member";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			MemberManager memberManager = new MemberManager();
			Member member = memberManager.getMember(memberId);
			memberManager.deleteMember(member);
			notificationMessage = "Scholar has been successfully deleted.";
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
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}