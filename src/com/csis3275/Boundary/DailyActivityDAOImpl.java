package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.DailyActivity;
/**
 * 
 * @author harpreet kaur
 * student id : 300288768
 */
public class DailyActivityDAOImpl {
	
	
	DietDAOImpl dI=new DietDAOImpl();
	
	/**
	 * 
	 * @param da instance of DailyActivity class
	 * @return id  of user
	 * In this method the user can add record of daily Activities. 
	 */
	
	public int addDailyActivities(DailyActivity da) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		int id=0;
		try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();		
	    id=(int) sx.save(da);
		tx.commit();
		
		}catch(HibernateException ex) {
			if(tx!=null) {
				tx.rollback();
			}
			System.err.println(ex.getMessage());
			
		}finally {
			fx.close();
			sx.close();
		}
		return id;
		
	}
	
	/**
	 * 
	 * @param date  the current date when daily activity is added
	 * @param email of user
	 * @return daList the list of daily activities by date and email of user.
	 */
public ArrayList<DailyActivity> getDailyActivities(String date,String email) {
	
	SessionFactory fx=null;
	Session sx=null;
	Transaction tx=null;
	ArrayList<DailyActivity> daList=new ArrayList<DailyActivity>();
	
	try {
	fx=dI.getFactory();
	sx=fx.openSession();
	tx=sx.beginTransaction();		
	daList=(ArrayList<DailyActivity>) sx.getNamedQuery("getDailyActivityQuery").setParameter("currdate", date).setParameter("curremail", email).list();
	tx.commit();
	
	}catch(HibernateException ex) {
		if(tx!=null) {
			tx.rollback();
		}
		System.err.println(ex.getMessage());
		
	}finally {
		fx.close();
		sx.close();
	}
	return daList;
	
		
	}
	
    /**
     * 
     * @param email of user
     * @return daList the list of daily activities by email of user
     */

public ArrayList<DailyActivity> getDailyActivitiesList(String email) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		ArrayList<DailyActivity> daList=new ArrayList<DailyActivity>();
		
		try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();		
		daList=(ArrayList<DailyActivity>) sx.getNamedQuery("getDailyActivityListQuery").setParameter("curremail", email).setMaxResults(7).list();
		tx.commit();
		
		}catch(HibernateException ex) {
			if(tx!=null) {
				tx.rollback();
			}
			System.err.println(ex.getMessage());
			
		}finally {
			fx.close();
			sx.close();
		}
		return daList;
		
	}
	

}
