package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.Entities.BodyMeasurements;

/**
 * Testing Entity Body Measurements
 * @author Gurinder Singh 300289450
 *
 */
class BodyMeasurementsTest {
	
	private BodyMeasurements body = new BodyMeasurements();
	
	@Test
	void testEmail() {
		String email = "guri@gmail.com";
		body.setUserEmail(email);
		assertEquals(email, body.getUserEmail());
	}

	@Test
	void testUnit() {
		String unit = "Imperial";
		body.setUnit(unit);
		assertEquals(unit, body.getUnit());
	}
	
	@Test
	void testHeightInFeets() {
		double feets = 5;
		body.setHeightFeets(feets);
		assertEquals(feets, body.getHeightFeets());
	}
	
	@Test
	void testHeightInInches() {
		double inches = 4;
		body.setHeightInches(inches);
		assertEquals(inches, body.getHeightInches());
	}
	
	@Test
	void testHeightInCM() {
		double cm = 168;
		body.setHeightCm(cm);
		assertEquals(cm, body.getHeightCm());
	}
	
	@Test
	void testHeightType() {
		String heightType = "cm";
		body.setHeightType(heightType);
		assertEquals(heightType, body.getHeightType());
	}
	
	@Test
	void testWeight() {
		double weight = 155;
		double weightKG = 78;
		body.setWeight(weight);
		assertEquals(weight, body.getWeight());
		if(body.getWeight() == weight) {
			body.setWeightType("lb");
			assertEquals("lb", body.getWeightType());
		}
		else if(body.getWeight() == weightKG) {
			body.setWeightType("kg");
			assertEquals("kg", body.getWeightType());
		}
	}
	
	@Test
	void testBmiValues() {
		double bmi = 24.9;
		body.setBmiValues(bmi);
		assertEquals(bmi, body.getBmiValues());
	}
	
	@Test
	void testHealthProblems() {
		String healthProblems = "Hypertension,Diabetes,Heart";
		body.setHealthProblem(healthProblems);
		assertEquals(healthProblems, body.getHealthProblem());
	}
	
	@Test
	void testfitnessPlanType() {
		String testFitnessPlan = "Weight Loss Plan";
		body.setFitnessPlanType(testFitnessPlan);
		assertEquals(testFitnessPlan, body.getFitnessPlanType());
	}
	
	@Test
	void testUserGoal() {
		String uGoal = "Loose 3 LB";
		body.setUserGoalType(uGoal);
		assertEquals(uGoal, body.getUserGoalType());
	}

}
