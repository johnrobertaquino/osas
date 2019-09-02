package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Member;


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
			
			resultSet = statement.executeQuery("SELECT MemberId, StudentNumber, FirstName, MiddleName, LastName, Program, Position, Oficer, Gender, Year, Section, ContactNumber, OrganizationId FROM scholar WHERE MemberId=" + memberId);  
			
			if (resultSet.next()) {
				member = new Member();
				member.setMemberId(resultSet.getInt("MemberId"));
				member.setStudentNumber(resultSet.getInt("StudentNumber"));
				member.setFirstName(resultSet.getString("FirstName"));
				member.setMiddleName(resultSet.getString("MiddleName"));
				member.setLastName(resultSet.getString("LastName"));
				member.setProgram(resultSet.getString("Program"));
				member.setPosition(resultSet.getString("Position"));
				member.setOfficer(resultSet.getBoolean("Officer"));
				member.setGender(resultSet.getString("Gender"));
				member.setYear(resultSet.getString("Year"));
				member.setSection(resultSet.getString("Section"));
				member.setContactNumber(resultSet.getInt("ContactNumber"));
				member.setOrganizationId(resultSet.getInt("OrganizationId"));
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

//			statement = connection.prepareStatement("INSERT INTO member(MemberId, StudentNumber, FirstName, MiddleName, LastName, Program, Position, Officer, Gender, Year, Section, ContactNumber, OrganizationId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, member.getMemberId());
			statement.setInt(2, member.getStudentNumber());
			statement.setString(3, member.getFirstName());
			statement.setString(4, member.getMiddleName());
			statement.setString(5, member.getLastName());
			statement.setString(6, member.getProgram());
			statement.setString(7, member.getPosition());
			statement.setBoolean(8, member.getOfficer());
			statement.setString(9, member.getGender());
			statement.setString(10, member.getYear());
			statement.setString(11, member.getSection());
			statement.setInt(12, member.getContactNumber());
			statement.setInt(13, member.getOrganizationId());
			
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
			
			resultSet = statement.executeQuery("SELECT * FROM scholar JOIN scholarshipprogram on scholar.ScholarshipProgramId = scholarshipprogram.ScholarshipProgramId JOIN agency on scholarshipprogram.AgencyId = agency.AgencyId WHERE agency.SemTermId =" + semTermId);
			
			while (resultSet.next()) {
				if (memberList == null) {
					memberList = new ArrayList<Member>();
				}
				
				member = new Member();
				member.setMemberId(resultSet.getInt("MemberId"));
				member.setStudentNumber(resultSet.getInt("StudentNumber"));
				member.setFirstName(resultSet.getString("FirstName"));
				member.setMiddleName(resultSet.getString("MiddleName"));
				member.setLastName(resultSet.getString("LastName"));
				member.setProgram(resultSet.getString("Program"));
				member.setPosition(resultSet.getString("Position"));
				member.setOfficer(resultSet.getBoolean("Officer"));
				member.setGender(resultSet.getString("Gender"));
				member.setYear(resultSet.getString("Year"));
				member.setSection(resultSet.getString("Section"));
				member.setContactNumber(resultSet.getInt("ContactNumber"));
				member.setOrganizationId(resultSet.getInt("OrganizationId"));
				
				memberList.add(member);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getMemberList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return memberList;
	}
	
	public List<Member> getMemberListByMemberSearchText(String memberSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Member member = null;
		List<Member> memberList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT MemberId, StudentNumber, FirstName, MiddleName, LastName, Program, Position, Officer, Gender , Year, Section, ContactNumber, OrganizationId  FROM member WHERE StudentNumber LIKE '%"
					+ memberSearchText + "%' OR FirstName LIKE '%" + memberSearchText + "%'");  
			
			while (resultSet.next()) {
				if (memberList == null) {
					memberList = new ArrayList<Member>();
				}
				
				member = new Member();
				member.setMemberId(resultSet.getInt("MemberId"));
				member.setStudentNumber(resultSet.getInt("StudentNumber"));
				member.setFirstName(resultSet.getString("FirstName"));
				member.setMiddleName(resultSet.getString("MiddleName"));
				member.setLastName(resultSet.getString("LastName"));
				member.setProgram(resultSet.getString("Program"));
				member.setOfficer(resultSet.getBoolean("Officer"));
				member.setGender(resultSet.getString("Gender"));
				member.setYear(resultSet.getString("Year"));
				member.setSection(resultSet.getString("Section"));
				member.setContactNumber(resultSet.getInt("ContactNumber"));
				member.setOrganizationId(resultSet.getInt("OrganizationId"));
				
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

			statement = connection.prepareStatement("UPDATE member SET StudentNumber=?, FirstName=?, MiddleName=?, LastName=?, Program=?, Position=?, Officer=?, Gender=?, Year=?, Section=?, ContactNumber=?, OrganizationId=?,  WHERE MemberId=?");
			statement.setInt (1, member.getStudentNumber());
			statement.setString(2, member.getFirstName());
			statement.setString(3, member.getMiddleName());
			statement.setString(4, member.getLastName());
			statement.setString(5, member.getProgram());
			statement.setString(6, member.getPosition());
			statement.setBoolean(7, member.getOfficer());
			statement.setString(8, member.getGender());
			statement.setString(9, member.getYear());
			statement.setString(10, member.getSection ());
			statement.setInt(11, member.getContactNumber());
			statement.setInt(12, member.getOrganizationId());
		
		
			
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
