package com.csis3275.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DailyActivity")
public class DailyActivity {
	
	@Id
	@GeneratedValue
	private int id;
	private String userEmail;
	private double sleepHour;
	private double sleepMinute;
	private int waterGlass;
	private double exerciseHour;
	private double exerciseMinute;
	private double meditationHour;
	private double meditationMinute;
	private double walkingHour;
	private double walkingMinute;
	private double extraCalories;
	private double extraProtein;
	private double extraFat;
	private String workType;
	private double workHour;
	private double workMinute;
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
	public double getSleepHour() {
		return sleepHour;
	}
	public void setSleepHour(double sleepHour) {
		this.sleepHour = sleepHour;
	}
	public double getSleepMinute() {
		return sleepMinute;
	}
	public void setSleepMinute(double sleepMinute) {
		this.sleepMinute = sleepMinute;
	}
	public int getWaterGlass() {
		return waterGlass;
	}
	public void setWaterGlass(int waterGlass) {
		this.waterGlass = waterGlass;
	}
	public double getExerciseHour() {
		return exerciseHour;
	}
	public void setExerciseHour(double exerciseHour) {
		this.exerciseHour = exerciseHour;
	}
	public double getExerciseMinute() {
		return exerciseMinute;
	}
	public void setExerciseMinute(double exerciseMinute) {
		this.exerciseMinute = exerciseMinute;
	}
	public double getMeditationHour() {
		return meditationHour;
	}
	public void setMeditationHour(double meditationHour) {
		this.meditationHour = meditationHour;
	}
	public double getMeditationMinute() {
		return meditationMinute;
	}
	public void setMeditationMinute(double meditationMinute) {
		this.meditationMinute = meditationMinute;
	}
	public double getWalkingHour() {
		return walkingHour;
	}
	public void setWalkingHour(double walkingHour) {
		this.walkingHour = walkingHour;
	}
	public double getWalkingMinute() {
		return walkingMinute;
	}
	public void setWalkingMinute(double walkingMinute) {
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
	public double getWorkHour() {
		return workHour;
	}
	public void setWorkHour(double workHour) {
		this.workHour = workHour;
	}
	public double getWorkMinute() {
		return workMinute;
	}
	public void setWorkMinute(double workMinute) {
		this.workMinute = workMinute;
	}
	

}
