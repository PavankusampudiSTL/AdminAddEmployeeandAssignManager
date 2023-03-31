package com.stl.AdminEmployee.service;

import java.util.List;
import java.util.Optional;

import com.stl.AdminEmployee.model.AdminEmployeemodel;

public interface AdminEmployeeservice {

	String AddEmployee(AdminEmployeemodel admin);
	List<AdminEmployeemodel> getAllemployees();
	Optional<AdminEmployeemodel> getEmployeebyId(String email);
	void deleteEmployee(String email);
	
}
