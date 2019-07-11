package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.csis3275.Entities.Diet;
/**
 * 
 * @author Charanpreet Singh
 *
 */
public class DietDAOImpl {

	/**
	 * 
	 * @return SessionFactory for hibernate.
	 */
	public static SessionFactory getFactory() {
		StandardServiceRegistry ssr = null;
		Metadata meta = null;
		SessionFactory factory = null;
		try {
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			factory = meta.getSessionFactoryBuilder().build();
		} catch (Throwable e) {
			System.err.println("Error : " + e.getMessage());
		}
		return factory;
	}

	/**
	 * Adding new Diet
	 * @param d Diet Object.
	 * @return integer unique id of added Diet.
	 */
	public int addMeal(Diet d) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		int newDietId = 0;
		try {
			fx = getFactory();
			sx = fx.openSession();
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
		} finally {
			sx.close();
			fx.close();
		}

		return newDietId;
	}

	/**
	 * Diet List
	 * @return ArrayList of Diet.
	 */
	public ArrayList<Diet> getDietList() {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			String sql = "FROM Diet d";
			dietList = (ArrayList<Diet>) sx.createQuery(sql).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return dietList;
	}

	/**
	 * For Diet Ordered List
	 * @param s query how to order the diet.
	 * @return ArrayList of ordered diet.
	 */
	public ArrayList<Diet> getDietOrderedList(String orderby) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		try {
			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			//String sql = "SELECT d FROM Diet d order by :orderby ASC ";
			//dietList = (ArrayList<Diet>) sx.createQuery(sql).setParameter("orderby", orderby).list();
			dietList = (ArrayList<Diet>) sx.getNamedQuery("getDietOrderedListQuery").setParameter("orderby", orderby).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return dietList;
	}
	/**
	 * getDiet To get 1 Diet.
	 * @param id Primary key.
	 * @return Diet of entered id.
	 */
	public Diet getDiet(int id) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		Diet d = new Diet();
		try {
			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			d = (Diet) sx.get(Diet.class, id);
			tx.commit();
		} catch (HibernateException hx) {	
			if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(hx.getMessage());
		} finally {
			fx.close();
			sx.close();
		}

		return d;
	}
	/**
	 * Delete Diet
	 * @param d Diet object that is to deleted.
	 */
	public void deleteDiet(Diet d)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		try {
			fx=getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			sx.delete(d);
			tx.commit();
			
		}catch(HibernateException hx)
		{	if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(hx.getMessage());
		}finally {
			fx.close();
			sx.close();
		}
	}
	/**
	 * Update Diet
	 * @param d Diet object that is to updated.
	 */
	public void updateDiet(Diet d)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
	try {
		fx=getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();
		sx.update(d);
		tx.commit();
	}catch(HibernateException hx)
	{	if(tx!=null)
	{
		tx.rollback();
	}
	System.err.println(hx.getMessage());
		
	}finally {
		fx.close();
		sx.close();
		
	}
	}
	/**
	 * MealType List for Combo Box.
	 * @return list of Meal types.
	 */
	@SuppressWarnings({ "unchecked"})
	public ArrayList<String> getMealTypeList()
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<String> mealTypeList = new ArrayList<String>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			//String sql = "SELECT distinct d.mealType FROM Diet d";
			//mealTypeList = (ArrayList<String>) sx.createQuery(sql).list();
			mealTypeList=(ArrayList<String>) sx.getNamedQuery("mealTypeListQuery").list();
			mealTypeList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return mealTypeList;
	}
	/**
	 * FoodType List for Combo Box.
	 * @return list of Food types.
	 */
	public ArrayList<String> getFoodTypeList()
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<String> foodTypeList = new ArrayList<String>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			//String sql = "SELECT distinct d.foodType FROM Diet d";
			foodTypeList = (ArrayList<String>) sx.getNamedQuery("foodTypeListQuery").list();
			foodTypeList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return foodTypeList;
	}
	/**
	 * FoodCategory List for Combo Box.
	 * @return list of Food Category.
	 */
	public ArrayList<String> getFoodCategoryList()
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<String> foodCategoryList = new ArrayList<String>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			//String sql = "SELECT distinct d.foodCategory FROM Diet d";
			foodCategoryList = (ArrayList<String>) sx.getNamedQuery("foodCategoryListQuery").list();
			foodCategoryList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return foodCategoryList;
	}
	/**
	 * Author List for Combo Box.
	 * @return list of Author List.
	 */
	public ArrayList<String> getAuthorList()
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<String> authorList = new ArrayList<String>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			//String sql = "SELECT distinct d.author FROM Diet d";
			authorList = (ArrayList<String>) sx.getNamedQuery("getAuthorListQuery").list();
			authorList.add(0,"None");
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return authorList;
	}
	
	/**
	 * getFilteredMealTypeList Method to filter Diet list according to mealType.
	 * @param mealType by which user want to filter.
	 * @return list of Filtered List by mealType.
	 * 
	 */
	
	public ArrayList<Diet> getFilteredMealTypeList(String mealType)
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilteredMealTypeListQuery").setParameter("mealType", mealType).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return filteredList;
	}
	/**
	 *  getFilterFoodCategoryList Method to filter Diet list according to foodCategory.
	 * @param foodCategory by which user want to filter.
	 * @return Filter List by FoodCategory.
	 */
	public ArrayList<Diet> getFilterFoodCategoryList(String foodCategory)
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilterFoodCategoryListQuery").setParameter("foodCategory", foodCategory).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return filteredList;
	}
	/**
	 * getFilteredauthorList Method to filter Diet list according to Author.
	 * @param author name by which user want to filter.
	 * @return Filtered list by author.
	 */
	public ArrayList<Diet> getFilteredauthorList(String author)
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilteredauthorListQuery").setParameter("author", author).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return filteredList;
	}
	/**
	 * getFilteredFoodTypeList Method to filter Diet list according to FoodType.
	 * @param foodType by which user want to filter.
	 * @return Filtered List by FoodType.
	 */
	public ArrayList<Diet> getFilteredFoodTypeList(String foodType)
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			filteredList = (ArrayList<Diet>) sx.getNamedQuery("getFilteredfoodTypeListQuery").setParameter("foodType", foodType).list();
			tx.commit();

		} catch (HibernateException hx) {
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(hx.getMessage());
		} finally {
			sx.close();
			fx.close();
		}
		return filteredList;
	}
}
