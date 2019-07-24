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
 *
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
	
	@Test
	void testAdminId() {
		String expectedAdminId="Admin";
		a.setAdminid("Admin");
		assertEquals(expectedAdminId, a.getAdminid());
		
	}
	
	@Test
	void testAdminName() {
		String expectedAdminName="Admin";
		a.setAdminName("Admin");
		assertEquals(expectedAdminName, a.getAdminName());
	}
	
	@Test
	void testAdminPassword() {
		String expectedAdminPass="root";
		a.setAdminPassword("root");
		
		assertEquals(expectedAdminPass, a.getAdminPassword());
	}



}
