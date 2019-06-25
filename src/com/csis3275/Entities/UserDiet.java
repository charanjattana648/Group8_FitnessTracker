package com.csis3275.Entities;


import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * UserDiet Object.
 * @author charanpreet Singh
 *
 */
@Entity
@NamedQuery(name="userDietListQuery",query="Select ud from UserDiet ud where ud.userEmail=:uEmail and ud.date=:date")
@NamedQuery(name="UserDietdateQuery",query="Select distinct ud.date from UserDiet ud where ud.userEmail=:uEmail order by ud.id desc")
@Table(name="UserDiet")
public class UserDiet {

	@Id
	@GeneratedValue	
	private int id;
	private String userEmail;
	private int dietId;
	private String mealType;
	private String foodName;
	private int readyTime;
	private double calories;
	private String author;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDietId() {
		return dietId;
	}
	public void setDietId(int dietId) {
		this.dietId = dietId;
	}
	public String getMealType() {
		return mealType;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getReadyTime() {
		return readyTime;
	}
	public void setReadyTime(int readyTime) {
		this.readyTime = readyTime;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vector getVector() {
		Vector v = new Vector();
		v.add(getId());
		v.add(String.valueOf(getDietId()));
		v.add(getMealType());
		v.add(getFoodName());
		v.add(String.valueOf(getReadyTime()));
		v.add(String.valueOf(getCalories()));
		v.add(getDate());
		v.add(getAuthor());
		return v;
	}
	
}
