package com.csis3275.Entities;
/**
 * 
 * @author Charanpreet Singh
 * CaloriesConsumed Object required for graphs. 
 */
public class CaloriesConsumed {
	/**
	 * Attributes along with getters and setters.
	 */
private String date;
private double consumedCalories;

public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public double getConsumedCalories() {
	return consumedCalories;
}
public void setConsumedCalories(double consumedCalories) {
	this.consumedCalories = consumedCalories;
}
public CaloriesConsumed() {
}


}
