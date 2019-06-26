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
	
	public boolean checkUEPass(String currUserEmail,String currPass) {
		
		SessionFactory fx=null;
		Session sx=null;
		Transaction tx=null;
		boolean isUserFound=false;
		try {
			fx=dietIns.getFactory();
			sx=fx.openSession();
			tx=sx.beginTransaction();
//			String sql="SELECT * FROM User u where u.userEmail=:uEmail and u.userPassword=:UPass";
//			int x=sx.createQuery(sql).list().size();
//			((javax.persistence.Query) sx).setParameter("uEmail", currUserEmail);
//			((javax.persistence.Query) sx).setParameter("UPass", currPass);
			//getPassQuery.executeUpdate().c;
			//String sql="SELECT u FROM User u where u.userEmail=:uEmail and u.userPassword=:UPass";
			//Query query=sx.createQuery(sql);
			int x=sx.getNamedQuery("CheckUser").setParameter("uEmail", currUserEmail).setParameter("UPass", currPass).getMaxResults();
//			query.setParameter("uEmail", currUserEmail);
//			query.setParameter("UPass", currPass);
//			int x=query.list().size();
			
				if(x>0)
				{
					System.out.println("Entering .........................");
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
}
