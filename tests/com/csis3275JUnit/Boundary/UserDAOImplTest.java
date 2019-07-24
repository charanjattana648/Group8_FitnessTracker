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
import com.csis3275.Entities.User;

/**
 * 
 * @author harpreet kaur
 *
 */
class UserDAOImplTest {
	DietDAOImpl dI;
	User u ;
	UserDAOImpl ud;
	SessionFactory factory = null;
	Session sx = null;
	Transaction tx = null;

	

	@BeforeEach
	void setUp() throws Exception {
		dI=new DietDAOImpl();
		u=new User();
		ud=new UserDAOImpl();
		factory=dI.getFactory();
	}

	

	@Test
	void test_Session_factory() {			
		assertNotNull(dI);
		assertNotNull(factory, "factory should be null");
	}

}
