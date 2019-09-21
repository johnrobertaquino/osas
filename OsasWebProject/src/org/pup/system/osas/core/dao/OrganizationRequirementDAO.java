package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.domain.SemTerm;

public class OrganizationRequirementDAO extends DAO {

	public OrganizationRequirementDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public OrganizationRequirement getOrganizationRequirementByOrganizationRequirementName(String organizationRequirementName) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationRequirement organizationRequirement = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT OrganizationRequirementId, OrganizationRequirementName, SemTermId FROM OrganizationRequirement WHERE OrganizationRequirementName='"
							+ organizationRequirementName + "'");

			if (resultSet.next()) {
				organizationRequirement = new OrganizationRequirement();
				organizationRequirement.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organizationRequirement.setOrganizationRequirementName(resultSet.getString("OrganizationRequirementName"));

				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organizationRequirement.setSemTerm(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationByOrganizationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return organizationRequirement;
	}
	
	public OrganizationRequirement getOrganizationRequirementByOrganizationRequirementId(int organizationRequirementId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationRequirement organizationRequirement = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT OrganizationRequirementId, OrganizationRequirementName, SemTermId FROM OrganizationRequirement WHERE OrganizationRequirementId="
							+ organizationRequirementId);

			if (resultSet.next()) {
				organizationRequirement = new OrganizationRequirement();
				organizationRequirement.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organizationRequirement.setOrganizationRequirementName(resultSet.getString("OrganizationRequirementName"));

				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organizationRequirement.setSemTerm(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationByOrganizationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return organizationRequirement;
	}

	public void insertOrganizationRequirement(OrganizationRequirement organizationRequirement) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO OrganizationRequirement(OrganizationRequirementName, SemTermId) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, organizationRequirement.getOrganizationRequirementName());
			statement.setInt(2, organizationRequirement.getSemTerm().getSemTermId());
			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				organizationRequirement.setOrganizationRequirementId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertOrganizationRequirement method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<OrganizationRequirement> getOrganizationRequirementList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationRequirement organizationRequirement = null;
		List<OrganizationRequirement> organizationRequirementList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT OrganizationRequirementId, OrganizationRequirementName, SemTermId FROM organizationrequirement WHERE SemTermId =" + semTermId);

			while (resultSet.next()) {
				if (organizationRequirementList == null) {
					organizationRequirementList = new ArrayList<OrganizationRequirement>();
				}
				organizationRequirement = new OrganizationRequirement();
				organizationRequirement.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organizationRequirement.setOrganizationRequirementName(resultSet.getString("OrganizationRequirementName"));
				
				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organizationRequirement.setSemTerm(semTerm);

				organizationRequirementList.add(organizationRequirement);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationRequirementList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return organizationRequirementList;
	}

	public List<OrganizationRequirement> getOrganizationRequirementListByOrganizationRequirementSearchText(
		String organizationRequirementSearchText, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationRequirement organizationRequirement = null;
		List<OrganizationRequirement> organizationRequirementList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT OrganizationRequirementId, OrganizationRequirementName, SemTermId FROM organizationrequirement WHERE OrganizationRequirementName LIKE '%"
							+ organizationRequirementSearchText + "%' AND SemTermId="+ semTermId);

			while (resultSet.next()) {
				if (organizationRequirementList == null) {
					organizationRequirementList = new ArrayList<OrganizationRequirement>();
				}

				organizationRequirement = new OrganizationRequirement();
				organizationRequirement.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organizationRequirement.setOrganizationRequirementName(resultSet.getString("OrganizationRequirementName"));

				SemTerm semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				organizationRequirement.setSemTerm(semTerm);

				organizationRequirementList.add(organizationRequirement);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationRequirementListByOrganizationRequirementSearchText method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return organizationRequirementList;
	}

	public void saveOrganizationRequirement(OrganizationRequirement organizationRequirement) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"UPDATE organizationrequirement SET OrganizationRequirementName=? WHERE OrganizationRequirementId=?");
			statement.setString(1, organizationRequirement.getOrganizationRequirementName());
			statement.setInt(2, organizationRequirement.getOrganizationRequirementId());

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveOrganizationRequirement method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

	public void deleteOrganizationRequirementByOrganizationRequirementId(int organizationRequirementId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM organizationrequirement WHERE OrganizationRequirementId=?");
			statement.setInt(1, organizationRequirementId);

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteOrganizationRequirementByOrganizationRequirementId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
}
