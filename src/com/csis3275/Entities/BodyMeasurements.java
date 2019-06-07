package com.csis3275.Entities;

/**
 * BodyMeasurements Class
 * @author Gurinder Singh 300289450
 *
 */

public class BodyMeasurements {
	
	private double heightFeets; //user height in feet
	private double heightInches; // user height in inches
	private double heightCm; // user height in centimeters
	private String heightType; // user height type inches or CM
	private double weight; // user weight
	private String weightType; //user weight type LB or KG
	
	public String getHeightType() {
		return heightType;
	}

	public void setHeightType(String heightType) {
		try {
			if(heightType.equals("inches") || heightType.equals("cm")) {
				this.heightType = heightType;
			}
			else {
				throw new Exception("Invalid height type");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public double getHeightFeets() {
		return heightFeets;
	}

	public void setHeightFeets(double heightFeets) {
		this.heightFeets = heightFeets;
	}

	public double getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(double heightInches) {
		this.heightInches = heightInches;
	}

	public double getHeightCm() {
		return heightCm;
	}

	public void setHeightCm(double heightCm) {
		this.heightCm = heightCm;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWeightType() {
		return weightType;
	}

	public void setWeightType(String weightType) {
		try {
			if(weightType.equals("lb") || weightType.equals("kg")) {
				this.weightType = weightType;
			}
			else {
				throw new Exception("Invalid weight type");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
