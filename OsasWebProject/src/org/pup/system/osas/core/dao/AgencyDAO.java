package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.AgencyScholarshipTerm;
import org.pup.system.osas.core.domain.ScholarshipTerm;

public class AgencyDAO extends DAO {

	public AgencyDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	/** Agency **/
	public Agency getAgencyByAgencyId(int agencyId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Agency agency = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT AgencyId, AgencyName, Address, ContactPerson, ContactNumber FROM agency WHERE AgencyId ="
							+ agencyId);

			if (resultSet.next()) {
				agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				agency.setAddress(resultSet.getString("Address"));
				agency.setAgencyName(resultSet.getString("AgencyName"));
				agency.setContactPerson(resultSet.getString("ContactPerson"));
				agency.setContactNumber(resultSet.getString("ContactNumber"));
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

			statement = connection.prepareStatement(
					"INSERT INTO agency(AgencyName, Address, ContactPerson, ContactNumber) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, agency.getAgencyName());
			statement.setString(2, agency.getAddress());
			statement.setString(3, agency.getContactPerson());
			statement.setString(4, agency.getContactNumber());

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

	public List<Agency> getAgencyList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Agency agency = null;
		List<Agency> agencyList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement
					.executeQuery("SELECT AgencyId, AgencyName, Address, ContactNumber, ContactPerson FROM agency");

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

			resultSet = statement.executeQuery(
					"SELECT AgencyId, AgencyName, Address, ContactPerson, ContactNumber FROM agency WHERE AgencyName LIKE '%"
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

			statement = connection.prepareStatement(
					"UPDATE agency SET AgencyName=?, Address=?, ContactPerson=?, ContactNumber=? WHERE AgencyId=?");
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

	/** AgencyScholarshipTerm **/
	public AgencyScholarshipTerm getAgencyScholarshipTermByAgencyScholarshipTermId(int agencyScholarshipTermId)
			throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		AgencyScholarshipTerm agencyScholarshipTerm = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT AgencyScholarShipTermId, AgencyId, ScholarshipTermId from agencyscholarshipterm WHERE AgencyScholarShipTermId ="
							+ agencyScholarshipTermId);

			if (resultSet.next()) {
				agencyScholarshipTerm = new AgencyScholarshipTerm();
				agencyScholarshipTerm.setAgency(new Agency(resultSet.getInt("AgencyId")));
				agencyScholarshipTerm.setAgencyScholarTermId(resultSet.getInt("AgencyScholarShipTermId"));
				agencyScholarshipTerm.setScholarshipTerm(new ScholarshipTerm(resultSet.getInt("ScholarshipTermId")));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyScholarshipTermByAgencyScholarshipTermId method",
					e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return agencyScholarshipTerm;
	}

	public List<AgencyScholarshipTerm> getAgencyScholarshipTermList(int scholarshipTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		AgencyScholarshipTerm agencyScholarshipTerm = null;
		List<AgencyScholarshipTerm> agencyScholarshipTermList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT AgencyScholarShipTermId, AgencyId, ScholarshipTermId from agencyscholarshipterm WHERE ScholarshipTermId ="
							+ scholarshipTermId);

			while (resultSet.next()) {
				if (agencyScholarshipTermList == null) {
					agencyScholarshipTermList = new ArrayList<AgencyScholarshipTerm>();
				}

				agencyScholarshipTerm = new AgencyScholarshipTerm();
				agencyScholarshipTerm.setAgency(new Agency(resultSet.getInt("AgencyId")));
				agencyScholarshipTerm.setAgencyScholarTermId(resultSet.getInt("AgencyScholarShipTermId"));
				agencyScholarshipTerm.setScholarshipTerm(new ScholarshipTerm(resultSet.getInt("ScholarshipTermId")));

				agencyScholarshipTermList.add(agencyScholarshipTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyScholarshipTermList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return agencyScholarshipTermList;
	}

	public List<AgencyScholarshipTerm> getAgencyScholarshipTermListAgencySearchText(String agencySearchText,
			int scholarshipTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		AgencyScholarshipTerm agencyScholarshipTerm = null;
		List<AgencyScholarshipTerm> agencyScholarshipTermList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT agencyscholarshipterm.AgencyScholarShipTermId, agencyscholarshipterm.ScholarshipTermId,"
							+ " from agencyscholarshipterm"
							+ " JOIN agency on agencyscholarshipterm.AgencyId = agency.AgencyId"
							+ " WHERE ScholarshipTermId =" + scholarshipTermId + " AND AgencyName LIKE '%"
							+ agencySearchText + "%' OR Address LIKE '%" + agencySearchText + "%'");

			while (resultSet.next()) {
				if (agencyScholarshipTermList == null) {
					agencyScholarshipTermList = new ArrayList<AgencyScholarshipTerm>();
				}

				agencyScholarshipTerm = new AgencyScholarshipTerm();
				agencyScholarshipTerm.setAgency(new Agency(resultSet.getInt("AgencyId")));
				agencyScholarshipTerm.setAgencyScholarTermId(resultSet.getInt("AgencyScholarShipTermId"));
				agencyScholarshipTerm.setScholarshipTerm(new ScholarshipTerm(resultSet.getInt("ScholarshipTermId")));

				agencyScholarshipTermList.add(agencyScholarshipTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyScholarshipTermList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return agencyScholarshipTermList;
	}

}
