/**
 * 
 */
package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Boundary.DietDAOImpl;
import com.csis3275.Entities.Diet;

/**
 * @author Charanpreet Singh
 *
 */
class DietDAOImplTest {
	DietDAOImpl dI;
	Diet d;
	StandardServiceRegistry ssr = null;
	Metadata meta = null;
	SessionFactory factory = null;
	Session sx = null;
	Transaction tx = null;
	int newId;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		d=new Diet();
		dI=new DietDAOImpl();
		try {
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			factory = meta.getSessionFactoryBuilder().build();
		} catch (Throwable e) {
			System.err.println("Error : " + e.getMessage());
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	
	}
	
	@Test
	void test_Session_factory() {	
		
		assertAll("heading",
				()->assertNotNull(ssr, "StandardServiceRegistry is null"),
				()->assertNotNull(meta, "meta is null"),
				()->assertNotNull(factory, "factory is null"));
		if(sx!=null)
		{
		sx.close();
		}
		factory.close();
	}
	
	public void dietData()
	{
		d.setCalories(10);
		d.setCarbohydrates(12);
		d.setFat(15.2);
		d.setFoodName("Paneer");
		d.setFoodType("Diary");
		d.setMealId(2);
		d.setProtein(16.6);
		d.setReadyTime(30);
		d.setFoodCategory("Vegetarian");
		d.setMealType("Lunch");
		d.setVitaminA(2);
		d.setVitaminC(1.3);
		d.setCalcium(4.6);
		d.setIron(2.4);
		d.setAuthor("Charan");
	}
	@Test
	void test_addMeal()
	{
		dietData();
		int newDietId=dI.addMeal(d);
		assertNotEquals(0, newDietId);
	}
	@Test
	void test_getMeal()
	{
		int id=7;
	    d=dI.getDiet(id);
		assertNotNull(d);
	    assertEquals(id, d.getId());
	
	}
	
	@Test
	void test_getMealList()
	{
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		dietList=dI.getDietList();
		assertNotNull(dietList);
		assertFalse(dietList.isEmpty());
	}
	
	@Test
	void test_deleteMeal()
	{
		d=dI.getDiet(84);		
		assertNotNull(dI.getDiet(d.getId()));
		dI.deleteDiet(d);
		assertNotNull(dI);
	    assertNotNull(d);
		assertNull(dI.getDiet(d.getId()));		
	}
	
	@Test
	void test_UpdateDiet()
	{
		String foodName="Shahi Paneer";
		d=dI.getDiet(85);
		d.setFoodName(foodName);
		dI.updateDiet(d);
		assertNotNull(dI);
	    assertNotNull(d);
	    assertEquals(foodName, dI.getDiet(82).getFoodName());
	}
	
	@Test
	void test_mealTypeList()
	{
		ArrayList<String> mealTypeList = new ArrayList<String>();
		mealTypeList=dI.getMealTypeList();	
		assertNotNull(mealTypeList);
		assertFalse(mealTypeList.isEmpty());		
		
	}
	@Test
	void test_foodTypeList()
	{
		ArrayList<String> foodTypeList = new ArrayList<String>();
		foodTypeList=dI.getFoodTypeList();
		assertNotNull(foodTypeList);
		assertFalse(foodTypeList.isEmpty());
		
	}
	@Test
	void test_foodCategoryList()
	{
		ArrayList<String> foodCategoryList = new ArrayList<String>();
	    foodCategoryList=dI.getFoodCategoryList();
		assertNotNull(foodCategoryList);
		assertFalse(foodCategoryList.isEmpty());
		
		
	}
	@Test
	void test_authorList()
	{
		ArrayList<String> authorList = new ArrayList<String>();
		authorList=dI.getAuthorList();
		assertNotNull(authorList);
		assertFalse(authorList.isEmpty());		
	}
	
	
	@Test
	void test_FilteredMealTypeList()
	{
		String mealType="Dinner";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		filteredList=dI.getFilteredMealTypeList(mealType);
		assertNotNull(filteredList);
		assertFalse(filteredList.isEmpty());		
	}
	
	@Test
	void test_FilterFoodCategoryList()
	{
		String foodCategory="Vegetarian";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		filteredList=dI.getFilterFoodCategoryList(foodCategory);
		assertNotNull(filteredList);
		assertFalse(filteredList.isEmpty());
	}
	@Test
	void test_FilteredauthorList()
	{
		String author="Admin";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		filteredList=dI.getFilteredauthorList(author);
		assertNotNull(filteredList);
		assertFalse(filteredList.isEmpty());
	}
	@Test
	void test_FilteredfoodTypeList()
	{
		String foodType="Vegetable";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		filteredList=dI.getFilteredFoodTypeList(foodType);
		assertNotNull(filteredList);		
		assertFalse(filteredList.isEmpty());
	}
	
	@Test
	void test_DietOrderedList()
	{
		String orderby="fat";
		String type="asc";
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		dietList=dI.getDietOrderedList(type, orderby);
		assertNotNull(dietList);
		assertFalse(dietList.isEmpty());
	}
	

}
