/**
 * 
 */
package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Boundary.UserMealWebImpl;
import com.csis3275.Entities.Meals;

/**
 * @author Charanpreet Singh
 *
 */
class UserMealWebImplTest {
	UserMealWebImpl umI;
	double caloriesReq=2000;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		umI=new UserMealWebImpl();
	}

	@Test
	void test_instance() {
		assertNotNull(umI);
	}
	
	@Test
	void test_JsonMealResult() {
		String res=umI.getJsonMealResult(caloriesReq);		
		assertNotNull(umI);
		assertNotNull(res);
	}
	
	@Test
	void test_getmeals() {
		ArrayList<Meals> mealsList=umI.getmeals(caloriesReq);
		assertNotNull(umI);
		assertNotNull(mealsList);
	}
	
	@Test
	void test_getNutrients() {
		Meals mealNutrients=umI.getNutrients(caloriesReq);
		assertNotNull(umI);
		assertNotNull(mealNutrients);
	}
	
	
	

}
