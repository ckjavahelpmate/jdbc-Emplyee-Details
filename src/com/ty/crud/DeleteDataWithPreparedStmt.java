package com.ty.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteDataWithPreparedStmt {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/ck";
		String un = "root";
		String pwd = "root";
		
		Connection con = null ;
		try {
			
			 con = DriverManager.getConnection(url, un, pwd);
			
			String str = "Delete from laptop where id in(4)";
			
			PreparedStatement ps = con.prepareStatement(str);
			
			ps.execute();
			
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
