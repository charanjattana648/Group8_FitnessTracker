/**
 * 
 */
package com.csis3275JUnit.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Controller.CalculateCaloriesNeeded;

/**
 * @author charanpreet Singh
 *
 */
class CalculateCaloriesNeededTest {
CalculateCaloriesNeeded ccn=new CalculateCaloriesNeeded();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ccn=new CalculateCaloriesNeeded();
	}

	@Test
	void test_CalculateCaloriesNeeded() {
		String txtCaldiffTxt="42";
		String txtCalconsumedTxt="300";
		String txtCalBurned="200";
		String userEmail="user@gmail.com";
		double res=ccn.calNeeded(txtCaldiffTxt, txtCalconsumedTxt, txtCalBurned, userEmail);
		assertNotNull(ccn);
		assertEquals(142.0, res);
	}

}
