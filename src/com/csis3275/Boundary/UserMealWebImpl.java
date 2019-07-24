package com.csis3275.Boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.csis3275.Entities.Meals;

public class UserMealWebImpl {
	static JSONArray jsonArray;
	static JSONObject jsonObj;
	
	public static String getJsonMealResult(double caloriesReq)
	{
		BufferedReader br;
		StringBuffer sb=new StringBuffer();
		String myurl="https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate?targetCalories="+caloriesReq+"&timeFrame=day";
		try {
			URL foodurl=new URL(myurl);
			HttpURLConnection conn=(HttpURLConnection) foodurl.openConnection();
			conn.addRequestProperty("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com");
			conn.setRequestProperty("X-RapidAPI-Key", "b8824ccfd8msh16a67be422de505p190744jsnd170a0e2609d");
			conn.setRequestMethod("GET");
			int response=conn.getResponseCode();			
			System.out.println(response+"");
			
			if(response>299)
			{
				br=new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
				br.close();
			}
			else {
				br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line="";
				while((line=br.readLine())!=null)
				{
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Meals> getmeals(double caloriesReq)
	{
		String response=getJsonMealResult(caloriesReq);
		ArrayList<Meals> mealList=new ArrayList<Meals>();
		
		if(response!=null)
		{
			try {
				jsonObj=new JSONObject(response);
				jsonArray=jsonObj.getJSONArray("meals");
				
				for(int i=0;i<jsonArray.length();++i)
				{
					Meals m=new Meals();
					JSONObject mealObj=jsonArray.getJSONObject(i);
					m.setId(mealObj.getInt("id"));
					m.setTitle(mealObj.getString("title"));
					m.setReadyInMinutes(mealObj.getInt("readyInMinutes"));
					m.setServings(mealObj.getInt("servings"));
					mealList.add(m);					
				}
				return mealList;
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}
		return null;	
	}
	
	public static Meals getNutrients(double caloriesReq)
	{
		String response=getJsonMealResult(caloriesReq);
		Meals m=new Meals();
		if(response!=null)
		{
			try {
				jsonObj=new JSONObject(response);
				JSONObject nutrientsObj=jsonObj.getJSONObject("nutrients");
				
				
					m.setCalories(nutrientsObj.getDouble("calories"));
					m.setCarbohydrates(nutrientsObj.getDouble("carbohydrates"));
					m.setFat(nutrientsObj.getDouble("fat"));
					m.setProtein(nutrientsObj.getDouble("protein"));
					return m;
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<Meals> ml=getmeals(2000);
		for(int i=0;i<ml.size();i++)
		{
			System.out.println(ml.get(i).getId());
			System.out.println(ml.get(i).getTitle());
			System.out.println(ml.get(i).getReadyInMinutes());
			System.out.println(ml.get(i).getServings());
			System.out.println("\n-------------------------------------------------------------\n");
		}
		
		Meals m=getNutrients(2000);
		System.out.println(m.getCalories()+"");
		System.out.println(m.getCarbohydrates()+"");
		System.out.println(m.getFat()+"");
		System.out.println(m.getProtein()+"");
	}
	

	
}
