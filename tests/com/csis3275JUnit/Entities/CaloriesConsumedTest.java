/**
 * 
 */
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.CaloriesConsumed;

/**
 * @author Charanpreet Singh
 *
 */
class CaloriesConsumedTest {
	CaloriesConsumed cc;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		cc=new CaloriesConsumed();
	}
	@Test
	void test_instance() {
		assertNotNull(cc);
	}
	
	@Test	
	void test_date() {
		String expectedDate="22/07/2019";
		cc.setDate(expectedDate);
		assertTrue(expectedDate.equalsIgnoreCase(cc.getDate()));		
	}
	
	@Test
	void test_consumedCalories() {
		double expected=1440.60;
		cc.setConsumedCalories(expected);
		assertEquals(expected, cc.getConsumedCalories());
	}
	

}
