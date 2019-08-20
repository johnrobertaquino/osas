package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Organization;

public class OrganizationDAO extends DAO {

	public OrganizationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public Organization getOrganizationByOrganizationId(int organizationId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId  FROM organization WHERE OrganizationId=" + organizationId);  
			
			if (resultSet.next()) {
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setSemTermId(resultSet.getInt("SemTermId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationByOrganizationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organization;
	}
	
	public void insertOrganization(Organization organization) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO organization(OrganizationName, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, organization.getOrganizationName());
			statement.setString(2, organization.getOrganizationTypeCode());
			statement.setString(3, organization.getProgram());
			statement.setInt(4, organization.getOrganizationTermId());
			statement.setInt(5, organization.getOrganizationRequirementId());
			statement.setString(6, organization.getAdviser());
			statement.setInt(7, organization.getSemTermId());

			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				 organization.setOrganizationId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertOrganization method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List< Organization> getOrganizationList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		 Organization  organization = null;
		List< Organization>  organizationList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT  OrganizationId,  OrganizationName, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId FROM organization");  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setSemTermId(resultSet.getInt("SemTermId"));
				
				organizationList.add(organization);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getorganizationList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organizationList;
	}
	
	public List<Organization> getOrganizationListByOrganizationSearchText(String organizationSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		List<Organization> organizationList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId  FROM organization WHERE OrganizationName LIKE '%"
					+ organizationSearchText + "%'");  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setSemTermId(resultSet.getInt("SemTermId"));
	
				organizationList.add(organization);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organizationList;
	}
	
	public void saveOrganization(Organization organization) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE organization SET OrganizationName=?, OrganizationTypeCode=?, Program=? Adviser=? WHERE OrganizationId=?");
			statement.setString(1, organization.getOrganizationName());
			statement.setString(2, organization.getOrganizationTypeCode());
			statement.setString(3, organization.getProgram());
			statement.setString(6, organization.getAdviser());

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveUser method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	
	public void deleteOrganizationByOrganizationId(int organizationId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM organization WHERE OrganizationId=?");
			statement.setInt(1,organizationId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteOrganizationByorganizationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
