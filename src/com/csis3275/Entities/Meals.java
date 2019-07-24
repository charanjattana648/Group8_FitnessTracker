/**
 * 
 */
package com.csis3275.Entities;

import java.util.Vector;

/**
 * @author charanpreet Singh
 *
 */
public class Meals {
private int id;
private String title;
private int readyInMinutes;
private int servings;
private double calories;
private double protein;
private double fat;
private double carbohydrates;

public int getServings() {
	return servings;
}
public void setServings(int servings) {
	this.servings = servings;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getReadyInMinutes() {
	return readyInMinutes;
}
public void setReadyInMinutes(int readyInMinutes) {
	this.readyInMinutes = readyInMinutes;
}
public double getCalories() {
	return calories;
}
public void setCalories(double calories) {
	this.calories = calories;
}
public double getProtein() {
	return protein;
}
public void setProtein(double protein) {
	this.protein = protein;
}
public double getFat() {
	return fat;
}
public void setFat(double fat) {
	this.fat = fat;
}
public double getCarbohydrates() {
	return carbohydrates;
}
public void setCarbohydrates(double carbohydrates) {
	this.carbohydrates = carbohydrates;
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public Vector getMealVector()
{
	Vector v=new Vector();
	v.add(id);
	v.add(title);
	v.add(readyInMinutes);
	v.add(servings);
	return v;
}

}
