package org.pup.system.osas.core.dao;

import java.sql.Connection;

public class DAO {

	private Connection connection;

	protected DAO(Connection connection) {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}

}
