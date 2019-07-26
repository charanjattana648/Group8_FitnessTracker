package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.CaloriesConsumed;
import com.csis3275.Entities.ProgressActivity;
import com.csis3275.Entities.UserDiet;
/**
 * 
 * @author Charanpreet Singh
 * 
 */
public class ProgressActivityDAOImpl {
	
private DietDAOImpl dI=new DietDAOImpl();
/**
 * getCaloriesConsumed() method is used to get the calories consumed by passing email.
 * @param userEmail is String and it is unique for every person. by passing userEmail we can get all data stored by that email.
 * @return udList which is ArrayList<Double> of double values.
 */
public ArrayList<Double> getCaloriesConsumed(String userEmail)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		ArrayList<Double> udList=new ArrayList<Double>();
		try {
			fx=dI.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			udList=(ArrayList<Double>) sx.getNamedQuery("getCaloriesConsumedQuery").setParameter("uEmail", userEmail).setMaxResults(7).list();			
			tx.commit();
			
		}catch(HibernateException he)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			System.err.println(he.getMessage());
		}finally {
			sx.close();
			fx.close();
		}
		return udList;
	}

/**
 * saveProgress() is a method used to save progress of user.
 * @param pa is the object of progressActivity.
 * @return String
 */
public String saveProgress(ProgressActivity pa)
{
	SessionFactory fx=null;
	Session sx=null;
	Transaction tx=null;
	String key="";
	try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();
		key=(String) sx.save(pa);		
		tx.commit();
		
	}catch(HibernateException he)
	{
		if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(he.getMessage());
	}finally {
		sx.close();
		fx.close();
	}
	return key;
}
/**
 * updateProgress() is a method used to update progress of user.
 * @param pa is the object of progressActivity.
 */
public void updateProgress(ProgressActivity pa)
{
	SessionFactory fx=null;
	Session sx=null;
	Transaction tx=null;
	try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();
		sx.update(pa);		
		tx.commit();		
	}catch(HibernateException he)
	{
		if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(he.getMessage());
	}finally {
		sx.close();
		fx.close();
	}
}
/**
 * 
 * @param userEmail is a String which is userId.
 * @return paList  which is ArrayList<ProgressActivity> of ProgressActivity.
 */

public ArrayList<ProgressActivity> getProgress(String userEmail)
{
	SessionFactory fx=null;
	Session sx=null;
	Transaction tx=null;
	ArrayList<ProgressActivity> paList=new ArrayList<ProgressActivity>();
	try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();
		paList=(ArrayList<ProgressActivity>) sx.getNamedQuery("getProgressQuery").setParameter("uEmail", userEmail).list();			
		tx.commit();
		
	}catch(HibernateException he)
	{
		if(tx!=null)
		{
			tx.rollback();
		}
		System.err.println(he.getMessage());
	}finally {
		sx.close();
		fx.close();
	}
	return paList;
}
}
