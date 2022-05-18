package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DeletingDataWithStmt {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/ck";
		String un = "root";
		String pwd = "root";
		
		Connection con = null ;
		try {
			
			 con = DriverManager.getConnection(url, un, pwd);
			
			String str = "Delete from emp where id=5";
			
			Statement stmt = con.createStatement();
			
			stmt.execute(str);
			
			System.out.println("Data is deleted");
			
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
