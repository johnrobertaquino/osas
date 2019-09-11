package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.exception.BusinessException;

public class DisplayEditMemberAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;
	
	private String memberId;
	
	private Member member;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Member";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			MemberManager memberManager = new MemberManager();
			setMember(memberManager.getMember(Integer.parseInt(memberId)));
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


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}
}
