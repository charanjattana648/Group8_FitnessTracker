package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.UserDiet;
/**
 * 
 * @author charanpreet Singh 300288458
 *
 */
public class UserDietDAOImpl {
	DietDAOImpl dI=new DietDAOImpl();
	
	/**
	 * Query To get User Diet List
	 * @param email this is Current user Email of string type.
	 * @param date This is a current date or selected date stored in string 
	 * @return UserDiet List
	 */
	public ArrayList<UserDiet> getUserDietList(String email,String date)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		ArrayList<UserDiet> userDietList=new ArrayList<UserDiet>();
		try {
			fx=dI.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			
		//	String sql="SELECT ud FROM UserDiet ud where ud.userEmail=:uEmail and ud.date=:date";
			userDietList=(ArrayList<UserDiet>) sx.getNamedQuery("userDietListQuery").setParameter("uEmail", email).setParameter("date", date).list();
			
			tx.commit();
		}catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}finally {
			sx.close();
			fx.close();
		}
		return userDietList;
	}
	/**
	 * 
	 * @param email User Current Email Used in Query
	 * @return Will return the date list of items added.
	 */
	public ArrayList<String> getLastDPDates(String email)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		ArrayList<String>  dateList=new ArrayList<String>();
		try {
			fx=dI.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			dateList=(ArrayList<String>) sx.getNamedQuery("UserDietdateQuery").setParameter("uEmail", email).list();
			tx.commit();
		}catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}finally {
			sx.close();
			fx.close();
		}
		return dateList;
	}
	
	/**
	 * Add the UserDiet to table.
	 * @param ud is new UserDiet.
	 */
	public void addUserDiet(UserDiet ud)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		try {
			fx=dI.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			sx.save(ud);
			tx.commit();
		}catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}finally {
			sx.close();
			fx.close();
		}
	}
	/**
	 * 
	 * @param id Id is unique integer.
	 * @return UserDiet
	 */
	public UserDiet getUserDiet(int id)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		UserDiet ud=new UserDiet();
		try {
			fx=dI.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			ud=sx.get(UserDiet.class, id);
			tx.commit();
		}
		catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}		finally {
			sx.close();
			fx.close();
		}
		return ud;
	}
	/**
	 * Delete userDiet
	 * @param ud UserDiet that is to deleted.
	 */
	public void deleteUserDiet(UserDiet ud)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		try {
			fx=dI.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			sx.delete(ud);;
			tx.commit();
		}
		catch(HibernateException hx)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println("Error "+hx.getMessage());
		}		finally {
			sx.close();
			fx.close();
		}
	}

}
