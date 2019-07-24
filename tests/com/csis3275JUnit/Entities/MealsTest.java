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
 *
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


	
	


}
