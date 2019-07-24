
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.DailyActivity;

class DailyActivityTest {
	
	DailyActivity da;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		da=new DailyActivity();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testid() {
		
		int expectedid=1;
		
		da.setId(1);
		assertEquals(expectedid, da.getId());
		
	}
	
	@Test
	void testdate() {
		
		String expecteddate="06/27/2019";
		
		da.setDate("06/27/2019");
		assertEquals(expecteddate, da.getDate());
		
	}
	
	@Test
	void testuserEmail() {
		String expectedEmail="hk@gmail.com";
		
		da.setUserEmail("hk@gmail.com");
		assertEquals(expectedEmail, da.getUserEmail());
		
	}
	
	@Test
	void testsleepHours() {
		int expectedSleepHours=7;
		
		da.setSleepHour(7);
		assertEquals(expectedSleepHours, da.getSleepHour());
		
	}
	
	@Test
	void testsleepMinute() {
		int expectedSleepMinutes=7;
		
		da.setSleepMinute(7);
		assertEquals(expectedSleepMinutes, da.getSleepMinute());
		
	}
	
	@Test
	void testWaterGlass() {
		int expectedWaterGlass=4;
		
		da.setWaterGlass(4);
		assertEquals(expectedWaterGlass, da.getWaterGlass());
		
	}
	
	@Test
	void testExerciseHour() {
		int expectedExcerciseHours=7;
		
		da.setExerciseHour(7);
		assertEquals(expectedExcerciseHours, da.getExerciseHour());
		
	}
	
	@Test
	void testExerciseMinute() {
		int expectedExerciseMinute=30;
		
		da.setExerciseMinute(30);
		assertEquals(expectedExerciseMinute, da.getExerciseMinute());
		
	}
	
	@Test
	void testMeditationHour() {
		int expectedMeditationHour=3;
		
		da.setMeditationHour(3);
		assertEquals(expectedMeditationHour, da.getMeditationHour());
		
	}
	
	@Test
	void testMeditationMinute() {
		int expectedMeditationMinute=45;
		
		da.setMeditationMinute(45);
		assertEquals(expectedMeditationMinute, da.getMeditationMinute());
		
	}
	
	@Test
	void testWalkingHour() {
		int expectedWalkingHour=2;
		
		da.setWalkingHour(2);
		assertEquals(expectedWalkingHour, da.getWalkingHour());
		
	}
	
	@Test
	void testWalkingMinute() {
		int expectedWalkingMinute=33;
		
		da.setWalkingMinute(33);
		assertEquals(expectedWalkingMinute, da.getWalkingMinute());
		
	}
	
	@Test
	void testExtraCalories() {
		double expectedExtraCalories=120;
		
		da.setExtraCalories(120);
		assertEquals(expectedExtraCalories, da.getExtraCalories());
		
	}
	
	@Test
	void testExtraProtein() {
		double expectedExtraProtein=60;
		
		da.setExtraProtein(60);
		assertEquals(expectedExtraProtein, da.getExtraProtein());
		
	}
	

}
