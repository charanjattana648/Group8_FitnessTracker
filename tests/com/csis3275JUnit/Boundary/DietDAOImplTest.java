/**
 * 
 */
package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
 * @author charan
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
		if(sx!=null)
		{
		sx.close();
		}
		factory.close();
	}
	
	@Test
	void test_Session_factory() {	
		
		assertAll("heading",
				()->assertNotNull(ssr, "StandardServiceRegistry is null"),
				()->assertNotNull(meta, "meta is null"),
				()->assertNotNull(factory, "factory is null"));
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
		int newDietId = 0;
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			for(int i=0;i<21;i++)
			{
				newDietId = (int) sx.save(d);
			}
			tx.commit();
		} catch (HibernateException hx) {
			if (tx != null) {
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		newId=newDietId;
		assertNotEquals(0, newDietId);
	}
	@Test
	void test_getMeal()
	{
		int id=7;
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			d = (Diet) sx.get(Diet.class, id);
			tx.commit();
		} catch (HibernateException hx) {	
			if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(hx.getMessage());
		}
		assertNotNull(d);
	}
	
	@Test
	void test_deleteMeal()
	{
		d=dI.getDiet(81);		
		assertNotNull(dI.getDiet(d.getId()));
		try {
			sx=factory.openSession();
			tx=sx.beginTransaction();
			sx.delete(d);
			tx.commit();			
		}catch(HibernateException hx)
		{	if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(hx.getMessage());
		}
		assertNotNull(dI);
	    assertNotNull(d);
		assertNull(dI.getDiet(d.getId()));		
	}
	
	@Test
	void test_UpdateDiet()
	{
		String foodName="Shahi Paneer";
		d=dI.getDiet(82);
		d.setFoodName(foodName);
		try {
			sx=factory.openSession();
			tx=sx.beginTransaction();
			sx.update(d);
			tx.commit();
		}catch(HibernateException hx)
		{	if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(hx.getMessage());
			
		}
		assertNotNull(dI);
	    assertNotNull(d);
	    assertEquals(foodName, dI.getDiet(82).getFoodName());
	}
	
	@Test
	void test_mealTypeList()
	{
		ArrayList<String> mealTypeList = new ArrayList<String>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			mealTypeList=(ArrayList<String>) sx.getNamedQuery("mealTypeListQuery").list();			
			mealTypeList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		assertNotNull(mealTypeList);
		assertFalse(mealTypeList.isEmpty());		
		
	}
	@Test
	void test_foodTypeList()
	{
		ArrayList<String> foodTypeList = new ArrayList<String>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			foodTypeList = (ArrayList<String>) sx.getNamedQuery("foodTypeListQuery").list();			
			foodTypeList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		assertNotNull(foodTypeList);
		assertFalse(foodTypeList.isEmpty());
		
	}
	@Test
	void test_foodCategoryList()
	{
		ArrayList<String> foodCategoryList = new ArrayList<String>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			foodCategoryList=(ArrayList<String>) sx.getNamedQuery("foodCategoryListQuery").list();			
			foodCategoryList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		assertNotNull(foodCategoryList);
		assertFalse(foodCategoryList.isEmpty());
		
		
	}
	@Test
	void test_authorList()
	{
		ArrayList<String> authorList = new ArrayList<String>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			authorList=(ArrayList<String>) sx.getNamedQuery("getAuthorListQuery").list();
			authorList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}

		assertNotNull(authorList);
		assertFalse(authorList.isEmpty());
		
		
	}
	
	
	@Test
	void test_FilteredMealTypeList()
	{
		String mealType="";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilteredMealTypeListQuery").setParameter("mealType", mealType).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} 
		assertNotNull(filteredList);
		assertFalse(filteredList.isEmpty());		
	}
	
	@Test
	void test_FilterFoodCategoryList()
	{
		String foodCategory="";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilterFoodCategoryListQuery").setParameter("foodCategory", foodCategory).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		assertNotNull(filteredList);
		assertFalse(filteredList.isEmpty());
	}
	@Test
	void test_FilteredauthorList()
	{
		String author="";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilteredauthorListQuery").setParameter("author", author).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		assertNotNull(filteredList);
		assertFalse(filteredList.isEmpty());
	}
	@Test
	void test_FilteredfoodTypeList()
	{
		String foodType="";
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {
			sx = factory.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilteredfoodTypeListQuery").setParameter("foodType", foodType).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		}
		assertNotNull(filteredList);		
		assertFalse(filteredList.isEmpty());
	}
	
	
	

}
