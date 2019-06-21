package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.UserDiet;

public class UserDietDAOImpl {
	DietDAOImpl dI=new DietDAOImpl();
	
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
			
			String sql="SELECT ud FROM UserDiet ud where ud.userEmail=:uEmail and ud.date=:date";
			Query query=sx.createQuery(sql);
			query.setParameter("uEmail", email);
			query.setParameter("date", date);
			userDietList=(ArrayList<UserDiet>) query.list();
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
			String sql="Select distinct ud.date from UserDiet ud where ud.userEmail=:uEmail order by ud.id desc";
			Query query=sx.createQuery(sql);
			query.setParameter("uEmail", email);
			dateList=(ArrayList<String>) query.list();
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
