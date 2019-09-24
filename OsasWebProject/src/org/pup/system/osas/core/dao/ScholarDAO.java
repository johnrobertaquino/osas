package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;

public class ScholarDAO extends DAO {

	public ScholarDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public Scholar getScholarByScholarId(int scholarId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scholar scholar = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT ScholarId, StudentNumber, FirstName, MiddleName, LastName, Email, ContactNumber, Program, Year, Section, GWA, ScholarshipProgramId FROM scholar WHERE ScholarId=" + scholarId);  
			
			if (resultSet.next()) {
				scholar = new Scholar();
				scholar.setScholarId(resultSet.getInt("ScholarId"));
				scholar.setStudentNumber(resultSet.getString("StudentNumber"));
				scholar.setFirstName(resultSet.getString("FirstName"));
				scholar.setMiddleName(resultSet.getString("MiddleName"));
				scholar.setLastName(resultSet.getString("LastName"));
				scholar.setEmail(resultSet.getString("Email"));
				scholar.setContactNumber(resultSet.getString("ContactNumber"));
				scholar.setProgram(new Program(resultSet.getString("Program")));
				scholar.setYear(resultSet.getString("Year"));
				scholar.setSection(resultSet.getString("Section"));
				scholar.setGwa(resultSet.getString("GWA"));

				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholar.setScholarshipProgram(scholarshipProgram);
			
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarByScholarId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return scholar;
	}
	
	public void insertScholar(Scholar scholar) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO scholar(StudentNumber, FirstName, MiddleName, LastName, Email, ContactNumber, Program, Year, Section, GWA, ScholarshipProgramId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, scholar.getStudentNumber());
			statement.setString(2, scholar.getFirstName());
			statement.setString(3, scholar.getMiddleName());
			statement.setString(4, scholar.getLastName());
			statement.setString(5, scholar.getEmail());
			statement.setString(6, scholar.getContactNumber());
			statement.setString(7, scholar.getProgram().getProgramCode());
			statement.setString(8, scholar.getYear());
			statement.setString(9, scholar.getSection());
			statement.setString(10, scholar.getGwa());
			statement.setInt(11, scholar.getScholarshipProgram().getScholarshipProgramId());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				scholar.setScholarId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertScholar method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<Scholar> getScholarList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scholar scholar = null;
		List<Scholar> scholarList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT scholar.ScholarId, scholar.StudentNumber, scholar.FirstName, scholar.MiddleName, scholar.LastName, scholar.Email, scholar.ContactNumber, scholar.Program, scholar.Year, scholar.Section, scholar.GWA, scholar.ScholarshipProgramId FROM scholar JOIN scholarshipprogram on scholar.ScholarshipProgramId = scholarshipprogram.ScholarshipProgramId JOIN agency on scholarshipprogram.AgencyId = agency.AgencyId WHERE agency.SemTermId =" + semTermId);
			
			while (resultSet.next()) {
				if (scholarList == null) {
					scholarList = new ArrayList<Scholar>();
				}
				
				scholar = new Scholar();
				scholar.setScholarId(resultSet.getInt("ScholarId"));
				scholar.setStudentNumber(resultSet.getString("StudentNumber"));
				scholar.setFirstName(resultSet.getString("FirstName"));
				scholar.setMiddleName(resultSet.getString("MiddleName"));
				scholar.setLastName(resultSet.getString("LastName"));
				scholar.setEmail(resultSet.getString("Email"));
				scholar.setContactNumber(resultSet.getString("ContactNumber"));
				scholar.setProgram(new Program(resultSet.getString("Program")));
				scholar.setYear(resultSet.getString("Year"));
				scholar.setSection(resultSet.getString("Section"));
				scholar.setGwa(resultSet.getString("GWA"));
				
				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholar.setScholarshipProgram(scholarshipProgram);
				
				scholarList.add(scholar);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return scholarList;
	}
	
	public List<Scholar> getScholarListByProgramAndScholarshipProgramId(int semTermId, String program, int scholarProgramId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scholar scholar = null;
		List<Scholar> scholarList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT scholar.ScholarId, scholar.StudentNumber, scholar.FirstName, scholar.MiddleName, scholar.LastName, scholar.Email, scholar.ContactNumber, scholar.Program, scholar.Year, scholar.Section, scholar.GWA, scholar.ScholarshipProgramId FROM scholar JOIN scholarshipprogram on scholar.ScholarshipProgramId = scholarshipprogram.ScholarshipProgramId JOIN agency on scholarshipprogram.AgencyId = agency.AgencyId WHERE agency.SemTermId =" + semTermId
					+ " AND scholar.Program='" + program + "' AND scholar.ScholarshipProgramId=" + scholarProgramId + " order by scholar.Year");
			
			while (resultSet.next()) {
				if (scholarList == null) {
					scholarList = new ArrayList<Scholar>();
				}
				
				scholar = new Scholar();
				scholar.setScholarId(resultSet.getInt("ScholarId"));
				scholar.setStudentNumber(resultSet.getString("StudentNumber"));
				scholar.setFirstName(resultSet.getString("FirstName"));
				scholar.setMiddleName(resultSet.getString("MiddleName"));
				scholar.setLastName(resultSet.getString("LastName"));
				scholar.setEmail(resultSet.getString("Email"));
				scholar.setContactNumber(resultSet.getString("ContactNumber"));
				scholar.setProgram(new Program(resultSet.getString("Program")));
				scholar.setYear(resultSet.getString("Year"));
				scholar.setSection(resultSet.getString("Section"));
				scholar.setGwa(resultSet.getString("GWA"));
				
				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholar.setScholarshipProgram(scholarshipProgram);
				
				scholarList.add(scholar);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return scholarList;
	}
	
	public List<Scholar> getScholarListByScholarSearchText(String scholarSearchText, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scholar scholar = null;
		List<Scholar> scholarList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT scholar.ScholarId, scholar.StudentNumber, scholar.FirstName, scholar.MiddleName, scholar.LastName, scholar.Email, scholar.ContactNumber, scholar.Program, scholar.Year, scholar.Section, scholar.GWA, scholar.ScholarshipProgramId FROM scholar JOIN scholarshipprogram on scholar.ScholarshipProgramId = scholarshipprogram.ScholarshipProgramId JOIN agency on scholarshipprogram.AgencyId = agency.AgencyId WHERE (scholar.StudentNumber LIKE '%"
					+ scholarSearchText + "%' OR scholar.FirstName LIKE '%" + scholarSearchText + "%' OR scholar.MiddleName LIKE '%" + scholarSearchText + "%' OR scholar.LastName LIKE '%" + scholarSearchText + "%' OR scholar.Program LIKE '%" + scholarSearchText + "%') AND agency.SemTermId =" + semTermId);  
			
			while (resultSet.next()) {
				if (scholarList == null) {
					scholarList = new ArrayList<Scholar>();
				}
				
				scholar = new Scholar();
				scholar.setScholarId(resultSet.getInt("ScholarId"));
				scholar.setStudentNumber(resultSet.getString("StudentNumber"));
				scholar.setFirstName(resultSet.getString("FirstName"));
				scholar.setMiddleName(resultSet.getString("MiddleName"));
				scholar.setLastName(resultSet.getString("LastName"));
				scholar.setEmail(resultSet.getString("Email"));
				scholar.setContactNumber(resultSet.getString("ContactNumber"));
				scholar.setProgram(new Program(resultSet.getString("Program")));
				scholar.setYear(resultSet.getString("Year"));
				scholar.setSection(resultSet.getString("Section"));
				scholar.setGwa(resultSet.getString("GWA"));
				
				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholar.setScholarshipProgram(scholarshipProgram);
	
				scholarList.add(scholar);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return scholarList;
	}
	
	public void saveScholar(Scholar scholar) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE scholar SET StudentNumber=?, FirstName=?, MiddleName=?, LastName=?, Email=?, ContactNumber=?, Program=?, Year=?, Section=?, GWA=? WHERE ScholarId=?");
			statement.setString(1, scholar.getStudentNumber());
			statement.setString(2, scholar.getFirstName());
			statement.setString(3, scholar.getMiddleName());
			statement.setString(4, scholar.getLastName());
			statement.setString(5, scholar.getEmail());
			statement.setString(6, scholar.getContactNumber());
			statement.setString(7, scholar.getProgram().getProgramCode());
			statement.setString(8, scholar.getYear());
			statement.setString(9, scholar.getSection());
			statement.setString(10, scholar.getGwa());
			statement.setInt(11, scholar.getScholarId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveScholar method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	
	public void deleteScholarByScholarId(int scholarId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM scholar WHERE ScholarId=?");
			statement.setInt(1, scholarId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteScholarByScholarId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
