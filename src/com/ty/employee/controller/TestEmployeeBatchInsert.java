package com.ty.employee.controller;

import java.util.ArrayList;

import com.ty.employee.dao.EmployeeDao;
import com.ty.employee.property.Employee;

public class TestEmployeeBatchInsert {

	public static void main(String[] args) {

		// Creating the List of Employee Objects
		
		ArrayList<Employee> list = new ArrayList<>();
		Employee e1 = new Employee();
		e1.setEid(1);
		e1.setName("Smith");
		e1.setSal(25000);
		
		Employee e2 = new Employee();
		e2.setEid(2);
		e2.setName("Allen");
		e2.setSal(30000);
		
		Employee e3 = new Employee();
		e3.setEid(3);
		e3.setName("Miller");
		e3.setSal(20000);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		EmployeeDao dao = new EmployeeDao();
		
		int res = dao.saveEmployeeBatch(list);
		
		if( res!=0 ) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("No Data inserted");
		}
			

	}

}
