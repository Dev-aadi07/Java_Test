package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcClass {

	public static void main(String[] args) {
		//URL
		//(API:vendor://ip:portnumber/dbname) 
		//(api-jdbc, vendor-mysql, id-localhost:portnumber-3306)
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "1234";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			
//			st.executeUpdate(
//					"INSERT INTO students VALUES (204, 'Alien', 234, 'alien@gmail.com')"
//					);
			st.executeUpdate("DELETE FROM students WHERE name = 'Alien'");
			rs = st.executeQuery("SELECT * FROM STUDENTS");
			
			
			while (rs.next()) {
				System.out.println(
						rs.getInt("id") +" "+
						rs.getString("name") +" "+
						rs.getInt("age")
						);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
