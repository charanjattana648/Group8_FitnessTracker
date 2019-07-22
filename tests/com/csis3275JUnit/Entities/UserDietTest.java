/**
 * 
 */
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.UserDiet;

/**
 * @author Charanpreet Singh
 *
 */
class UserDietTest {
	UserDiet ud;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ud=new UserDiet();
	}
	
	@Test
	void test_instance()
	{
		assertNotNull(ud);
		
	}

	@Test
	void test_id() {
		int expected=5;
		ud.setId(expected);
		assertNotNull(ud.getId());
		assertEquals(expected, ud.getId());
	}
	
	@Test	
	void test_userEmail() {
		String expected="csj648@gmail.com";
		ud.setUserEmail(expected);
		assertTrue(expected.equalsIgnoreCase(ud.getUserEmail()));		
	}
	
	@Test
	void test_dietId() {
		int expected=5;
		ud.setDietId(expected);
		assertEquals(expected, ud.getDietId());
	}
	
	@Test
	void test_mealType() {
		String expected="Breakfast";
		ud.setMealType(expected);
		assertEquals(expected, ud.getMealType());
	}

	@Test
	void test_foodName() {
		String expected="Orange Juice";
		ud.setFoodName(expected);
		assertEquals(expected, ud.getFoodName());
	}
	@Test
	void test_readyTime() {
		int expected=15;
		ud.setReadyTime(expected);
		assertEquals(expected, ud.getReadyTime());
	}

	@Test
	void test_calories() {
		double expected=160.20;
		ud.setCalories(expected);
		assertEquals(expected, ud.getCalories());
	}

	
	@Test
	void test_author() {
		String expected="Charan";
		ud.setAuthor(expected);
		assertEquals(expected, ud.getAuthor());
	}

	@Test	
	void test_date() {
		String expectedDate="22/07/2019";
		ud.setDate(expectedDate);
		assertTrue(expectedDate.equalsIgnoreCase(ud.getDate()));		
	}


}
