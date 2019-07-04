package com.csis3275.Boundary;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.User;

/**
 * 
 * @author Harpreet Kaur
 *
 */
public class UserDAOImpl {
	
	DietDAOImpl dietIns=new DietDAOImpl();

	/**
	 * Create User
	 * @param u New User 
	 * @return key of user (Email).
	 */
	
	public String createUserAccount(User u)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		
		String newUser="";
		
		try {
			
          fx=dietIns.getFactory();
          sx=fx.openSession();
          tx=sx.beginTransaction();
          newUser=(String) sx.save(u);
          tx.commit();
			
		}catch(HibernateException ex) {
			if(tx!=null) {
				tx.rollback();
			}			
			System.err.println(ex.getMessage());			
		}finally {
			sx.close();
			fx.close();			
		}		
		return newUser;
	}
	//
	
	public String createInstructorAccount(User u)
	{
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		
		String newInstructor="";
		
		try {
			
          fx=dietIns.getFactory();
          sx=fx.openSession();
          tx=sx.beginTransaction();
          newInstructor=(String) sx.save(u);
          tx.commit();
			
		}catch(HibernateException ex) {
			if(tx!=null) {
				tx.rollback();
			}			
			System.err.println(ex.getMessage());			
		}finally {
			sx.close();
			fx.close();			
		}		
		return newInstructor;
	}
	
	public boolean checkUEPass(String currUserEmail,String currPass) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		boolean isUserFound=false;
		try {
			fx=dietIns.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			int x=sx.getNamedQuery("CheckUser").setParameter("uEmail", currUserEmail).setParameter("UPass", currPass).list().size();		
			if(x>0)
			{
				isUserFound=true;
			}	
			tx.commit();
		}catch(HibernateException ex) {
			
			if(tx!=null) {
				tx.rollback();
			}
			System.err.println(ex.getMessage());
			
		}finally {
			sx.close();
			fx.close();
			
		}
		return isUserFound;
		
	}
	
public boolean checkInstrucorEPass(String currUserEmail,String currPass) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		boolean isInstructorFound=false;
		try {
			fx=dietIns.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			int x=sx.getNamedQuery("CheckInstructor").setParameter("uEmail", currUserEmail).setParameter("UPass", currPass).list().size();		
					
					if(x>0)
					{
						isInstructorFound=true;
					}
					tx.commit();
		}catch(HibernateException ex) {
			
			if(tx!=null) {
				tx.rollback();
			}
			System.err.println(ex.getMessage());
			
		}finally {
			sx.close();
			fx.close();
			
		}
		return isInstructorFound;
		
	}
}
