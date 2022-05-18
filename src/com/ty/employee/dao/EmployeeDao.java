package com.ty.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ty.employee.property.Employee;
import com.ty.employee.util.HelperClass;

public class EmployeeDao {

	public int saveEmployeeBatch(List<Employee> emp) {

		// SQL Query to be executed
		String sql = "INSERT INTO emp VALUES(?,?,?)";

		// getting the Connection Object from Helper class.
		Connection connection =  HelperClass.getConnection();


		// Establishing the statement

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// to insert data into database

			for(Employee e : emp ) {
				// assigning the values
				preparedStatement.setInt(1, e.getEid());
				preparedStatement.setString(2, e.getName());
				preparedStatement.setDouble(3, e.getSal());
				// adding it to batch so we can send to database all at a time.
				preparedStatement.addBatch();
			}
			
			int[] a = preparedStatement.executeBatch();
			
			return a[0];
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0 ;

	}

}
