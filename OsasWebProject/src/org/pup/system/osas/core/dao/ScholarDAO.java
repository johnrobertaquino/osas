package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Scholar;

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
			
			resultSet = statement.executeQuery("SELECT ScholarId, StudentNumber, FirstName, MiddleName, LastName, Email, ContactNumber FROM scholar WHERE ScholarId=" + scholarId);  
			
			if (resultSet.next()) {
				scholar = new Scholar();
				scholar.setScholarId(resultSet.getInt("ScholarId"));
				scholar.setStudentNumber(resultSet.getString("StudentNumber"));
				scholar.setFirstName(resultSet.getString("FirstName"));
				scholar.setMiddleName(resultSet.getString("MiddleName"));
				scholar.setLastName(resultSet.getString("LastName"));
				scholar.setEmail(resultSet.getString("Email"));
				scholar.setContactNumber(resultSet.getString("ContactNumber"));
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

			statement = connection.prepareStatement("INSERT INTO scholar(StudentNumber, FirstName, MiddleName, LastName, Email, ContactNumber) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, scholar.getStudentNumber());
			statement.setString(2, scholar.getFirstName());
			statement.setString(3, scholar.getMiddleName());
			statement.setString(4, scholar.getLastName());
			statement.setString(5, scholar.getEmail());
			statement.setString(6, scholar.getContactNumber());

			
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

	public List<Scholar> getScholarList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scholar scholar = null;
		List<Scholar> scholarList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT ScholarId, StudentNumber, FirstName, MiddleName, LastName, Email, ContactNumber FROM scholar");  
			
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
				
				scholarList.add(scholar);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return scholarList;
	}
	
	public List<Scholar> getScholarListByScholarSearchText(String scholarSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scholar scholar = null;
		List<Scholar> scholarList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT ScholarId, StudentNumber, FirstName, MiddleName, LastName, Email, ContactNumber FROM scholar WHERE StudentNumber LIKE '%"
					+ scholarSearchText + "%' OR FirstName LIKE '%" + scholarSearchText + "%'");  
			
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

			statement = connection.prepareStatement("UPDATE scholar SET StudentNumber=?, FirstName=?, MiddleName=?, LastName=?, Email=?, ContactNumber=? WHERE ScholarId=?");
			statement.setString(1, scholar.getStudentNumber());
			statement.setString(2, scholar.getFirstName());
			statement.setString(3, scholar.getMiddleName());
			statement.setString(4, scholar.getLastName());
			statement.setString(5, scholar.getEmail());
			statement.setString(6, scholar.getContactNumber());
			statement.setInt(7, scholar.getScholarId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveUser method", e);
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