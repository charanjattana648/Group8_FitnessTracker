
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.DailyActivity;

/**
 * 
 * @author harpreet kaur
 * student id:300288768
 * 
 * Testing all getter setter of DailyActivity class
 */


class DailyActivityTest {
	
	DailyActivity da;


	@BeforeEach
	void setUp() throws Exception {
		da=new DailyActivity();
	}
   
	/**
	 * testing id
	 */
	

	@Test
	void testid() {
		
		int expectedid=1;
		
		da.setId(1);
		assertEquals(expectedid, da.getId());
		
	}
	
	/**
	 * testing date
	 */
	
	@Test
	void testdate() {
		
		String expecteddate="06/27/2019";
		
		da.setDate("06/27/2019");
		assertEquals(expecteddate, da.getDate());
		
	}
	
	/**
	 * testing userEmail
	 */
	
	@Test
	void testuserEmail() {
		String expectedEmail="hk@gmail.com";
		
		da.setUserEmail("hk@gmail.com");
		assertEquals(expectedEmail, da.getUserEmail());
		
	}
	
	/**
	 * testing sleepHours
	 */
	
	@Test
	void testsleepHours() {
		int expectedSleepHours=7;
		
		da.setSleepHour(7);
		assertEquals(expectedSleepHours, da.getSleepHour());
		
	}
	
	/**
	 * testing sleepMinutes
	 */
	
	@Test
	void testsleepMinute() {
		int expectedSleepMinutes=7;
		
		da.setSleepMinute(7);
		assertEquals(expectedSleepMinutes, da.getSleepMinute());
		
	}
	
	/**
	 * testing glassWater
	 */
	
	@Test
	void testWaterGlass() {
		int expectedWaterGlass=4;
		
		da.setWaterGlass(4);
		assertEquals(expectedWaterGlass, da.getWaterGlass());
		
	}
	
	/**
	 * testing ExerciseHours
	 */
	
	@Test
	void testExerciseHour() {
		int expectedExcerciseHours=7;
		
		da.setExerciseHour(7);
		assertEquals(expectedExcerciseHours, da.getExerciseHour());
		
	}
	/**
	 * testing ExerciseMinute
	 */
	
	@Test
	void testExerciseMinute() {
		int expectedExerciseMinute=30;
		
		da.setExerciseMinute(30);
		assertEquals(expectedExerciseMinute, da.getExerciseMinute());
		
	}
	
	/**
	 * testing Meditation Hours
	 */
	
	
	@Test
	void testMeditationHour() {
		int expectedMeditationHour=3;
		
		da.setMeditationHour(3);
		assertEquals(expectedMeditationHour, da.getMeditationHour());
		
	}
	
	/**
	 * testing MeditationMinute
	 */
	
	@Test
	void testMeditationMinute() {
		int expectedMeditationMinute=45;
		
		da.setMeditationMinute(45);
		assertEquals(expectedMeditationMinute, da.getMeditationMinute());
		
	}
	
	/**
	 * testing Walking Hours
	 */
	
	@Test
	void testWalkingHour() {
		int expectedWalkingHour=2;
		
		da.setWalkingHour(2);
		assertEquals(expectedWalkingHour, da.getWalkingHour());
		
	}
	
	/**
	 * testing Walking Minute
	 */
	
	@Test
	void testWalkingMinute() {
		int expectedWalkingMinute=33;
		
		da.setWalkingMinute(33);
		assertEquals(expectedWalkingMinute, da.getWalkingMinute());
		
	}
	
	/**
	 * testing Extra Calories
	 */
	
	@Test
	void testExtraCalories() {
		double expectedExtraCalories=120;
		
		da.setExtraCalories(120);
		assertEquals(expectedExtraCalories, da.getExtraCalories());
		
	}
	
	/**
	 * testing Extra Protein
	 */
	
	@Test
	void testExtraProtein() {
		double expectedExtraProtein=60;
		
		da.setExtraProtein(60);
		assertEquals(expectedExtraProtein, da.getExtraProtein());
		
	}
	
	/**
	 * testing Extra Fats
	 */
	
	@Test
	void testExtraFat() {
		double expectedExtraProtein=60;
		
		da.setExtraProtein(60);
		assertEquals(expectedExtraProtein, da.getExtraProtein());
		
	}
	
	/**
	 * testing Work Type
	 */
	
	@Test
	void testWorkType() {
		String expectedWorkType="Active";
		
		da.setWorkType("Active");
		assertEquals(expectedWorkType, da.getWorkType());
		
	}
	
	/**
	 * testing Work Hours
	 */
	
	@Test
	void testWorkHour() {
		int expectedWorkHour=8;
		
		da.setWorkHour(8);
		assertEquals(expectedWorkHour, da.getWorkHour());
		
	}
	
	/**
	 * testing Work Minutes
	 */
	
	@Test
	void testWorkMinute() {
		int expectedWorkMinute=58;
		
		da.setWorkMinute(58);
		assertEquals(expectedWorkMinute, da.getWorkMinute());
		
	}
	

}
