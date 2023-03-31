package com.stl.AdminEmployee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class AdminEmployeemodel {
	
	@Column(name = "employeeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeid;
	
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name = "phonenumber")
	private String phonenumber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="manageremail")
	private String manageremail;
	
	@Column(name="gender")
	private String gender;
	
	
	public AdminEmployeemodel() {
		
	}


	public AdminEmployeemodel(Long employeeid, String firstname, String lastname, String email, String phonenumber,
			String password, String manageremail, String gender) {
		super();
		this.employeeid = employeeid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.manageremail = manageremail;
		this.gender = gender;
	}


	public Long getEmployeeid() {
		return employeeid;
	}


	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getManageremail() {
		return manageremail;
	}


	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "AdminEmployeemodel [employeeid=" + employeeid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", phonenumber=" + phonenumber + ", password=" + password + ", manageremail="
				+ manageremail + ", gender=" + gender + "]";
	}


	

}