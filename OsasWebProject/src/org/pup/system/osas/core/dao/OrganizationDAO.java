package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationType;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.SemTerm;
	
public class OrganizationDAO extends DAO {

	public OrganizationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public Organization getOrganizationByOrganizationName(String organizationName, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, Description, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName  FROM organization WHERE OrganizationName='" + organizationName +"' AND SemTermId="+semTermId);  
			
			if (resultSet.next()) {
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setDescription(resultSet.getString("Description"));
				organization.setProgram(new Program(resultSet.getString("Program")));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationType organizationTypeCode = new OrganizationType();
				organizationTypeCode.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setOrganizationType(organizationTypeCode);
				
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
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, Description, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName  FROM organization WHERE OrganizationId=" + organizationId);  
			
			if (resultSet.next()) {
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setDescription(resultSet.getString("Description"));
				organization.setProgram(new Program(resultSet.getString("Program")));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationType organizationTypeCode = new OrganizationType();
				organizationTypeCode.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setOrganizationType(organizationTypeCode);
				
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

			statement = connection.prepareStatement("INSERT INTO organization(OrganizationName, Description, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, organization.getOrganizationName());
			statement.setString(2, organization.getDescription());
			statement.setString(3, organization.getOrganizationType().getOrganizationTypeCode());
			statement.setString(4, organization.getProgram().getProgramCode());
			statement.setInt(5, organization.getOrganizationTermId());
			statement.setInt(6, organization.getOrganizationRequirementId());
			statement.setString(7, organization.getAdviser());
			statement.setInt(8, organization.getSemTerm().getSemTermId());
			statement.setString(9, organization.getLogoFileName());
			
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

	public List<Organization> getOrganizationList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		 Organization  organization = null;
		List< Organization>  organizationList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT  OrganizationId,  OrganizationName, Description, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName FROM organization WHERE SemTermId=" + semTermId);  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setDescription(resultSet.getString("Description"));
				organization.setProgram(new Program(resultSet.getString("Program")));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationType organizationType = new OrganizationType();
				organizationType.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setOrganizationType(organizationType);
				
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
	
	public List<Organization> getOrganizationListByYearlyTermId(int yearlyTermId, String organizationTypeCode) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		 Organization  organization = null;
		List< Organization>  organizationList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT  organization.OrganizationId,  organization.OrganizationName, organization.Description, organization.OrganizationTypeCode, organization.Program, organization.OrganizationTermId, organization.OrganizationRequirementId, organization.Adviser, organization.SemTermId, organization.LogoFileName FROM organization JOIN organizationtype on organization.OrganizationTypeCode = organizationtype.OrganizationTypeCode JOIN semTerm on organization.SemTermId = semTerm.SemTermId JOIN yearlyTerm on semTerm.YearlyTermId = yearlyTerm.YearlyTermId WHERE yearlyTerm.YearlyTermId=" + yearlyTermId + " AND organizationtype.OrganizationTypeCode='"+organizationTypeCode+"'");  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setDescription(resultSet.getString("Description"));
				organization.setProgram(new Program(resultSet.getString("Program")));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationType organizationType = new OrganizationType();
				organizationType.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setOrganizationType(organizationType);
				
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
	
	public List<Organization> getOrganizationListByOrganizationSearchText(String organizationSearchText, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Organization organization = null;
		List<Organization> organizationList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationId, OrganizationName, Description, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName FROM organization WHERE (OrganizationName LIKE '%"
					+ organizationSearchText + "%' OR Description LIKE '%" + organizationSearchText + "%') AND SemTermId =" + semTermId);  
			
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setDescription(resultSet.getString("Description"));
				organization.setProgram(new Program(resultSet.getString("Program")));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationType organizationType = new OrganizationType();
				organizationType.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setOrganizationType(organizationType);
				
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

			statement = connection.prepareStatement("UPDATE organization SET OrganizationName=?, Description=?, OrganizationTypeCode=?, Program=?, Adviser=?, LogoFileName=? WHERE OrganizationId=?");
			statement.setString(1, organization.getOrganizationName());
			statement.setString(2, organization.getDescription());
			statement.setString(3, organization.getOrganizationType().getOrganizationTypeCode());
			statement.setString(4, organization.getProgram().getProgramCode());
			statement.setString(5, organization.getAdviser());
			statement.setString(6, organization.getLogoFileName());
			statement.setInt(7, organization.getOrganizationId());
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
	
	public OrganizationType getOrganizationTypeNameByOrganizationTypeCode(String organizationTypeCode) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationType organizationType = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT OrganizationTypeCode, OrganizationTypeName FROM organizationtype WHERE OrganizationTypeCode='" + organizationTypeCode + "'");  
			
			if (resultSet.next()) {
				organizationType = new OrganizationType();
				
				organizationType.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organizationType.setOrganizationTypeName(resultSet.getString("OrganizationTypeName"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizatioTypenNameByOrganizationTypeCode method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organizationType;
	}
	
	public List<Organization> getOrganizationListByMemberId(int memberId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Organization> organizationList = null;
		Organization organization = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT organization.OrganizationId,  OrganizationName, Description, OrganizationTypeCode, Program, OrganizationTermId, OrganizationRequirementId, Adviser, SemTermId, LogoFileName " + 
					"from organization join memberorganizationreference on organization.OrganizationId = memberorganizationreference.OrganizationId " + 
					"where memberorganizationreference.MemberId=" + memberId);
			while (resultSet.next()) {
				if (organizationList == null) {
					organizationList = new ArrayList<Organization>();
				}
				
				organization = new Organization();
				organization.setOrganizationId(resultSet.getInt("OrganizationId"));
				organization.setOrganizationName(resultSet.getString("OrganizationName"));
				organization.setDescription(resultSet.getString("Description"));
				organization.setProgram(new Program(resultSet.getString("Program")));
				organization.setOrganizationTermId(resultSet.getInt("OrganizationTermId"));
				organization.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organization.setAdviser(resultSet.getString("Adviser"));
				organization.setLogoFileName(resultSet.getString("LogoFileName"));
				
				OrganizationType organizationType = new OrganizationType();
				organizationType.setOrganizationTypeCode(resultSet.getString("OrganizationTypeCode"));
				organization.setOrganizationType(organizationType);
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organization.setSemTerm(semTerm);
				
				organizationList.add(organization);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationListByMemberId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return organizationList;
	}
	
	public void deleteOrganizationByMemberId(int memberId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM memberorganizationreference WHERE MemberId=?");
			statement.setInt(1,memberId);
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteOrganizationByMemberId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
	
	public void insertOrganizationByMemberId(int memberId, Organization organization) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO memberorganizationreference (MemberId, OrganizationId) VALUES (?,?)");
			statement.setInt(1,memberId);
			statement.setInt(2,organization.getOrganizationId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing addOrganizationByMemberId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
