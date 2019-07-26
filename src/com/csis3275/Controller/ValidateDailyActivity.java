package com.csis3275.Controller;

import javax.swing.JOptionPane;

import com.csis3275.Entities.DailyActivity;
/**
 * 
 * @author harpreet kaur 
 * student id:300288768
 *
 */


public class ValidateDailyActivity {
	
	
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

	
	DailyActivity da=new DailyActivity();
	boolean isValidInput;
	
	/**
	 * Method used to validate the input user entered in DailyActivity
	 * that is text field should not be empty ,hours should be less than or equal to 24,
	 * minutes should be less than 60 and minutes and hours should not be in negative.
	 * 
	 * 
	 * @param txtsleepHour , number of hours user sleep
	 * @param txtsleepMinute , minutes user sleep
	 * @param txtwaterGlass , number of glass of water user drink
	 * @param txtexerciseHour  , hours user exercise
	 * @param txtexerciseMinute  , minutes user exercise
	 * @param txtmeditationHour  , hours user meditate
	 * @param txtmeditationMinute  ,minutes user meditate
	 * @param txtwalkingHour ,hours user walk daily
	 * @param txtwalkingMinute  , minutes user walk daily
	 * @param txtextraCalories  , extra calories user consumed
	 * @param txtextraProtein  , extra proteins user consumed
	 * @param txtextraFat  ,extra fats user consumed
	 * @param txtworkHour  ,number of hours user work
	 * @param txtworkMinute , minutes user work
	 * @return  null
	 */

	public DailyActivity validate( String txtsleepHour, String txtsleepMinute, String txtwaterGlass,String txtexerciseHour,String txtexerciseMinute,String txtmeditationHour, String txtmeditationMinute,
			String txtwalkingHour,String txtwalkingMinute,String txtextraCalories, String txtextraProtein ,String txtextraFat,String txtworkHour,String txtworkMinute) {

		isValidInput=true;
		System.out.println("-------"+txtsleepHour+"-------"+txtsleepMinute+"-------");
		if(txtsleepHour.equalsIgnoreCase("") || txtsleepMinute.equalsIgnoreCase("") || txtwaterGlass.equalsIgnoreCase("") || txtexerciseHour.equalsIgnoreCase("") || txtexerciseMinute.equalsIgnoreCase("") || txtmeditationHour.equalsIgnoreCase("") || txtmeditationMinute.equalsIgnoreCase("") 
				|| txtwalkingHour.equalsIgnoreCase("") || txtwalkingMinute.equalsIgnoreCase("") || txtextraCalories.equalsIgnoreCase("") || txtextraProtein.equalsIgnoreCase("") || txtextraFat.equalsIgnoreCase("") || txtworkHour.equalsIgnoreCase("") || txtworkMinute.equalsIgnoreCase("") )
		{
			 JOptionPane.showMessageDialog(null, "One of the required field is empty!", "Error", JOptionPane.ERROR_MESSAGE);
			 isValidInput= false;
			 return null;
		}else {
		try {
			sleepHour=Integer.parseInt(txtsleepHour);
			sleepMinute=Integer.parseInt(txtsleepMinute);
			waterGlass=Integer.parseInt(txtwaterGlass);
			exerciseHour=Integer.parseInt(txtexerciseHour);
			exerciseMinute=Integer.parseInt(txtexerciseMinute);
			meditationHour=Integer.parseInt(txtmeditationHour);
			meditationMinute=Integer.parseInt(txtmeditationMinute);
			walkingHour=Integer.parseInt(txtwalkingHour);
			walkingMinute=Integer.parseInt(txtwalkingMinute);
			extraCalories=Double.parseDouble(txtextraCalories);
			extraProtein=Double.parseDouble(txtextraProtein);
			extraFat=Double.parseDouble(txtextraFat);
			workHour=Integer.parseInt(txtworkHour);
			workMinute=Integer.parseInt(txtworkMinute);
		}catch(NumberFormatException nx)
		{

			 JOptionPane.showMessageDialog(null, "Invalid input please check your entered Input.", "Error", JOptionPane.ERROR_MESSAGE);
			 isValidInput=false;
				return null;
		}
		}
		
	
		
		if(sleepHour<0 || sleepMinute<0 || waterGlass<0 || exerciseHour<0 || exerciseMinute<0 || meditationHour<0 ||
				meditationMinute<0 || walkingHour<0 || walkingMinute<0 || extraCalories<0 || exerciseMinute<0 || extraProtein<0 ||
				extraProtein<0 || extraFat<0 || workHour<0 || workMinute<0)
		{

			 JOptionPane.showMessageDialog(null, "Minutes/hours must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
			 isValidInput=false;
				return null;
				
		}
		
		if(sleepHour>24 || sleepMinute>59 || waterGlass>50 || exerciseHour>24 || exerciseMinute>59 || meditationHour>24 ||
				meditationMinute>59  || walkingHour>24 || walkingMinute>59  || exerciseMinute>59  || workHour>24 || workMinute>59 )
		{

			 JOptionPane.showMessageDialog(null, "Minutes must be less than 60 and hours should be less than or equal to 24.", "Error", JOptionPane.ERROR_MESSAGE);
			 isValidInput=false;
				return null;
				
		}		
		
		if(isValidInput)
		{
			da.setSleepHour(sleepHour);
			da.setSleepMinute(sleepMinute);
			da.setWaterGlass(waterGlass);
			da.setExerciseHour(exerciseHour);
			da.setExerciseMinute(exerciseMinute);
			da.setMeditationHour(meditationHour);
			da.setMeditationMinute(meditationMinute);
			da.setWalkingHour(walkingHour);
			da.setWalkingMinute(walkingMinute);
			da.setExtraCalories(extraCalories);
			da.setExtraProtein(extraProtein);
			da.setExtraFat(extraFat);
			da.setWorkType(workType);
			da.setWorkHour(workHour);
			da.setWorkMinute(workMinute);	
			return da;
		}
		
		
		return null;

}
}