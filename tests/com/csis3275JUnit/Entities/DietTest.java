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
	

//	private String foodType;
//	private String foodCategory;
//	private int readyTime;
//	private double calories;
//	private double protein;
//	private double fat;
//	private double carbohydrates;
//	private double vitaminA;
//	private double vitaminC;
//	private double calcium;
//	private double iron;
//	private String author;

}
