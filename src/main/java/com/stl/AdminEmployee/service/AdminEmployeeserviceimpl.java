package com.stl.AdminEmployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.AdminEmployee.model.AdminEmployeemodel;
import com.stl.AdminEmployee.repository.AdminEmployeerepository;

@Service
public class AdminEmployeeserviceimpl implements AdminEmployeeservice{

	@Autowired
	AdminEmployeerepository adminrepo;


	@Override
	public String AddEmployee(AdminEmployeemodel admin) {

		if(!adminrepo.existsById(admin.getEmail())) {
			adminrepo.save(admin);

			return admin.getFirstname() + " Registration is successfull!";
		}
		else {
			System.out.println("Email id already exists!!");
			return "Email id already exists!!";
		}

	}


	@Override
	public List<AdminEmployeemodel> getAllemployees() {
		return adminrepo.findAll();
	}


	@Override
	public Optional<AdminEmployeemodel> getEmployeebyId(String email) {
		return adminrepo.findById(email);
	}


	@Override
	public void deleteEmployee(String email) {
		adminrepo.findById(email);
		adminrepo.deleteById(email);
		
	}

}


