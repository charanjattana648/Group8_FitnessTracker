package com.csis3275JUnit.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Controller.ValidateDailyActivity;
import com.csis3275.Entities.DailyActivity;
import com.csis3275.Entities.User;

/**
 * 
 * @author harpreet kaur
 *
 */
class ValidateDailyActivityTest {

	DailyActivity da;
	ValidateDailyActivity vda;

	@BeforeEach
	void setUp() throws Exception {
		da=new DailyActivity();
		vda=new ValidateDailyActivity();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	

		
		int expectectsleepHour=7;
		int expectedsleepMinute=25;
		int expectedtwaterGlass=6;
		int expectedexerciseHour=3;
		int expectedexerciseMinute=12;
		int expectedmeditationHour=2;
		int expectedmeditationMinute=24;
		int expectedwalkingHour=2;
		int expectedwalkingMinute=34;
		double expectedextraCalories=240;
		double expectedextraProtein=150.0;
		double expectedextraFat=20.0;
		int expectedworkHour=8;
		int expectedtxtworkMinute=30;
		
	

	@Test
	void validateInfotest() {
		
		
		
		DailyActivity da=vda.validate("7", "25", "6", "3", "12", "2", "24", "2","34", "240", "150.0", "20.0", "8", "30");
		
		assertAll("Validating Activities Information failed ",()->assertEquals(expectectsleepHour,da.getSleepHour()),
				()->assertEquals(expectedsleepMinute,da.getSleepMinute()),
				()->assertEquals(expectedtwaterGlass,da.getWaterGlass()),
				()->assertEquals(expectedexerciseHour,da.getExerciseHour()),
				()->assertEquals(expectedexerciseMinute, da.getExerciseMinute()),
				()->assertEquals(expectedmeditationHour, da.getMeditationHour()),
				()->assertEquals(expectedmeditationMinute, da.getMeditationMinute()),
				()->assertEquals(expectedwalkingHour, da.getWalkingHour()),
				()->assertEquals(expectedwalkingMinute, da.getWalkingMinute()),
				()->assertEquals(expectedextraCalories, da.getExtraCalories()),
				()->assertEquals(expectedextraProtein, da.getExtraProtein()),
				()->assertEquals(expectedextraFat, da.getExtraFat()),
				()->assertEquals(expectedworkHour, da.getWorkHour()),
				()->assertEquals(expectedtxtworkMinute, da.getWorkMinute())
				);
		
		
	}
	
	@Test
	void validateEmptyInfotest() {
		
		DailyActivity da=vda.validate("7", "25", "", "3", "12", "2", "24", "2","34", "240", "150.0", "20.0", "8", "30");
		
		assertNull(da);	
		
	}
	
	@Test
	void validateHourandMintFormattest() {
		
		DailyActivity da=vda.validate("7", "67", "6", "3", "12", "2", "24", "2","34", "240", "150.0", "20.0", "8", "30");
		
		assertNull(da);	
		
	}
	
	@Test
	void validateHourandMintFormatNegativetest() {
		
		DailyActivity da=vda.validate("-7", "67", "6", "3", "12", "2", "24", "2","34", "240", "150.0", "20.0", "8", "30");
		
		assertNull(da);	
		
	}

}
