package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberDTO;

//로그 데이터베이스 접근 객체
@Repository
public class LogDao {

	private Connection con = null;
	
	public LogDao() throws SQLException {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/musthave";
		String USERNAME = "scott";
		String PASSWORD = "tiger";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public void addLog(String method, String sqlstring, boolean success) {
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO dblog (method, sqlString, success) values (?, ?, ?)");
			
			st.setString(1,method);
			st.setString(2, sqlstring);
			st.setBoolean(3, success);
			st.executeUpdate();
			//내 실수.executequery는 select만, 나머지는 update
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
