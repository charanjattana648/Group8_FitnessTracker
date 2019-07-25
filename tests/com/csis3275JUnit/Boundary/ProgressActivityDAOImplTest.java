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
import com.csis3275.Boundary.ProgressActivityDAOImpl;
import com.csis3275.Boundary.UserDietDAOImpl;
import com.csis3275.Entities.ProgressActivity;
import com.csis3275.Entities.UserDiet;

/**
 * @author Charanpreet Singh
 * ProgressActivityDAOImplTest Test
 * Testing ProgressActivityDAOImpl which interacts with FitnessTrackerdb Database.
 */
class ProgressActivityDAOImplTest {

	ProgressActivity pa;
	ProgressActivityDAOImpl paI;
	DietDAOImpl dI;
	UserDiet ud;
	UserDietDAOImpl udI;
	String userEmail="csis@gmail.com";
	SessionFactory factory = null;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		 dI=new DietDAOImpl();
		 paI=new ProgressActivityDAOImpl();
		 factory=dI.getFactory();
	}
	
	/**
	 * testing progress method.
	 */	
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
	/**
	 * testing caloriesConsumed method.
	 */	
	@Test
	void test_caloriesConsumed() {

		ArrayList<Double> udList=new ArrayList<Double>();
		udList=paI.getCaloriesConsumed(userEmail);
		assertNotNull(userEmail);
		assertNotNull(udList);
		assertFalse(udList.isEmpty());
	}
	/**
	 * testing Save progress method.
	 */	
	@Test
	void test_SaveProgress() {
		progress();
		String key="";
		key=paI.saveProgress(pa);
		assertNotNull(pa);
		assertNotNull(key);
		assertFalse(key.isEmpty());
	}
	/**
	 * testing progress method.
	 */	
	@Test
	void test_Progress() {
		ArrayList<ProgressActivity> paList=new ArrayList<ProgressActivity>();
		paList=paI.getProgress(userEmail);
		assertNotNull(userEmail);
		assertNotNull(paList);
		assertFalse(paList.isEmpty());
	}

}
