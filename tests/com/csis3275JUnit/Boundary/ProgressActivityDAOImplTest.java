/**
 * 
 */
package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
 * @author Charanpreet Singh
 *
 */
class ProgressActivityDAOImplTest {

	ProgressActivity pa;
	DietDAOImpl dI;
	UserDiet ud;
	UserDietDAOImpl udI;
	String userEmail="csis@gmail.com";
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
	
	public void progress()
	{

		pa=new ProgressActivity();		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		pa.setDate(sdf.format(d));
		pa.setUserEmail(userEmail);
		pa.setCurrentWeight(60.50);
		pa.setCaloriesBurned(50);
		pa.setCaloriesConsumed(220);
	}

	@Test
	void test_caloriesConsumed() {

		ArrayList<Double> udList=new ArrayList<Double>();
		try {
			sx=factory.openSession();
			tx=sx.beginTransaction();
			udList=(ArrayList<Double>) sx.getNamedQuery("getCaloriesConsumedQuery").setParameter("uEmail", userEmail).setMaxResults(7).list();			
			tx.commit();
			
		}catch(HibernateException he)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(he.getMessage());
		}
		assertNotNull(userEmail);
		assertNotNull(udList);
		assertFalse(udList.isEmpty());
	}

	@Test
	void test_SaveProgress() {
		progress();
		String key="";
		try {
			sx=factory.openSession();
			tx=sx.beginTransaction();
			key=(String) sx.save(pa);		
			tx.commit();
			
		}catch(HibernateException he)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(he.getMessage());
		}
		assertNotNull(pa);
		assertNotNull(key);
		assertFalse(key.isEmpty());
	}

	@Test
	void test_Progress() {
		ArrayList<ProgressActivity> paList=new ArrayList<ProgressActivity>();
		try {
			sx=factory.openSession();
			tx=sx.beginTransaction();
			paList=(ArrayList<ProgressActivity>) sx.getNamedQuery("getProgressQuery").setParameter("uEmail", userEmail).list();			
			tx.commit();
			
		}catch(HibernateException he)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(he.getMessage());
		}
		assertNotNull(userEmail);
		assertNotNull(paList);
		assertFalse(paList.isEmpty());
	}

}
