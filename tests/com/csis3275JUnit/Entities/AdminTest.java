package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.Admin;

/**
 * 
 * @author harpreet Kaur
 * student id:300288768
 *
 *Testing Admin Class
 */
class AdminTest {
     Admin a;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		a=new Admin();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Testing admin_id
	 */
	
	@Test
	void testAdminId() {
		String expectedAdminId="Admin";
		a.setAdminid("Admin");
		assertEquals(expectedAdminId, a.getAdminid());
		
	}
	
	/**
	 * Testing admin_Name
	 */
	
	@Test
	void testAdminName() {
		String expectedAdminName="Admin";
		a.setAdminName("Admin");
		assertEquals(expectedAdminName, a.getAdminName());
	}
	
	/**
	 * Testing admin_Password
	 */
	
	@Test
	void testAdminPassword() {
		String expectedAdminPass="root";
		a.setAdminPassword("root");
		
		assertEquals(expectedAdminPass, a.getAdminPassword());
	}



}
