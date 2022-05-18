package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddingDataWithPreapredStmt {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/ck";
		String un = "root";
		String pwd = "root";
		
		Connection con = null ;
		try {
			
			 con = DriverManager.getConnection(url, un, pwd);
			
			String str = "INSERT INTO emp VALUES(?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(str);
			
			ps.setInt(1, 5);
			ps.setString(2, "Sheela");
			ps.setDouble(3, 5000);
			
			ps.execute();
			
			System.out.println("Data is inserted");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
