package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.FirstTimeLoginReference;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationTypeCode;
import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.core.domain.UserRole;

public class OrganizationDAO extends DAO {

	public OrganizationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public Organization getOrganizationByOrganizationName(String organizationName) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, OrganizationTypeName, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName  FROM organization WHERE OrganizationName='" + organizationName +"'");  
			
			if (resultSet.next()) {
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationTypeCode organizationTypeCode = new OrganizationTypeCode();
				organizationTypeCode.setOrganizationTypeName(resultSet.getString("OrganizationTypeName"));
				organization.setOrganizationTypeCode(organizationTypeCode);
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organization.setSemTerm(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationByOrganizationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organization;
	}
	
	public Organization getOrganizationByOrganizationId(int organizationId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, OrganizationTypeName, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName  FROM organization WHERE OrganizationId=" + organizationId);  
			
			if (resultSet.next()) {
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationTypeCode organizationTypeCode = new OrganizationTypeCode();
				organizationTypeCode.setOrganizationTypeName(resultSet.getString("OrganizationTypeName"));
				organization.setOrganizationTypeCode(organizationTypeCode);
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organization.setSemTerm(semTerm);
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

			statement = connection.prepareStatement("INSERT INTO organization(OrganizationName, OrganizationTypeName, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, organization.getOrganizationName());
			statement.setString(2, organization.getOrganizationTypeCode().getOrganizationTypeName());
			statement.setString(3, organization.getProgram());
			statement.setInt(4, organization.getOrganizationTermId());
			statement.setInt(5, organization.getOrganizationRequirementId());
			statement.setString(6, organization.getAdviser());
			statement.setInt(7, organization.getSemTerm().getSemTermId());
			statement.setString(8, organization.getLogoFileName());
			
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

	public List< Organization> getOrganizationList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		 Organization  organization = null;
		List< Organization>  organizationList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT  OrganizationId,  OrganizationName, OrganizationTypeName, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName FROM organization WHERE SemTermId=" + semTermId);  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationTypeCode organizationTypeCode = new OrganizationTypeCode();
				organizationTypeCode.setOrganizationTypeName(resultSet.getString("OrganizationTypeName"));
				organization.setOrganizationTypeCode(organizationTypeCode);
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organization.setSemTerm(semTerm);
				
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
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, OrganizationTypeName, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName FROM organization WHERE OrganizationName LIKE '%"
					+ organizationSearchText + "%'");  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setProgram(resultSet.getString("Program"));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationTypeCode organizationTypeCode = new OrganizationTypeCode();
				organizationTypeCode.setOrganizationTypeName(resultSet.getString("OrganizationTypeName"));
				organization.setOrganizationTypeCode(organizationTypeCode);
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organization.setSemTerm(semTerm);
				
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

			statement = connection.prepareStatement("UPDATE organization SET OrganizationName=?, OrganizationTypeCode=?, Program=? Adviser=?, LogoFileName=? WHERE OrganizationId=?");
			statement.setString(1, organization.getOrganizationName());
			statement.setString(2, organization.getOrganizationTypeCode().getOrganizationTypeName());
			statement.setString(3, organization.getProgram());
			statement.setString(4, organization.getAdviser());
			statement.setString(5, organization.getLogoFileName());
			
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
	
	public OrganizationTypeCode getOrganizationTypeNameByOrganizationTypeCode(String organizationTypeCode) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationTypeCode organizationType = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationTypeCode, OrganizationTypeName FROM organizationtypecode WHERE OrganizationTypeCode='" + organizationTypeCode + "'");  
			
			if (resultSet.next()) {
				organizationType = new OrganizationTypeCode();
				
				organizationType.setOrganizationTypeCode(resultSet.getInt("OrganizationTypeCode"));
				organizationType.setOrganizationTypeName(resultSet.getString("OrganizationTypeName"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizatioTypenNameByOrganizationTypeCode method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organizationType;
	}

}
