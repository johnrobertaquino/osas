package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.exception.BusinessException;


public class DisplayMemberListAction extends AbstractAction
{

	private static final long serialVersionUID = 4251608337401003937L;
	private List<Member> memberList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Member";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			MemberManager memberManager = new MemberManager();
			memberList = memberManager.getMemberList(1);
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
	
	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member>memberList) {
		this.memberList = memberList;
	}

}
