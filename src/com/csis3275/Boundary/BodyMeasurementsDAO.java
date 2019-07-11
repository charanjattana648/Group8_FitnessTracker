package com.csis3275.Boundary;

import java.util.List;

import com.csis3275.Entities.BodyMeasurements;

public interface BodyMeasurementsDAO {
	
	/**
	 * create new body data
	 * @param body
	 * @return int newBodyId
	 */
	public int createBodydata(BodyMeasurements body);
	/**
	 * get all the values from database in a list
	 * @return list of body data
	 */
	public List<BodyMeasurements> getBodyData();

}
