package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.Entities.BodyMeasurements;

class BodyMeasurementsTest {
	
	private BodyMeasurements body = new BodyMeasurements();;

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
	

}
