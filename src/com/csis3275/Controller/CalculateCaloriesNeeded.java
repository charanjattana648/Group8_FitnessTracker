package com.csis3275.Controller;

import java.util.ArrayList;

import com.csis3275.Boundary.BodyMeasurementsDAOImpl;
import com.csis3275.Entities.BodyMeasurements;

public class CalculateCaloriesNeeded {

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
