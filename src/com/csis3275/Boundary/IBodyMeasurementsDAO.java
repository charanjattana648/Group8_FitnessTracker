package com.csis3275.Boundary;

import java.util.List;

import com.csis3275.Entities.BodyMeasurements;
import com.csis3275.Entities.Diet;

public interface IBodyMeasurementsDAO {
	
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
	public List<BodyMeasurements> getBodyDataList();
	
	/**
	 * get single body data from the database
	 * @param id integer body id
	 * @return Object of BodyMeasurements
	 */
	public BodyMeasurements getBodyData(int id);

}
