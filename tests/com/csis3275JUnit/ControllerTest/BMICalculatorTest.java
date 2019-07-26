package com.csis3275JUnit.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.Controller.CalculateBMI;
import com.csis3275.Entities.BodyMeasurements;

/**
 * Testing Controller BMICalculator
 * @author Gurinder Singh 300289450
 *
 */
class BMICalculatorTest {
	
	BodyMeasurements body = new BodyMeasurements();
	CalculateBMI cBMI = new CalculateBMI();
	

	@Test
	void testCalculateBMIMetric() {
		
		String unit = "Metric";
		String heightType = "cm";
		String weightType = "kg";
		
		double heightInCm = 168;
		double weight = 74;
		
		body = new BodyMeasurements();
		cBMI = new CalculateBMI();
		
		body.setHeightCm(heightInCm);
		body.setUnit(unit);
		body.setHeightType(heightType);
		body.setWeightType(weightType);
		body.setWeight(weight);
		
		double heightInMeters = heightInCm / (double) 100;
		
		double expected = weight / Math.pow(heightInMeters, 2);
		
		double actual = cBMI.calculateBMI(body);
		
		body.setBmiValues(actual);
		
		assertEquals(expected, body.getBmiValues());
		
	}
	
	@Test
	void testBMIResultsOverweight() {
		final double UNDERWEIGHT = 18.5;
		final double NORMAL = 24.9;
		final double OVERWEIGHT = 29.9;
		
		body = new BodyMeasurements();
		
		String result = "";
		
		String unit = "Metric";
		String heightType = "cm";
		String weightType = "kg";
		
		double heightInCm = 168;
		double weight = 74;
		
		
		body.setHeightCm(heightInCm);
		body.setUnit(unit);
		body.setHeightType(heightType);
		body.setWeightType(weightType);
		body.setWeight(weight);
		
		double bmi = cBMI.calculateBMI(body);
		body.setBmiValues(bmi);
		
		if(bmi < UNDERWEIGHT) {
			result = "Based on the bmi results you are Underweight." + "\n" + "You should choose Weight Gain plan";
			assertEquals(result, cBMI.bmiResult());
		}
		else if(bmi >= UNDERWEIGHT && bmi < NORMAL) {
			result = "Based on the bmi results you are under Normal range." + "\n" + "You should choose Stay FIT plan";
			assertEquals(result, cBMI.bmiResult());
		}
		else if(bmi >= NORMAL && bmi < OVERWEIGHT) {
			result = "Based on the bmi results you are Overweight." + "\n" + "You should choose Weight Loss plan";
			assertEquals(result, cBMI.bmiResult());
		}
		else {
			result = "Based on the bmi results you are Obese." + "\n" + "You should choose Extreme Weight Loss plan";
			assertEquals(result, cBMI.bmiResult());
		}
	}
	
	@Test
	void testBMIResultsUnderweight() {
		final double UNDERWEIGHT = 18.5;
		final double NORMAL = 24.9;
		final double OVERWEIGHT = 29.9;
		
		body = new BodyMeasurements();
		
		String result = "";
		
		String unit = "Metric";
		String heightType = "cm";
		String weightType = "kg";
		
		double heightInCm = 155;
		double weight = 40;
		
		
		body.setHeightCm(heightInCm);
		body.setUnit(unit);
		body.setHeightType(heightType);
		body.setWeightType(weightType);
		body.setWeight(weight);
		
		double bmi = cBMI.calculateBMI(body);
		body.setBmiValues(bmi);
		
		if(bmi < UNDERWEIGHT) {
			result = "Based on the bmi results you are Underweight." + "\n" + "You should choose Weight Gain plan";
			assertEquals(result, cBMI.bmiResult());
		}
		else if(bmi >= UNDERWEIGHT && bmi < NORMAL) {
			result = "Based on the bmi results you are under Normal range." + "\n" + "You should choose Stay FIT plan";
			assertEquals(result, cBMI.bmiResult());
		}
		else if(bmi >= NORMAL && bmi < OVERWEIGHT) {
			result = "Based on the bmi results you are Overweight." + "\n" + "You should choose Weight Loss plan";
			assertEquals(result, cBMI.bmiResult());
		}
		else {
			result = "Based on the bmi results you are Obese." + "\n" + "You should choose Extreme Weight Loss plan";
			assertEquals(result, cBMI.bmiResult());
		}
	}
	
	@Test
	void testCalculateBMIImperial() {
		
		String unit = "Imperial";
		String heightType = "inches";
		String weightType = "lb";
		
		double heightInFeets = 6;
		double weight = 150;
		double heightInches = 0;
		
		body = new BodyMeasurements();
		cBMI = new CalculateBMI();
		
		body.setHeightFeets(heightInFeets);
		body.setUnit(unit);
		body.setHeightType(heightType);
		body.setWeightType(weightType);
		body.setWeight(weight);
		
		double convertedFeetsToInches = heightInFeets * (double) 12;
		double totalHeightInInches = convertedFeetsToInches + heightInches;
		
		double expected = (weight / (Math.pow(totalHeightInInches, 2))) * (double) 703;
		
		double actual = cBMI.calculateBMI(body);
		
		body.setHeightInches(heightInches);
			
			body.setBmiValues(actual);
			
			assertEquals(expected, body.getBmiValues());
		
	}

}
