package com.sample;

//step1
import java.sql.*;

public class CallableDemo2 {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement stmt=null;
		//ResultSet rs=null;
		String url="";
		String username="";
		String password="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // Step 2 
			url="jdbc:oracle:thin:@localhost:1521:ORCL";  // type 4
			username="System";
			password="admin";
			
			con= DriverManager.getConnection(url,username,password);  // Step 3
			
			stmt=con.prepareCall("{call INC_SAL(?,?,?) }");
			stmt.setInt(1, 7934);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.DOUBLE);
		
			stmt.execute();
			
			//int newsal= stmt.getInt(1);
			System.out.println(stmt.getString(2));
			System.out.println(stmt.getDouble(3));
			con.close(); // step 6
			stmt.close();
			//rs.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		finally {
			
		}

	}

}
