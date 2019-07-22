package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.User;

/**
 * 
 * @author harpreet Kaur
 *
 */
class userTest {
	
	User u;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		u=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    void userName() {
	 fail("Not yet implemented");
	//	String expectedFirstName="harpreet";
		
	//	assertEquals(expectedFirstName,u.getUserFirstName() );
	}

}
