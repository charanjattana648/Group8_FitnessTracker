package com.csis3275JUnit.ControllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.Controller.CalculateBMI;
import com.csis3275.Entities.BodyMeasurements;

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
		
		body.setHeightCm(heightInCm);
		body.setUnit(unit);
		body.setHeightType(heightType);
		body.setWeightType(weightType);
		body.setWeight(weight);
		
		double heightInMeters = heightInCm / (double) 100;
		
		double bmi = weight / Math.pow(heightInMeters, 2);
		
		body.setBmiValues(bmi);
		
		assertEquals(bmi, body.getBmiValues());
		System.out.println("" + body.getBmiValues());
		
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
		System.out.println("" + body.getBmiValues());
		System.out.println(cBMI.bmiResult());
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
		System.out.println("" + body.getBmiValues());
		System.out.println(cBMI.bmiResult());
	}

}
