package com.csis3275.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQuery(name="getDailyActivityQuery",query="select d from DailyActivity d where d.date=:currdate and d.userEmail=:curremail")
@NamedQuery(name="getDailyActivityListQuery",query="from DailyActivity where userEmail=:curremail")
@Table(name="DailyActivity")
public class DailyActivity {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true)
	private String date;
	private String userEmail;
	private int sleepHour;
	private int sleepMinute;
	private int waterGlass;
	private int exerciseHour;
	private int exerciseMinute;
	private int meditationHour;
	private int meditationMinute;
	private int walkingHour;
	private int walkingMinute;
	private double extraCalories;
	private double extraProtein;
	private double extraFat;
	private String workType;
	private int workHour;
	private int workMinute;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSleepHour() {
		return sleepHour;
	}
	public void setSleepHour(int sleepHour) {
		this.sleepHour = sleepHour;
	}
	public int getSleepMinute() {
		return sleepMinute;
	}
	public void setSleepMinute(int sleepMinute) {
		this.sleepMinute = sleepMinute;
	}
	public int getWaterGlass() {
		return waterGlass;
	}
	public void setWaterGlass(int waterGlass) {
		this.waterGlass = waterGlass;
	}
	public int getExerciseHour() {
		return exerciseHour;
	}
	public void setExerciseHour(int exerciseHour) {
		this.exerciseHour = exerciseHour;
	}
	public int getExerciseMinute() {
		return exerciseMinute;
	}
	public void setExerciseMinute(int exerciseMinute) {
		this.exerciseMinute = exerciseMinute;
	}
	public int getMeditationHour() {
		return meditationHour;
	}
	public void setMeditationHour(int meditationHour) {
		this.meditationHour = meditationHour;
	}
	public int getMeditationMinute() {
		return meditationMinute;
	}
	public void setMeditationMinute(int meditationMinute) {
		this.meditationMinute = meditationMinute;
	}
	public int getWalkingHour() {
		return walkingHour;
	}
	public void setWalkingHour(int walkingHour) {
		this.walkingHour = walkingHour;
	}
	public int getWalkingMinute() {
		return walkingMinute;
	}
	public void setWalkingMinute(int walkingMinute) {
		this.walkingMinute = walkingMinute;
	}
	public double getExtraCalories() {
		return extraCalories;
	}
	public void setExtraCalories(double extraCalories) {
		this.extraCalories = extraCalories;
	}
	public double getExtraProtein() {
		return extraProtein;
	}
	public void setExtraProtein(double extraProtein) {
		this.extraProtein = extraProtein;
	}
	public double getExtraFat() {
		return extraFat;
	}
	public void setExtraFat(double extraFat) {
		this.extraFat = extraFat;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public int getWorkHour() {
		return workHour;
	}
	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}
	public int getWorkMinute() {
		return workMinute;
	}
	public void setWorkMinute(int workMinute) {
		this.workMinute = workMinute;
	}

	

}
