package com.stl.AdminEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stl.AdminEmployee.model.AdminEmployeemodel;

public interface AdminEmployeerepository extends JpaRepository<AdminEmployeemodel, String>{

}
