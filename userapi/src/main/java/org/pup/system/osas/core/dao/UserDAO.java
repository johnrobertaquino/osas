package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.pup.system.osas.core.domain.User;

public class UserDAO extends DAO {

	public UserDAO(Connection connection) {
		super(connection);
	}

	public User getUserByFullName(String firstName, String middleName, String lastName) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"SELECT UserId, UserName, Password, FirstName, MiddleName, LastName, Birthday, ContactNumber, Position FROM user WHERE FirstName=? AND MiddleName=? AND LastName=?");
			statement.setString(1, firstName);
			statement.setString(2, middleName);
			statement.setString(3, lastName);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("UserId"));
				user.setUserName(resultSet.getString("Username"));
				user.setPassword(resultSet.getString("Password"));
				user.setFirstName(resultSet.getString("Firstname"));
				user.setMiddleName(resultSet.getString("Middlename"));
				user.setLastName(resultSet.getString("LastName"));
				user.setBirthday(resultSet.getDate("Birthday"));
				user.setContactNumber(resultSet.getString("ContactNumber"));
				user.setPosition(resultSet.getString("Position"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getUserByUserName method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return user;
	}
}