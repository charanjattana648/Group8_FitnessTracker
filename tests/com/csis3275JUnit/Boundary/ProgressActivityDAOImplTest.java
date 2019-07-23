/**
 * 
 */
package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Boundary.DietDAOImpl;
import com.csis3275.Boundary.UserDietDAOImpl;
import com.csis3275.Entities.ProgressActivity;
import com.csis3275.Entities.UserDiet;

/**
 * @author charan
 *
 */
class ProgressActivityDAOImplTest {
	DietDAOImpl dI;
	UserDiet ud;
	UserDietDAOImpl udI;
	SessionFactory factory = null;
	Session sx = null;
	Transaction tx = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 dI=new DietDAOImpl();
		 factory=dI.getFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	

}
