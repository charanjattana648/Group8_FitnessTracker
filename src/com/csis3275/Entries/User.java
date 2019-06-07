package com.csis3275.Entries;


public class User {
	
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private String userGender;
	private String userEmail;
	private String userPassword;
	
	
	
	public User(String userFirstName, String userLastName, int userAge, String userGender, String userEmail,
			String userPassword) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	public User() {
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

