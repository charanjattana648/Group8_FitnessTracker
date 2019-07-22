/**
 * 
 */
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.ProgressActivity;

/**
 * @author charanpreet Singh
 *
 */
class ProgressActivityTest {
	ProgressActivity pa;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		pa=new ProgressActivity();
	}
	
	@Test
	void test_instance() {
		assertNotNull(pa);
	}

	@Test	
	void test_date() {
		String expectedDate="22/07/2019";
		pa.setDate(expectedDate);
		assertTrue(expectedDate.equalsIgnoreCase(pa.getDate()));		
	}
	@Test	
	void test_userEmail() {
		String expected="csj648@gmail.com";
		pa.setUserEmail(expected);
		assertTrue(expected.equalsIgnoreCase(pa.getUserEmail()));		
	}
	@Test
	void test_currentWeight() {
		double expected=65;
		pa.setCurrentWeight(expected);
		assertEquals(expected, pa.getCurrentWeight());
	}
	@Test
	void test_consumedCalories() {
		double expected=1440.60;
		pa.setCaloriesConsumed(expected);
		assertEquals(expected, pa.getCaloriesConsumed());
	}
	@Test
	void test_consumedBurned() {
		double expected=1540.90;
		pa.setCaloriesBurned(expected);
		assertEquals(expected, pa.getCaloriesBurned());
	}

}
