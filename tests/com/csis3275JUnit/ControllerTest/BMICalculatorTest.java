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
		
		body.setHeightCm(heightInCm);
		body.setUnit(unit);
		body.setHeightType(heightType);
		body.setWeightType(weightType);
		body.setWeight(weight);
		
		double heightInMeters = heightInCm / (double) 100;
		
		double bmi = weight / Math.pow(heightInMeters, 2);
		
		body.setBmiValues(bmi);
		
		assertEquals(bmi, body.getBmiValues());
		
		
	}

}
