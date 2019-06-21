package com.csis3275.Boundary;

import java.util.ArrayList;

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

public class DietDAOImpl {

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

	public int addMeal(Diet d) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		int newDietId = 0;
		try {
			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			newDietId = (int) sx.save(d);
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

	public ArrayList<Diet> getDietList() {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			String sql = "SELECT d FROM Diet d";
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

	
	public ArrayList<Diet> getDietOrderedList(String s) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> dietList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			String sql = "SELECT d FROM Diet d order by "+s;
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
	public Diet getDiet(int id) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		Diet d = new Diet();
		try {
			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();

			Query query = sx.createQuery("select d from Diet d where d.id=:id");
			query.setParameter("id", id);
			d = (Diet) query.list().get(0);
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
	//
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
			String sql = "SELECT distinct d.mealType FROM Diet d";
			mealTypeList = (ArrayList<String>) sx.createQuery(sql).list();
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
			String sql = "SELECT distinct d.foodType FROM Diet d";
			foodTypeList = (ArrayList<String>) sx.createQuery(sql).list();
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
			String sql = "SELECT distinct d.foodCategory FROM Diet d";
			foodCategoryList = (ArrayList<String>) sx.createQuery(sql).list();
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
			String sql = "SELECT distinct d.author FROM Diet d";
			authorList = (ArrayList<String>) sx.createQuery(sql).list();
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
	
	public ArrayList<Diet> getFilteredList(String clauses)
	{
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<Diet> filteredList = new ArrayList<Diet>();
		try {

			fx = getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			String sql = "SELECT d FROM Diet d where "+clauses;
			filteredList = (ArrayList<Diet>) sx.createQuery(sql).list();
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
