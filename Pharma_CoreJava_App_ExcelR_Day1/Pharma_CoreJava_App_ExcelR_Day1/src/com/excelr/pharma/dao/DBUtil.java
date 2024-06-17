package com.excelr.pharma.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.excelr.pharma.exceptions.PharmaException;

/**
 * @author admin
 *
 */
public final class DBUtil {
	private DBUtil() {

	}

	/**
	 * @return Connection
	 * @throws PharmaException
	 */
	public static Connection getConnection() throws PharmaException {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "Training");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			throw new PharmaException(e.getMessage());
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new PharmaException(e.getMessage());
		}
		return connection;
	}
}
