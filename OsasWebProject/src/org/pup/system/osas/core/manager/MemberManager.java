package org.pup.system.osas.core.manager;
import java.sql.Connection;
import java.util.List;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.MemberDAO;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;

public class MemberManager 
{
	public void insertMember(Member member) throws Exception {
		MemberDAO memberDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			memberDAO.insertMember(member);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public Member getMember(int memberId) throws Exception {
		MemberDAO memberDAO = null;
		Member member = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			member = memberDAO.getMemberByMemberId(memberId);
			
			if (member != null) {
				OrganizationManager organizationManager = new OrganizationManager();
			
				Organization organization =  organizationManager.getOrganization(member.getOrganization().getOrganizationId());
				member.setOrganization(organization);
			}
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return member;
	}
	
	public List<Member> getMemberList(int semTermId) throws Exception {
		MemberDAO memberDAO = null;
		List<Member>memberList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			memberList = memberDAO.getMemberList(semTermId);
			
			if (memberList != null) {
				OrganizationManager organizationManager = new OrganizationManager();
				
				for (Member member : memberList) {
					Organization organization =  organizationManager.getOrganization(member.getOrganization().getOrganizationId());
					member.setOrganization(organization);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return memberList;
	}
	
	public List<Member> getMemberListByMemberSearchText(String memberSearchText, int semTermId) throws Exception {
		MemberDAO memberDAO = null;
		List<Member> memberList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			memberList = memberDAO.getMemberListByMemberSearchText(memberSearchText, semTermId);
			
			if (memberList != null) {
				OrganizationManager organizationManager = new OrganizationManager();
				
				for (Member member : memberList) {
					Organization organization =  organizationManager.getOrganization(member.getOrganization().getOrganizationId());
					member.setOrganization(organization);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return memberList;
	}

	public void saveMember(Member member) throws Exception {
		MemberDAO memberDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			memberDAO.saveMember(member);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteMember(Member member) throws Exception {
		MemberDAO memberDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			memberDAO.deleteMemberByMemberId(member.getMemberId());
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
