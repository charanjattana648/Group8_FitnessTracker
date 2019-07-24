package com.csis3275.Entities;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BodyMeasurements Class
 * @author Gurinder Singh 300289450
 *
 */

@Entity
@Table(name="userBodyMeasurements")

public class BodyMeasurements {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="userEmail",nullable=false,unique=true)
	private String userEmail;
	private String unit;
	private double heightFeets; //user height in feet
	private double heightInches; // user height in inches
	private double heightCm; // user height in centimeters
	private String heightType; // user height type inches or CM
	private double weight; // user weight
	private String weightType; //user weight type LB or KG
	private double bmiValues; //user BMI values
	private String healthProblem; //user selected health problems
	private String fitnessPlanType; //user selected fitness plan type
	private String userGoalType; // user selected goal type
	
	//generated getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		try {
			if(unit.equals("Imperial") || unit.equals("Metric")) {
				this.unit = unit;
			}
			else {
				throw new Exception("Invalid type requested");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}

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
	
	public double getBmiValues() {
		return bmiValues;
	}

	public void setBmiValues(double bmiValues) {
		this.bmiValues = bmiValues;
	}

	public String getHealthProblem() {
		return healthProblem;
	}

	public void setHealthProblem(String healthProblem) {
		this.healthProblem = healthProblem;
	}

	public String getFitnessPlanType() {
		return fitnessPlanType;
	}

	public void setFitnessPlanType(String fitnessPlanType) {
		this.fitnessPlanType = fitnessPlanType;
	}

	public String getUserGoalType() {
		return userGoalType;
	}

	public void setUserGoalType(String userGoalType) {
		this.userGoalType = userGoalType;
	}

	/**
	 * vector method to display data in JTable
	 * @return vector object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getVector() {
		Vector v = new Vector();
		v.add(id);
		v.add(heightCm);
		v.add(heightFeets);
		v.add(heightInches);
		v.add(heightType);
		v.add(unit);
		v.add(weight);
		v.add(weightType);
		return v;
	}

}
