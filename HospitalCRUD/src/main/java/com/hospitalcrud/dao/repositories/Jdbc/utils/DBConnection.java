package com.hospitalcrud.dao.repositories.Jdbc.utils;


import com.hospitalcrud.config.ConfigurationXml;
import org.springframework.stereotype.Component;

import java.sql.*;




@Component
public class DBConnection {

	private ConfigurationXml config;

	/**
	 * Opens Database connection
	 */

	public DBConnection(ConfigurationXml config) {
		this.config = config;
	}

	public Connection getConnection() throws SQLException {

		Connection conn = DriverManager
				.getConnection(config.getProperty("urlDB"), config.getProperty("user_name"), config.getProperty("password"));
                System.out.println("Connected to DB");
		return conn;
	}

	/**
	 * Closes connection
	 */
	public void closeConnection(Connection connArg) {
		System.out.println("Releasing all open resources ...");
		try {
			if (connArg != null) {
				connArg.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void releaseResource(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
        
        public void releaseResource(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
        
        public void releaseResource(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
