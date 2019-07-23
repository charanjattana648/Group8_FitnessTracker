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
 *
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
		 factory=dI.getFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		if(sx!=null)
		sx.close();
		factory.close();
	}

	@Test
	void test_Session_factory() {	
		
		assertNotNull(dI);
		assertNotNull(factory, "factory is null");
	}
	
	@Test
	void test_userDietList()
	{
		String email="csis@gmail.com";
		String date="06/29/2019";
		ArrayList<UserDiet> userDietList=new ArrayList<UserDiet>();
		try {
			factory=dI.getFactory();
			sx=factory.openSession();
			tx=sx.beginTransaction();
			userDietList=(ArrayList<UserDiet>) sx.getNamedQuery("userDietListQuery").setParameter("uEmail", email).setParameter("date", date).list();
			
			tx.commit();
		}catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}
		assertNotNull(dI);
		assertFalse(userDietList.isEmpty());
	}
	@Test
	void test_UserDietdate()
	{		
		String email="csis@gmail.com";
		ArrayList<String>  dateList=new ArrayList<String>();
		try {
			factory=dI.getFactory();
			sx=factory.openSession();
			tx=sx.beginTransaction();
			dateList=(ArrayList<String>) sx.getNamedQuery("UserDietdateQuery").setParameter("uEmail", email).list();
			tx.commit();
		}catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}
		assertNotNull(dI);
		assertFalse(dateList.isEmpty());
	}
	
	
	@Test
	void test_addUserDiet()
	{
		udI=new UserDietDAOImpl();
		ud=udI.getUserDiet(2);
		int newuD=0;
		try {
			factory=dI.getFactory();
			sx=factory.openSession();
			tx=sx.beginTransaction();
			newuD=(int) sx.save(ud);
			tx.commit();
		}catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}
		assertNotNull(dI);
		assertNotNull(ud);
		assertNotEquals(0, newuD);
	}
	
	
	@Test
	void test_getUserDiet()
	{ 
		int id=2;
		ud=new UserDiet();
		try {
			factory=dI.getFactory();
			sx=factory.openSession();
			tx=sx.beginTransaction();
			ud=sx.get(UserDiet.class, id);
			tx.commit();
		}
		catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}	
		assertNotNull(dI);
		assertNotNull(ud);
	}
	
	@Test
	void test_deleteUserDiet()
	{ 
		udI=new UserDietDAOImpl();
		ud=udI.getUserDiet(98);
		try {
			factory=dI.getFactory();
			sx=factory.openSession();
			tx=sx.beginTransaction();
			sx.delete(ud);
			tx.commit();
		}
		catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}
		assertNotNull(udI);
		assertNotNull(dI);
		assertNull(udI.getUserDiet(14));
	}

	
	
	
}
