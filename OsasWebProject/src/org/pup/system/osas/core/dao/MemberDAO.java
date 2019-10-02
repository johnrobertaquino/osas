package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.Program;


public class MemberDAO extends DAO {

	public MemberDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public Member getMemberByMemberId(int memberId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Member member = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT MemberId, StudentNumber, FirstName, MiddleName, LastName, Program, Officer, OfficerPhoto, Position, Gender, Year, Section, ContactNumber, OrganizationId FROM member WHERE MemberId=" + memberId);  
			
			if (resultSet.next()) {
				member = new Member();
				member.setMemberId(resultSet.getInt("MemberId"));
				member.setStudentNumber(resultSet.getString("StudentNumber"));
				member.setFirstName(resultSet.getString("FirstName"));
				member.setMiddleName(resultSet.getString("MiddleName"));
				member.setLastName(resultSet.getString("LastName"));
				member.setProgram(new Program(resultSet.getString("Program")));
				member.setPosition(resultSet.getString("Position"));
				member.setOfficer(resultSet.getBoolean("Officer"));
				member.setOfficerPhoto(resultSet.getString("OfficerPhoto"));
				member.setGender(resultSet.getString("Gender"));
				member.setYear(resultSet.getString("Year"));
				member.setSection(resultSet.getString("Section"));
				member.setContactNumber(resultSet.getString("ContactNumber"));
				
				Organization organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				member.setOrganization(organization);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getMemberByMemberId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return member;
	}
	
	public void insertMember(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO member(MemberId, StudentNumber, FirstName, MiddleName, LastName, Program, Officer, OfficerPhoto, Position, Gender, Year, Section, ContactNumber, OrganizationId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, member.getMemberId());
			statement.setString(2, member.getStudentNumber());
			statement.setString(3, member.getFirstName());
			statement.setString(4, member.getMiddleName());
			statement.setString(5, member.getLastName());
			statement.setString(6, member.getProgram().getProgramCode());
			statement.setBoolean(7, member.isOfficer());
			statement.setString(8, member.getOfficerPhoto());
			statement.setString(9, member.getPosition());
			statement.setString(10, member.getGender());
			statement.setString(11, member.getYear());
			statement.setString(12, member.getSection());
			statement.setString(13, member.getContactNumber());
			statement.setInt(14, member.getOrganization().getOrganizationId());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				member.setMemberId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertMember method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<Member> getMemberList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Member member = null;
		List<Member> memberList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT member.MemberId, member.StudentNumber, member.FirstName, member.MiddleName, member.LastName, member.Program, member.Officer, member.OfficerPhoto, member.Position, member.Gender, member.Year, member.Section, member.ContactNumber, member.OrganizationId FROM member JOIN organization on member.OrganizationId = organization.OrganizationId WHERE organization.SemTermId=" + semTermId);
			
			while (resultSet.next()) {
				if (memberList == null) {
					memberList = new ArrayList<Member>();
				}
				
				member = new Member();
				member.setMemberId(resultSet.getInt("MemberId"));
				member.setStudentNumber(resultSet.getString("StudentNumber"));
				member.setFirstName(resultSet.getString("FirstName"));
				member.setMiddleName(resultSet.getString("MiddleName"));
				member.setLastName(resultSet.getString("LastName"));
				member.setProgram(new Program(resultSet.getString("Program")));
				member.setPosition(resultSet.getString("Position"));
				member.setOfficer(resultSet.getBoolean("Officer"));
				member.setOfficerPhoto(resultSet.getString("OfficerPhoto"));
				member.setGender(resultSet.getString("Gender"));
				member.setYear(resultSet.getString("Year"));
				member.setSection(resultSet.getString("Section"));
				member.setContactNumber(resultSet.getString("ContactNumber"));

				Organization organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				member.setOrganization(organization);
				
				memberList.add(member);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getMemberList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return memberList;
	}
	
	public List<Member> getMemberListByMemberSearchText(String memberSearchText, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Member member = null;
		List<Member> memberList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT member.MemberId, member.StudentNumber, member.FirstName, member.MiddleName, member.LastName, member.Program, member.Officer, member.OfficerPhoto, member.Position, member.Gender, member.Year, member.Section, member.ContactNumber, member.OrganizationId FROM member JOIN organization on member.OrganizationId = organization.OrganizationId WHERE (StudentNumber LIKE '%"
					+ memberSearchText + "%' OR member.FirstName LIKE '%" + memberSearchText + "%' OR member.MiddleName LIKE '%" + memberSearchText + "%' OR member.LastName LIKE '%" + memberSearchText + "%' OR member.Program LIKE '%" + memberSearchText + "%' OR member.Position LIKE '%" + memberSearchText + "%') AND organization.SemTermId=" + semTermId);  
			
			while (resultSet.next()) {
				if (memberList == null) {
					memberList = new ArrayList<Member>();
				}
				
				member = new Member();
				member.setMemberId(resultSet.getInt("MemberId"));
				member.setStudentNumber(resultSet.getString("StudentNumber"));
				member.setFirstName(resultSet.getString("FirstName"));
				member.setMiddleName(resultSet.getString("MiddleName"));
				member.setLastName(resultSet.getString("LastName"));
				member.setProgram(new Program(resultSet.getString("Program")));
				member.setOfficer(resultSet.getBoolean("Officer"));
				member.setOfficerPhoto(resultSet.getString("OfficerPhoto"));
				member.setGender(resultSet.getString("Gender"));
				member.setYear(resultSet.getString("Year"));
				member.setSection(resultSet.getString("Section"));
				member.setContactNumber(resultSet.getString("ContactNumber"));

				Organization organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				member.setOrganization(organization);
				
				memberList.add(member);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing get MemberList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return  memberList;
	}
	
	public void saveMember(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE member SET StudentNumber=?, FirstName=?, MiddleName=?, LastName=?, Program=?, Officer=?, OfficerPhoto=?, Position=?, Gender=?, Year=?, Section=?, ContactNumber=?, OrganizationId=? WHERE MemberId=?");
			statement.setString(1, member.getStudentNumber());
			statement.setString(2, member.getFirstName());
			statement.setString(3, member.getMiddleName());
			statement.setString(4, member.getLastName());
			statement.setString(5, member.getProgram().getProgramCode());
			statement.setBoolean(6, member.isOfficer());
			statement.setString(7, member.getOfficerPhoto());
			statement.setString(8, member.getPosition());
			statement.setString(9, member.getGender());
			statement.setString(10, member.getYear());
			statement.setString(11, member.getSection ());
			statement.setString(12, member.getContactNumber());
			statement.setInt(13, member.getOrganization().getOrganizationId());
			statement.setInt(14, member.getMemberId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveUser method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	
	public void deleteMemberByMemberId(int memberId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM member WHERE MemberId=?");
			statement.setInt(1, memberId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteMemberByMemberId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}