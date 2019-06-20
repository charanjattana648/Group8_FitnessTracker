package com.csis3275.Controller;

import java.util.Vector;

import com.csis3275.Entities.BodyMeasurements;

/**
 * Calculate BMI Class
 * @author Gurinder Singh 300289450
 *
 */

public class CalculateBMI {
	
	//Constants
	
	final int CONVERSION = 703;
	final double UNDERWEIGHT = 18.5;
	final double NORMAL = 24.9;
	final double OVERWEIGHT = 29.9;
	final double OBESE = 30;
	final int HEIGHT_CONVERSION = 12;
	
	double bmi = 0; // Body Mass Index
	double convertedFeetsToInches = 0; //Converted feet value to inches
	double heightInInches = 0; //total height in inches, feet + inches
	double heightInMeters = 0; // height in meter
	
	
	/**
	 * Calculate the Body Mass Index of user
	 * @param user Object of BodyMeasurements
	 * @return double BMI
	 */
	public double calculateBMI(BodyMeasurements user) {
		
		if(user.getUnit().equals("Imperial") && user.getHeightType().equals("inches") && user.getWeightType().equals("lb")) {
			convertedFeetsToInches = user.getHeightFeets() * (double) 12;
			heightInInches = convertedFeetsToInches + user.getHeightInches();
			bmi = (user.getWeight() / (heightInInches * heightInInches)) * (double) CONVERSION;
		}
		
		else if(user.getUnit().equals("Metric") && user.getHeightType().equals("cm") && user.getWeightType().equals("kg")) {
			heightInMeters = user.getHeightCm() / (double) 100;
			bmi = user.getWeight() / (heightInMeters * heightInMeters);
		}
		
		return bmi;
	}
	
	/**
	 * bmiResult
	 * @return String result describing the under-weight, over-weight, normal and obese weight range
	 */
	public String bmiResult() {
		String result = "";
		
		if(bmi < UNDERWEIGHT) {
			result = "Based on the bmi results you are Underweight." + "\n" + "You should choose Weight Gain plan";
		}
		else if(bmi >= UNDERWEIGHT && bmi < NORMAL) {
			result = "Based on the bmi results you are under Normal range." + "\n" + "You should choose Stay FIT plan";
		}
		else if(bmi >= NORMAL && bmi < OVERWEIGHT) {
			result = "Based on the bmi results you are Overweight." + "\n" + "You should choose Weight Loss plan";
		}
		else {
			result = "Based on the bmi results you are Obese." + "\n" + "You should choose Extreme Weight Loss plan";
		}
		
		return result;
			
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector bmiVecor() {
		Vector v = new Vector();
		v.add(bmi);
		return v;
	}

}
