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
    void userFirstName() {
	 //fail("Not yet implemented");
	  String expectedFirstName="harpreet";
	  u.setUserFirstName("harpreet");
	assertEquals(expectedFirstName,u.getUserFirstName() );
	}
	
	@Test
    void userLastName() {
	 //fail("Not yet implemented");
	  String expectedFirstName="kaur";
	  u.setUserLastName("kaur");
	assertEquals(expectedFirstName,u.getUserLastName());
	}
	
	@Test
    void userEmail() {
		
	 //fail("Not yet implemented");
	  String expectedEmail="harpreetkaurh8@gmail.com";
	  u.setUserEmail("harpreetkaurh8@gmail.com");
	assertEquals(expectedEmail,u.getUserEmail());
	}
	
	@Test
    void userAge() {
	 //fail("Not yet implemented");
	  int expectedAge=25;
	  u.setUserAge(25);
	assertEquals(expectedAge,u.getUserAge());
	}

}
