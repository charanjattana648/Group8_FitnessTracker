package com.csis3275.Controller;

import java.util.ArrayList;

import com.csis3275.Boundary.BodyMeasurementsDAOImpl;
import com.csis3275.Entities.BodyMeasurements;
/**
 * 
 * @author Charanpreet Singh
 * CalculateCaloriesNeeded class which provides calculations for calories needed.
 */
public class CalculateCaloriesNeeded {

	/**
	 * calNeeded() method takes following arguments and returns the calorieNeeded to burn or gain.
	 * @param txtCaldiffTxt is double value,Calorie difference that tells how much calorie should be burned or gained.
	 * @param txtCalconsumedTxt double value for calorie consumed.
	 * @param txtCalBurned double value for calorie Burned.
	 * @param userEmail is a String unique id of user.
	 * @return calNeeded ,which is double (Calorie Needed to be burnt or gained).
	 */
	public double calNeeded(String txtCaldiffTxt,String txtCalconsumedTxt,String txtCalBurned,String userEmail )
	{
		BodyMeasurementsDAOImpl bmI=new BodyMeasurementsDAOImpl();
		ArrayList<BodyMeasurements> bList=bmI.getBodyDatabyEmail(userEmail);
	double calDiff=Double.parseDouble(txtCaldiffTxt);
	double calConsumed=Double.parseDouble(txtCalconsumedTxt);
	double calBurned=Double.parseDouble(txtCalBurned);
	double calNeeded=0;
	if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Stay Fit Plan")){
		calNeeded=calConsumed-calBurned;
			}
	else if(bList.get(0).getFitnessPlanType().equalsIgnoreCase("Weight Gain Plan")){
		calNeeded=calConsumed-calBurned-calDiff;
	}else {
		calNeeded=calConsumed-calBurned+calDiff;
	} 		
		return calNeeded;
	}
}
