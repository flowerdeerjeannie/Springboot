package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps;

		try {
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306/member";
			String USERNAME = "scott";
			String PASSWORD = "tiger";

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
