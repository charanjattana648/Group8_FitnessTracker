package com.csis3275JUnit.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Controller.ValidateUser;
import com.csis3275.Entities.User;

/**
 * 
 * @author harpreet kaur
 *
 */
class ValidateUserTest {
	
	User u=new User();
	ValidateUser v=new ValidateUser();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void validateUserInfoTest() {
		
		String expectedEmail="hk@gmail.com";
		String expectedName="happy";
		String expectedLname="Kaur";
		String expectedPass="csis3275";
		String expectedConfirm="csis3275";
		int expectedage=24;
		
		char[] password=expectedPass.toCharArray();
		char[] confirmPass=expectedConfirm.toCharArray();
		User u=v.validate("hk@gmail.com", "happy", "Kaur", password, confirmPass, "24");
		
		assertAll("Validating User failed ",()->assertEquals(expectedEmail,u.getUserEmail()),
				()->assertEquals(expectedName,u.getUserFirstName()),
				()->assertEquals(expectedLname,u.getUserLastName()),
				()->assertEquals(expectedPass,u.getUserPassword()),
				()->assertEquals(expectedage, u.getUserAge())
				);
		
	}
	
	@Test
	void UserInfoEmptyTest() {
		
		String expectedEmail="hk@gmail.com";
		String expectedName="";
		String expectedLname="Kaur";
		String expectedPass="csis3275";
		String expectedConfirm="csis3275";
		int expectedage=24;
		
		char[] password=expectedPass.toCharArray();
		char[] confirmPass=expectedConfirm.toCharArray();
		User u=v.validate("hk@gmail.com", "", "Kaur", password, confirmPass, "24");
		
		assertAll("Validating User failed ",()->assertEquals(expectedEmail,u.getUserEmail()),
				()->assertEquals(expectedName,u.getUserFirstName()),
				()->assertEquals(expectedLname,u.getUserLastName()),
				()->assertEquals(expectedPass,u.getUserPassword()),
				()->assertEquals(expectedage, u.getUserAge())
				);
		
	}
	

}
