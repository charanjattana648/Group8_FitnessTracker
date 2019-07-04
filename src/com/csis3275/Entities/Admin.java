package com.csis3275.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author charanpreet Singh
 *
 */
@Entity
@NamedQuery(name="CheckAdmin",query="FROM Admin a where a.adminid=:adminid and a.adminPassword=:adminPassword")
@Table(name="Admin")
public class Admin {
@Id
@Column(name="adminid",nullable=false)
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
