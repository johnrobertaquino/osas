package org.pup.system.osas.ui.action;

import java.util.List;

import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.exception.BusinessException;


public class DisplayMemberListAction extends AbstractAction
{

	private static final long serialVersionUID = 4251608337401003937L;
	
	private List<Member> memberList;
	
	private List<Organization> organizationList;
	
	private String filter; 
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Member";
		
		String actionResult = FORWARD_SUCCESS;

		try {
			MemberManager memberManager = new MemberManager();
			OrganizationManager organizationManager = new OrganizationManager();
			
			memberList = memberManager.getMemberList(getCurrentActiveTerm().getSemTermId());
			organizationList = organizationManager.getOrganizationList(getCurrentActiveTerm().getSemTermId());
			
			if(StringUtils.isEmpty(filter) || "all".equals(filter)) {
				memberList = memberManager.getMemberList(getCurrentActiveTerm().getSemTermId());
			} else {
				memberList = memberManager.getMemberList(getCurrentActiveTerm().getSemTermId(), filter);
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
	
	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member>memberList) {
		this.memberList = memberList;
	}

	public List<Organization> getOrganizationList() {
		return organizationList;
	}

	public void setOrganizationList(List<Organization> organizationList) {
		this.organizationList = organizationList;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	
}
