package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.DailyActivity;

public class DailyActivityDAOImpl {
	
	DietDAOImpl dI=new DietDAOImpl();
	
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
public DailyActivity getDailyActivities(String date,String email) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		DailyActivity da=new DailyActivity();
		try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();		
		da=(DailyActivity) sx.getNamedQuery("getDailyActivityQuery").setParameter("currdate", date).setParameter("curremail", email);
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
		return da;
		
	}
	


public ArrayList<DailyActivity> getDailyActivitiesList(String email) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		ArrayList<DailyActivity> daList=new ArrayList<DailyActivity>();
		
		try {
		fx=dI.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();		
		daList=(ArrayList<DailyActivity>) sx.getNamedQuery("getDailyActivityListQuery").setParameter("curremail", email).list();
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
