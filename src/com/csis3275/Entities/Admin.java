package com.csis3275.Entities;
/**
 * 
 * @author charanpreet Singh
 *
 */
public class Admin {

	private String adminid;
	private String adminName;
	private String adminPassword;
	
	public Admin() {
	}
	
	/**
	 * Constructor of Admin Class.
	 * @param adminName String value.
	 * @param adminPassword String passWord
	 */
	public Admin(String adminName, String adminPassword) {
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	

}
