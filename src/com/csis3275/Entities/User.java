package com.csis3275.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.inject.internal.Nullable;

@Entity
@NamedQuery(name="CheckUser",query="FROM User u where u.userEmail=:uEmail and u.userPassword=:UPass and u.isInstructor='User'")
@NamedQuery(name="CheckInstructor",query="FROM User u where u.userEmail=:uEmail and u.userPassword=:UPass and u.isInstructor='Instructor'")
@Table(name="User")
public class User {
	@Id
	@Column(name="USER_EMAIL",nullable=false)	
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private String userGender;	
	@Column(name="userPassword",nullable=false)	
	private String userPassword;
	@Column(name="isInstructor",nullable=false)	
	private String isInstructor;
	
	
	
	public User(String userFirstName, String userLastName, int userAge, String userGender, String userEmail,
			String userPassword,String isInstructor) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.isInstructor= isInstructor;
	}
	public User() {
	}
	
	
	public String isInstructor() {
		return isInstructor;
	}
	public void setInstructor(String isInstructor) {
		this.isInstructor = isInstructor;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}	

}

