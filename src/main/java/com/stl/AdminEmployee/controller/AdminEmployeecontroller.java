package com.stl.AdminEmployee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.AdminEmployee.model.AdminEmployeemodel;
import com.stl.AdminEmployee.service.AdminEmployeeservice;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("adminemployee")
public class AdminEmployeecontroller {

	@Autowired
	AdminEmployeeservice adminservice;

	//Create Employees
	@PostMapping("/addemployee")
	public ResponseEntity<String> AddEmployee(@RequestBody AdminEmployeemodel adminmodel){
		String pass = adminmodel.getPassword();
		adminmodel.setPassword(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<String>(adminservice.AddEmployee(adminmodel),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public List<AdminEmployeemodel> getAllEmployees(){
		
		return adminservice.getAllemployees();
	}
	
	//Get Employees by Id
	@GetMapping("/get/{email}")
	public Optional<AdminEmployeemodel> getEmployeeById(@PathVariable("email") String email){

		return adminservice.getEmployeebyId(email);
	}
	
	//Delete Employee
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("email") String email){
		adminservice.deleteEmployee(email);
		return new ResponseEntity<String> ("Employee Deleted Successfully!", HttpStatus.OK);

	}

}
