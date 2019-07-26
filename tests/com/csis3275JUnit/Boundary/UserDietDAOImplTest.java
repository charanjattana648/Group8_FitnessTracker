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
import com.csis3275.Entities.UserDiet;

/**
 * @author Charanpreet Singh
 * UserDietDAOImplTest Test
 *  Testing UserDietDAOImpl which is interacting with FitnessTrackerdb database.
 */
class UserDietDAOImplTest {
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
		 udI=new UserDietDAOImpl();
		 factory=dI.getFactory();
	}
	/**
	 * testing Session factory.
	 */

	@Test
	void test_Session_factory() {			
		assertNotNull(dI);
		assertNotNull(factory, "factory should be null");
	}
	
	/**
	 * testing userDietList method.
	 */
	@Test
	void test_userDietList()
	{
		String email="csis@gmail.com";
		String date="06/29/2019";
		ArrayList<UserDiet> userDietList=new ArrayList<UserDiet>();
		userDietList=udI.getUserDietList(email, date);
		assertNotNull(dI);
		assertFalse(userDietList.isEmpty());
	}
	/**
	 * testing UserDietdate method.
	 */
	@Test
	void test_UserDietdate()
	{		
		String email="csis@gmail.com";
		ArrayList<String>  dateList=new ArrayList<String>();
		dateList=udI.getLastDPDates(email);
		assertNotNull(dI);
		assertFalse(dateList.isEmpty());
	}
	/**
	 * testing addUserDiet method.
	 */	
	@Test
	void test_addUserDiet()
	{
		udI=new UserDietDAOImpl();
		ud=udI.getUserDiet(2);
		int newuD=0;
		newuD=udI.addUserDiet(ud);		
		assertNotNull(dI);
		assertNotNull(ud);
		assertNotEquals(0, newuD);
	}
	
	/**
	 * testing getUserDiet method.
	 */	
	@Test
	void test_getUserDiet()
	{ 
		int id=2;
		ud=new UserDiet();
		ud=udI.getUserDiet(2);
		assertNotNull(dI);
		assertNotNull(ud);
		assertEquals(id, ud.getId());
	}
	/**
	 * testing deleteUserDiet method.
	 */	
	@Test
	void test_deleteUserDiet()
	{ 	
		ud=udI.getUserDiet(130);
		udI.deleteUserDiet(ud);
		assertNotNull(udI);
		assertNotNull(dI);
		assertNull(udI.getUserDiet(14));
	}	
}
