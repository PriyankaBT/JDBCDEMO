package com.sample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareDemo {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		CallableStatement cst=null;
		PreparedStatement stmt1=null;
		PreparedStatement stmt2=null;
		PreparedStatement stmt3=null;
		Statement st=null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + "orcl", "system", "admin");
			System.out.println("Connection .....");
			// Dynamic select , insert , update DML ....precompiled
			
			
//			stmt1=con.prepareStatement("Select * from product where  price > ?");
//			
//			
//		//	stmt1.setString(1, "14-AUG-21");
//			stmt1.setInt(1, 2000);
//			
//			rs= stmt1.executeQuery();
//			
//			while(rs.next()) {
//				System.out.print(rs.getInt(1)+" ");
//				System.out.print(rs.getString(2)+" ");
//				System.out.print(rs.getInt(3)+" ");
//				System.out.print(rs.getDate(4)+" ");
//			//	System.out.print(rs.getInt(5)+" ");
//				System.out.println();
//			}
//			stmt2=con.prepareStatement("insert into product values(?,?,?,?)");
//			stmt2.setInt(1, 123);
//			stmt2.setString(2, "Frame2");
//			stmt2.setInt(3, 250);
//			stmt2.setString(4,"20-Aug-21");
//			//stmt2.setInt(5,500);
//			int r=stmt2.executeUpdate();
//			System.out.println("Status for insert= "+r);
			
			stmt3=con.prepareStatement("update product set price= ? where purchasedate = ?");
			stmt3.setInt(1,15000);
			stmt3.setString(2,"20-Aug-21");
			int r1=stmt3.executeUpdate();
			System.out.println("Status for update"+r1);
			
			
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			if(rs!=null) {
			rs.close();
			}
			con.close();
		}

	}
}
