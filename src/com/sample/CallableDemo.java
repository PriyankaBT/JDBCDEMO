package com.sample;

//step1
import java.sql.*;

public class CallableDemo {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement stmt=null;
		ResultSet rs=null;
		String url="";
		String username="";
		String password="";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // Step 2 
			url="jdbc:oracle:thin:@localhost:1521:ORCL";  // type 4
			username="System";
			password="admin";
			
			con= DriverManager.getConnection(url,username,password);  // Step 3
			
			stmt=con.prepareCall("{? = call fun1(?) }");
			stmt.setString(2, "Pavni!");
			stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
		
			boolean f=stmt.execute();
			System.out.println(f);
		
			String res= stmt.getString(1);
			System.out.println(res);
			
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
