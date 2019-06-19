package com.csis3275.Entities;

import java.util.Vector;


//@Entity
//@Table(name = "Diet")
public class Diet {

	//@Id
	//@GeneratedValue
	private int id;
	private int mealId;
	private String mealType;
	private String foodName;
	private String foodType;
	private String foodCategory;
	private int readyTime;
	private double calories;
	private double protein;
	private double fat;
	private double carbohydrates;
	private double vitaminA;
	private double vitaminC;
	private double calcium;
	private double iron;
	private String author;

	
	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public double getVitaminA() {
		return vitaminA;
	}

	public void setVitaminA(double vitaminA) {
		this.vitaminA = vitaminA;
	}

	public double getVitaminC() {
		return vitaminC;
	}

	public void setVitaminC(double vitaminC) {
		this.vitaminC = vitaminC;
	}

	public double getCalcium() {
		return calcium;
	}

	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}

	public double getIron() {
		return iron;
	}

	public void setIron(double iron) {
		this.iron = iron;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Meal Plans : ");
		sb.append("Item Id : " + getId() + "\n");
		sb.append("Meal Id : " + getMealId() + "\n");
		sb.append("Food Name : " + getFoodName() + "\n");
		sb.append("Food Type : " + getFoodType() + "\n");
		sb.append("Ready Time : " + getReadyTime() + " min\n");
		sb.append("Calories : " + getCalories() + "g\n");
		sb.append("Protein : " + getProtein() + "g\n");
		sb.append("Fat : " + getFat() + "g\n");
		sb.append("Carbohydrates : " + getCarbohydrates() + "g\n");

		return sb.toString();
	}

	public Vector getVector() {
		Vector v = new Vector();
		v.add(getId());
		v.add(String.valueOf(getMealId()));
		v.add(getMealType());
		v.add(getFoodName());
		v.add(getFoodType());
		v.add(getFoodCategory());
		v.add(String.valueOf(getReadyTime()));
		v.add(String.valueOf(getCalories()));
		v.add(String.valueOf(getProtein()));
		v.add(String.valueOf(getFat()));
		v.add(String.valueOf(getCarbohydrates()));
		v.add(String.valueOf(getVitaminA()));
		v.add(String.valueOf(getVitaminC()));
		v.add(String.valueOf(getCalcium()));
		v.add(String.valueOf(getIron()));
		v.add(getAuthor());

		return v;
	}
	


}
