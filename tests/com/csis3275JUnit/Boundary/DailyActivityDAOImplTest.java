package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author harpreet kaur
 *
 */

import com.csis3275.Boundary.DailyActivityDAOImpl;
import com.csis3275.Boundary.DietDAOImpl;
import com.csis3275.Entities.DailyActivity;
class DailyActivityDAOImplTest {
    
	DietDAOImpl dI;
	DailyActivity d;
	DailyActivityDAOImpl dImp;
	SessionFactory factory = null;

	@BeforeEach
	void setUp() throws Exception {
		dI=new DietDAOImpl();
		d=new DailyActivity();
		dImp=new DailyActivityDAOImpl();
		factory=dI.getFactory();
	}
	
	@Test
	void test_Session_factory() {			
		assertNotNull(dI);
		assertNotNull(factory, "factory should be null");
	}

	public void addDailyActivity() {
		d.setId(5);
		d.setDate("07/22/2019");
		d.setUserEmail("pk@gmail.com");
		d.setSleepHour(6);
		d.setSleepMinute(30);
		d.setWaterGlass(3);
		d.setExerciseHour(2);
		d.setExerciseMinute(45);
		d.setMeditationHour(2);
		d.setMeditationMinute(23);
		d.setWalkingHour(1);
		d.setWalkingMinute(20);
		d.setExtraCalories(0);
		d.setExtraProtein(0);
		d.setExtraFat(0);
		d.setWorkType("Heavy");
		d.setWorkHour(3);
		d.setWorkMinute(45);
	}

	@Test
	void testDailyActivityAdd() {
		addDailyActivity();
		int record=dImp.addDailyActivities(d);
		assertNotNull(dImp);
		assertNotNull(d);
		assertNotNull(record);
		assertNotEquals(0, record);
	}

}
