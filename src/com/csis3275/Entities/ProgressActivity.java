package com.csis3275.Entities;

import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name="getProgressQuery",query="from ProgressActivity pa where pa.userEmail=:uEmail order by pa.date desc")
@Table(name="ProgressActivity")
public class ProgressActivity {

	@Id
	private String date;
	private String userEmail;
	private double currentWeight;
	private double caloriesConsumed;
	private double caloriesBurned;
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
	public double getCurrentWeight() {
		return currentWeight;
	}
	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}
	public double getCaloriesConsumed() {
		return caloriesConsumed;
	}
	public void setCaloriesConsumed(double caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public ProgressActivity() {
	}
	
	
	public Vector getVector()
	{
		Vector v=new Vector();
		v.add(getDate());
		v.add(getCaloriesConsumed());
		v.add(getCaloriesBurned());
		return v;
	}
	
	

}
