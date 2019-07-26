/**
 * 
 */
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.Meals;

/**
 * @author Charanpreet Singh
 * Testing Meals Object with getters and setters.
 */
class MealsTest {
	Meals m;
	private int id=5;
	private String title="Orange Juice";
	private int readyInMinutes=10;
	private int servings=3;
	private double calories=15.20;
	private double protein=12.02;
	private double fat=10;
	private double carbohydrates=18;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		m=new Meals();
	}

	/**
	 * testing instance
	 */
	@Test
	void test_intance() {
		assertNotNull(m);
	}
	

	/**
	 * testing id
	 */
	@Test
	void test_id() {
		m.setId(id);
		assertEquals(id, m.getId());		
	}

	/**
	 * testing title
	 */
	
	@Test
	void test_title() {
		m.setTitle(title);
		assertTrue(title.equalsIgnoreCase(m.getTitle()));		
	}

	/**
	 * testing readyInMinutes
	 */
	@Test
	void test_readyInMinutes() {
		m.setReadyInMinutes(readyInMinutes);
		assertEquals(readyInMinutes, m.getReadyInMinutes());		
	}

	/**
	 * testing servings
	 */
	@Test
	void test_servings() {
		m.setServings(servings);
		assertEquals(servings, m.getServings());		
	}

	/**
	 * testing calories
	 */
	@Test
	void test_calories() {
		m.setCalories(calories);
		assertEquals(calories, m.getCalories());		
	}

	/**
	 * testing protein
	 */
	@Test
	void test_protein() {
		m.setProtein(protein);
		assertEquals(protein, m.getProtein());		
	}

	/**
	 * testing fat
	 */
	@Test
	void test_fat() {
		m.setFat(fat);
		assertEquals(fat, m.getFat());		
	}

	/**
	 * testing carbohydrates
	 */
	
	@Test
	void test_carbohydrates() {
		m.setCarbohydrates(carbohydrates);
		assertEquals(carbohydrates, m.getCarbohydrates());		
	}
	
	


}
