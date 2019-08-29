	package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.core.domain.User;

public class AgencyDAO extends DAO {

	public AgencyDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public Agency getAgencyByAgencyName(String agencyName) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Agency agency = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT AgencyId, AgencyName, Address, ContactPerson, ContactNumber, SemTermId FROM agency WHERE AgencyName=" + agencyName);  
			
			if (resultSet.next()) {
				agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				agency.setAddress(resultSet.getString("Address"));
				agency.setAgencyName(resultSet.getString("AgencyName"));
				agency.setContactPerson(resultSet.getString("ContactPerson"));
				agency.setContactNumber(resultSet.getString("ContactNumber"));

				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				agency.setSemTerm(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyByAgencyName method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return agency;
	}
	
	public Agency getAgencyByAgencyId(int agencyId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Agency agency = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT AgencyId, AgencyName, Address, ContactPerson, ContactNumber, SemTermId FROM agency WHERE AgencyId=" + agencyId);  
			
			if (resultSet.next()) {
				agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				agency.setAddress(resultSet.getString("Address"));
				agency.setAgencyName(resultSet.getString("AgencyName"));
				agency.setContactPerson(resultSet.getString("ContactPerson"));
				agency.setContactNumber(resultSet.getString("ContactNumber"));

				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				agency.setSemTerm(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyByAgencyId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return agency;
	}
	
	public void insertAgency(Agency agency) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO agency(AgencyName, Address, ContactPerson, ContactNumber, SemTermId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, agency.getAgencyName());
			statement.setString(2, agency.getAddress());
			statement.setString(3, agency.getContactPerson());
			statement.setString(4, agency.getContactNumber());
			statement.setInt(5, agency.getSemTerm().getSemTermId());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				agency.setAgencyId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertAgency method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<Agency> getAgencyList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Agency agency = null;
		List<Agency> agencyList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT AgencyId, AgencyName, Address, ContactNumber, ContactPerson, SemTermId FROM agency WHERE SemTermId =" + semTermId);  
			
			while (resultSet.next()) {
				if (agencyList == null) {
					agencyList = new ArrayList<Agency>();
				}
				
				agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				agency.setAgencyName(resultSet.getString("AgencyName"));
				agency.setAddress(resultSet.getString("Address"));
				agency.setContactNumber(resultSet.getString("ContactNumber"));
				agency.setContactPerson(resultSet.getString("ContactPerson"));

				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				agency.setSemTerm(semTerm);
				
				agencyList.add(agency);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return agencyList;
	}
	
	public List<Agency> getAgencyListByAgencySearchText(String agencySearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Agency agency = null;
		List<Agency> agencyList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT AgencyId, AgencyName, Address, ContactPerson, ContactNumber FROM agency WHERE AgencyName LIKE '%"
					+ agencySearchText + "%' OR Address LIKE '%" + agencySearchText + "%'");  
			
			while (resultSet.next()) {
				if (agencyList == null) {
					agencyList = new ArrayList<Agency>();
				}
				
				agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				agency.setAgencyName(resultSet.getString("AgencyName"));
				agency.setAddress(resultSet.getString("Address"));
				agency.setContactPerson(resultSet.getString("ContactPerson"));
				agency.setContactNumber(resultSet.getString("ContactNumber"));
	
				agencyList.add(agency);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return agencyList;
	}
	
	public void saveAgency(Agency agency) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE agency SET AgencyName=?, Address=?, ContactPerson=?, ContactNumber=? WHERE AgencyId=?");
			statement.setString(1, agency.getAgencyName());
			statement.setString(2, agency.getAddress());
			statement.setString(3, agency.getContactPerson());
			statement.setString(4, agency.getContactNumber());
			statement.setInt(5, agency.getAgencyId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveUser method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	
	public void deleteAgencyByAgencyId(int agencyId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM agency WHERE AgencyId=?");
			statement.setInt(1, agencyId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteAgencyByAgencyId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
