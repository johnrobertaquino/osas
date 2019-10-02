package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.pup.system.osas.core.domain.OrganizationQualification;

public class OrganizationQualificationDAO extends DAO {

	public OrganizationQualificationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public OrganizationQualification getOrganizationQualificationByOrganizationRequirementIdAndOrganizationId(
			int organizationRequirementId, int organizationId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationQualification organizationQualification = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT OrganizationQualificationId, OrganizationRequirementId, Qualified, Notes, DateSubmitted, Filename, OrganizationId FROM organizationqualification WHERE OrganizationRequirementId="
							+ organizationRequirementId + " AND OrganizationId=" + organizationId);

			if (resultSet.next()) {
				organizationQualification = new OrganizationQualification();
				organizationQualification.setOrganizationQualificationId(resultSet.getInt("OrganizationQualificationId"));
				organizationQualification.setOrganizationRequirementId(resultSet.getInt("OrganizationQualificationId"));
				organizationQualification.setQualified(resultSet.getBoolean("Qualified"));
				organizationQualification.setNotes(resultSet.getString("Notes"));
				organizationQualification.setDateSubmitted(resultSet.getDate("DateSubmitted"));
				organizationQualification.setFileName(resultSet.getString("Filename"));
				organizationQualification.setOrganizationId(resultSet.getInt("OrganizationId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationQualificationByOrganizationshipQualificationIdAndOrganizationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return organizationQualification;
	}
	
	public OrganizationQualification getOrganizationQualificationByOrganizationQualificationId(
			int organizationQualificationId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrganizationQualification organizationQualification = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT OrganizationQualificationId, OrganizationRequirementId, Qualified, Notes, DateSubmitted, Filename, OrganizationId FROM organizationqualification WHERE OrganizationQualificationId="
							+ organizationQualificationId);

			if (resultSet.next()) {
				organizationQualification = new OrganizationQualification();
				organizationQualification.setOrganizationQualificationId(resultSet.getInt("OrganizationQualificationId"));
				organizationQualification.setOrganizationRequirementId(resultSet.getInt("OrganizationRequirementId"));
				organizationQualification.setQualified(resultSet.getBoolean("Qualified"));
				organizationQualification.setNotes(resultSet.getString("Notes"));
				organizationQualification.setDateSubmitted(resultSet.getDate("DateSubmitted"));
				organizationQualification.setFileName(resultSet.getString("Filename"));
				organizationQualification.setOrganizationId(resultSet.getInt("OrganizationId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getOrganizationQualificationByOrganizationQualificationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return organizationQualification;
	}
	
	public void insertOrganizationQualification(OrganizationQualification organizationQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO organizationqualification(OrganizationRequirementId, Qualified, Notes, DateSubmitted, Filename, OrganizationId) VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, organizationQualification.getOrganizationRequirementId());
			statement.setBoolean(2, organizationQualification.isQualified());
			statement.setString(3, organizationQualification.getNotes());
			statement.setDate(4, new Date(organizationQualification.getDateSubmitted().getTime()));
			statement.setString(5, organizationQualification.getFileName());
			statement.setInt(6, organizationQualification.getOrganizationId());

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				organizationQualification.setOrganizationQualificationId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertOrganizationshipQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	
	public void saveOrganizationQualification(OrganizationQualification organizationQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE organizationqualification SET OrganizationRequirementId=?, Qualified=?, Notes=?, DateSubmitted=?, Filename=?, OrganizationId=? WHERE OrganizationQualificationId=?");
			statement.setInt(1, organizationQualification.getOrganizationRequirementId());
			statement.setBoolean(2, organizationQualification.isQualified());
			statement.setString(3, organizationQualification.getNotes());
			statement.setDate(4, new Date(organizationQualification.getDateSubmitted().getTime()));
			statement.setString(5, organizationQualification.getFileName());
			statement.setInt(6, organizationQualification.getOrganizationId());
			statement.setInt(7, organizationQualification.getOrganizationQualificationId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveOrganizationQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
