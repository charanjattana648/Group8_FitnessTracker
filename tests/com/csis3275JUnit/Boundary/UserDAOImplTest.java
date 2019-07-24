package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Boundary.DietDAOImpl;
import com.csis3275.Boundary.UserDAOImpl;
import com.csis3275.Entities.Admin;
import com.csis3275.Entities.User;

/**
 * 
 * @author harpreet kaur
 *
 */
class UserDAOImplTest {
	DietDAOImpl dI;
	User u ;
	Admin a;
	UserDAOImpl ud;
	SessionFactory factory = null;

	

	@BeforeEach
	void setUp() throws Exception {
		dI=new DietDAOImpl();
		u=new User();
		a=new Admin();
		ud=new UserDAOImpl();
		factory=dI.getFactory();
	}

	

	@Test
	void test_Session_factory() {			
		assertNotNull(dI);
		assertNotNull(factory, "factory should be null");
	}
	
	public void userInfo() {
		u.setUserFirstName("harprit");
		u.setUserLastName("Kaur");
		u.setUserEmail("hkkkk@gmail.com");
		u.setUserGender("Female");
		u.setUserPassword("happy");
		u.setInstructor("User");
		u.setUserAge(25);
	}
	
	@Test
/*	void testcreateUser() {
		userInfo();
		String createuser=ud.createUserAccount(u);
		assertNotNull(ud);
		assertNotNull(u);
		assertNotNull(createuser);
		assertNotEquals("", createuser);
	}*/
	
	public void InstructorInfo() {
		u.setUserFirstName("happyInstruct");
		u.setUserLastName("Kharoud");
		u.setUserEmail("Kaur@gmail.com");
		u.setUserGender("Female");
		u.setUserPassword("instructor");
		u.setInstructor("Instructor");
		u.setUserAge(28);
	}
	
	@Test
/*	void testcreateInstructor() {
		InstructorInfo();
		String createInstructor=ud.createInstructorAccount(u);
		assertNotNull(ud);
		assertNotNull(u);
		assertNotNull(createInstructor);
		assertNotEquals("", createInstructor);
	}*/
	
	public void AdminInfo() {
		
		a.setAdminid("admin");
		a.setAdminName("admin");
		a.setAdminPassword("root");
		
	}
	
	@Test
	void testAdmin() {
		AdminInfo();
		
		String expectedid="admin";
		String expecetedAdminName="admin";
		String  expectedAdminPass="root";
		
	
		assertAll("Validating Admin failed ",()->assertEquals(expectedid,a.getAdminid()),
				()->assertEquals(expecetedAdminName,a.getAdminName()),
				()->assertEquals(expectedAdminPass,a.getAdminPassword())
				);
	}

}
