package org.pup.system.osas.core.manager;
import java.sql.Connection;
import java.util.List;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.MemberDAO;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.exception.BusinessException;

public class MemberManager 
{
	
	public Member validate(String studentNumber, String firstName, String middleName, String lastName, int semTermId) throws Exception {
		MemberDAO memberDAO = null;
		Member member = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			member = memberDAO.getMemberByMemberNameAndStudentNumber(studentNumber, firstName, middleName, lastName, semTermId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return member;
	}
	
	public void insertMember(Member member) throws Exception {
		MemberDAO memberDAO = null;
		Connection connection = null;
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			organizationDAO = new OrganizationDAO(connection);
			
			memberDAO.insertMember(member);
			
			organizationList = member.getOrganizationList();
			
			if (member!= null) {
				for (Organization organization : organizationList) {
					organizationDAO.insertOrganizationByMemberId(member.getMemberId(), organization);
				}
			}
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public void insertMemberList(List<Member> memberList, int semTermId) throws Exception {
		MemberDAO memberDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			
			for (Member member : memberList) {
				Member existingMember = null;
				existingMember = validate(member.getStudentNumber(), member.getFirstName(), member.getMiddleName(), member.getLastName(), semTermId);
				
				if (existingMember != null) {
					throw new BusinessException("Member with student number " + member.getStudentNumber() + " matches one of our record.");
				} 
				else {
					memberDAO.insertMember(member);
				} 

			}
			
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
		
			if(member != null) {
				OrganizationManager organizationManager = new OrganizationManager();
				List<Organization> organizationList = organizationManager.getOrganizationListByMemberId(member.getMemberId());
				member.setOrganizationList(organizationList);
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
			
			if(memberList != null) {
				OrganizationManager organizationManager = new OrganizationManager();
				for (Member member : memberList) {
					List<Organization> organizationList = organizationManager.getOrganizationListByMemberId(member.getMemberId());
					member.setOrganizationList(organizationList);
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
			
			if(memberList != null) {
				OrganizationManager organizationManager = new OrganizationManager();
				for (Member member : memberList) {
					List<Organization> organizationList = organizationManager.getOrganizationListByMemberId(member.getMemberId());
					member.setOrganizationList(organizationList);
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
		OrganizationDAO organizationDAO = null;
		List<Organization> organizationList = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			memberDAO = new MemberDAO(connection);
			organizationDAO = new OrganizationDAO(connection);
			
			memberDAO.saveMember(member);
			
			organizationDAO.deleteOrganizationByMemberId(member.getMemberId());
			organizationList = member.getOrganizationList();
			
			if (member!= null) {
				for (Organization organization : organizationList) {
					organizationDAO.insertOrganizationByMemberId(member.getMemberId(), organization);
				}
			}
			
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
