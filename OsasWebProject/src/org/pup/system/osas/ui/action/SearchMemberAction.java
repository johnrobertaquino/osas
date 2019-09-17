package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.exception.BusinessException;

public class SearchMemberAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777267392504750903L;

	private String memberSearchText;
	
	private List<Member> memberList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Member";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			MemberManager memberManager = new MemberManager();
			setMemberList(memberManager.getMemberListByMemberSearchText(memberSearchText, getCurrentActiveTerm().getSemTermId()));
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
	 * @return the MemberSearchText
	 */
	public String getMemberSearchText() {
		return memberSearchText;
	}

	/**
	 * @param MemberSearchText the MemberSearchText to set
	 */
	public void setMemberSearchText(String memberSearchText) {
		this.memberSearchText = memberSearchText;
	}

	/**
	 * @return the MemberList
	 */
	public List<Member> getMemberList() {
		return memberList;
	}

	/**
	 * @param MemberList the MemberList to set
	 */
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
}
