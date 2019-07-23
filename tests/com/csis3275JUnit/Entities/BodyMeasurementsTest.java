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
	

}
