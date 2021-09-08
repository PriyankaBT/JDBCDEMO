package com.sample;

//step1
import java.sql.*;

public class ConnectionDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement stmt=null;
		Statement stmt1 = null;
		ResultSet rs=null;
		String url="";
		String username="";
		String password="";
		
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  // Step 2 
					
			
			url="jdbc:oracle:thin:@localhost:1521:ORCL";  // type 4
			username="system";
			password="admin";
			
			con= DriverManager.getConnection(url,username,password);  // Step 3
			
			
			
			
			
			
//			stmt= con.createStatement(); // step 4
//			rs=stmt.executeQuery("Select * from product");  // step 5
//			
//			while(rs.next()) {
//				System.out.print(rs.getInt(1)+" ");
//				System.out.print(rs.getString(2)+" ");
//				System.out.print(rs.getInt(3)+" ");
//				System.out.print(rs.getDate(4)+" ");
//			//	System.out.print(rs.getInt(5)+" ");
//				System.out.println();
//			}
// PreparedStatement   precompiled faster dml dynamic select
			stmt = con.prepareStatement ("delete from product where pid= ?"); 
			stmt.setInt(1,122);	
			int count = stmt.executeUpdate ();
			
			
			// Statement   
			stmt1 = con.createStatement(); 
			int count1 = stmt.executeUpdate ("delete from product where pid= 102");	
			
			
			
			System.out.println("No of Records deleted :="+count);
			
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
