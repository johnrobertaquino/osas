package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.MemberDAO;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;

public class MemberManager {

	/*public Member validateMember(String studentNumber, String firstName, String middleName, String lastName, int semTermId)
			throws Exception {
		MemberDAO memberDAO = null;
		Member member = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			memberDAO = new MemberDAO(connection);

			member = memberDAO.getMemberByMemberNameAndStudentNumber(studentNumber, firstName, middleName, lastName,
					semTermId);

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return member;
	}*/

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

	public void insertMemberList(List<Member> memberList, Organization organization, int semTermId) throws Exception {
		if (memberList != null) {
			for (Member member : memberList) {
				Member existingMember = null;
				existingMember = getMemberByStudentNumber(member.getStudentNumber(), semTermId);

				if (existingMember != null) {
					List<Organization> organizationList = existingMember.getOrganizationList();
					if (organizationList != null) {
						boolean orgIsExisting = false;
						for (Organization existingOrganization : organizationList) {
							if (existingOrganization.getOrganizationId() == organization.getOrganizationId()) {
								orgIsExisting = true;
							}
						}

						if (!orgIsExisting) {
							existingMember.getOrganizationList().add(organization);
						}
					} else {
						existingMember.setOrganizationList(new ArrayList<Organization>());
						existingMember.getOrganizationList().add(organization);
					}

					saveMember(existingMember);
				} else {
					member.setOrganizationList(new ArrayList<Organization>());
					member.getOrganizationList().add(organization);
					insertMember(member);
				}
			}
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

	public Member getMemberByStudentNumber(String studentNumber, int semTermId) throws Exception {
		MemberDAO memberDAO = null;
		Member member = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			memberDAO = new MemberDAO(connection);

			member = memberDAO.getMemberByStudentNumber(studentNumber, semTermId);

			if (member != null) {
				OrganizationManager organizationManager = new OrganizationManager();
				List<Organization> organizationList = organizationManager
						.getOrganizationListByMemberId(member.getMemberId());
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
		List<Member> memberList = null;

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
	
	public List<Member> getMemberList(int semTermId, String filter) throws Exception {
		MemberDAO memberDAO = null;
		List<Member> memberList = null;
		List<Member> filteredMemberListList = null;
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
				
					String organizationName = member.getOrganizationListDisplay();
					
					if(organizationName.equalsIgnoreCase(filter)) {
						if(filteredMemberListList == null) {
							filteredMemberListList = new ArrayList<Member>();
						}
						
						filteredMemberListList.add(member);
				}
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return filteredMemberListList;
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
