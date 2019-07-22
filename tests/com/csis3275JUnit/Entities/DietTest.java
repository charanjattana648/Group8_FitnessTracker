/**
 * 
 */
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.Diet;

/**
 * @author charan
 *
 */
class DietTest {
Diet d;

@BeforeEach
void setUp() throws Exception {
	d=new Diet();
}
	
	@Test
	void test_id() {
		int expected=5;
		d.setId(expected);
		assertNotNull(d.getId());
		assertEquals(expected, d.getId());
	}
	@Test
	void test_mealId() {
		int expected=5;
		d.setMealId(expected);
		assertEquals(expected, d.getMealId());
	}
	@Test
	void test_mealType() {
		String expected="Breakfast";
		d.setMealType(expected);
		assertEquals(expected, d.getMealType());
	}
	@Test
	void test_foodName() {
		String expected="Orange Juice";
		d.setFoodName(expected);
		assertEquals(expected, d.getFoodName());
	}
	@Test
	void test_readyTime() {
		int expected=15;
		d.setReadyTime(expected);
		assertEquals(expected, d.getReadyTime());
	}
	@Test
	void test_foodCategory() {
		String expected="Vegetarian";
		d.setFoodCategory(expected);
		assertEquals(expected, d.getFoodCategory());
	}
	@Test
	void test_foodType() {
		String expected="Fruit";
		d.setFoodType(expected);
		assertTrue(expected.equalsIgnoreCase(d.getFoodType()));
	}
	
	@Test
	void test_calories() {
		double expected=160.20;
		d.setCalories(expected);
		assertEquals(expected, d.getCalories());
	}
	@Test
	void test_protein() {
		double expected=19.29;
		d.setProtein(expected);
		assertEquals(expected, d.getProtein());
	}
	
	@Test
	void test_fat() {
		double expected=10.33;
		d.setFat(expected);
		assertEquals(expected, d.getFat());
	}
	
	@Test
	void test_carbohydrates() {
		double expected=12.67;
		d.setCarbohydrates(expected);
		assertEquals(expected, d.getCarbohydrates());
	}
	
	@Test
	void test_vitaminA() {
		double expected=4.62;
		d.setVitaminA(expected);
		assertEquals(expected, d.getVitaminA());
	}
	
	@Test
	void test_vitaminC() {
		double expected=4.62;
		d.setVitaminC(expected);
		assertEquals(expected, d.getVitaminC());
	}
	
	@Test
	void test_calcium() {
		double expected=4.62;
		d.setCalcium(expected);
		assertEquals(expected, d.getCalcium());
	}
	
	@Test
	void test_iron() {
		double expected=4.62;
		d.setIron(expected);
		assertEquals(expected, d.getIron());
	}
	
	@Test
	void test_author() {
		String expected="Charan";
		d.setAuthor(expected);
		assertEquals(expected, d.getAuthor());
	}

}
