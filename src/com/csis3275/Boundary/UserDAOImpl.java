package com.csis3275.Boundary;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csis3275.Entities.Admin;
import com.csis3275.Entities.User;

/**
 * 
 * @author Harpreet Kaur
 * student id 300288768
 *
 */
public class UserDAOImpl {
	
	DietDAOImpl dietIns=new DietDAOImpl();

	/**
	 * Create User
	 * @param u New User 
	 * @return newUser currently added new user's Email.
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
	
	/**
	 * create instructor
	 * @param u New instructor
	 * @return newInstructor currently added new Instructor's Email
	 */
	
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
	/**
	 * to validate the user
	 * @param currUserEmail it matches the current  Email with the Email saved in database.
	 * @param currPass it matches the current Password with the password saved in database.
	 * @return isUserFound the boolean value whether user with same email and password is found or not.
	 */
	
	public boolean checkUEPass(String currUserEmail,String currPass) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		boolean isUserFound=false;
		try {
			fx=dietIns.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
			
			ArrayList<User> userList=(ArrayList<User>) sx.getNamedQuery("CheckUser").setParameter("uEmail", currUserEmail).setParameter("UPass", currPass).list();
					int x=userList.size();		
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
	
	/**
	 * to validate instructor
	 * @param currUserEmail it matches the current instructor Email with the Email saved in database.
	 * @param currPass it matches the instructor's current Password with the password saved in database.
	 * @return isInstructorFound the boolean value whether user with same email and password is found or not.
	 */
	
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

/**
 * method to create admin account as there is only one Admin so we set Admin_id,Admin_Name and Admin_Passsword manually.
 * 
 */
public void admin()
{

	SessionFactory fx=null;
	Session sx=null;
	Transaction tx=null;
	try {
		fx=dietIns.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();
		Admin a=new Admin();
		a.setAdminid("admin");
		a.setAdminName("admin");
		a.setAdminPassword("root");
		sx.save(a);
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
	
}

/**
 * to validate Admin's id and password
 * @param currUserEmail check current admin'id with id saved in Table Admin
 * @param currPass   check current admin password with password saved in Table Admin
 * @return isAdminFound  the boolean value whether Admin with same email and password is found or not.
 */
public boolean checkAdminEPass(String currUserEmail,String currPass) {
	
	SessionFactory fx=null;
	Session sx=null;
	Transaction tx=null;
	boolean isAdminFound=false;
	try {
		fx=dietIns.getFactory();
		sx=fx.openSession();
		tx=sx.beginTransaction();
		int x=sx.getNamedQuery("CheckAdmin").setParameter("adminid", currUserEmail).setParameter("adminPassword", currPass).list().size();		
				
				if(x>0)
				{
					isAdminFound=true;
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
	return isAdminFound;
	
}
}
