package com.csis3275.Boundary;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.csis3275.Entities.BodyMeasurements;

/**
 * BodyMeasurementsDAOImpl class
 * @author Gurinder Singh 300289450
 *
 */
public class BodyMeasurementsDAOImpl implements IBodyMeasurementsDAO {
	
	@Override
	public int createBodydata(BodyMeasurements body) {
		
		int newBodyId = 0;
		
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sf = DietDAOImpl.getFactory();
			session = sf.openSession();
			transaction = session.beginTransaction();
			
			newBodyId = (int) session.save(body);
			transaction.commit();
		}
		catch(HibernateException hx) {
			if(transaction != null) {
				transaction.rollback();
				System.err.println("Error: " + hx.getMessage());
			}
		}
		finally {
			sf.close();
			session.close();
		}
		return newBodyId;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<BodyMeasurements> getBodyDataList(){
		
		Session session = null;
		Transaction transaction = null;
		SessionFactory factory = null;
		
		List<BodyMeasurements> userBodyList = null;
		
		try {
			factory = DietDAOImpl.getFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			userBodyList = session.getNamedQuery("getBodyDataList").list();			
			transaction.commit();
			
			for(BodyMeasurements b : userBodyList) {
				b.getId();
				b.getUnit();
				b.getWeight();
				b.getHeightCm();
			}			
			
		}
		catch(HibernateException hx) {
			if(transaction != null) {
				transaction.rollback();
				System.err.println("Error: " + hx.getMessage());
			}
		}
		finally {
			factory.close();
			session.close();
		}
		return userBodyList;
	}

	@Override
	public BodyMeasurements getBodyData(int id) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		BodyMeasurements b = new BodyMeasurements();
		try {
			fx = DietDAOImpl.getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			b = (BodyMeasurements) sx.get(BodyMeasurements.class, id);
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

		return b;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<BodyMeasurements> getBodyDatabyEmail(String userEmail) {
		SessionFactory fx = null;
		Session sx = null;
		Transaction tx = null;
		ArrayList<BodyMeasurements> bList=new ArrayList<BodyMeasurements>();
		BodyMeasurements b;
		try {
			fx = DietDAOImpl.getFactory();
			sx = fx.openSession();
			tx = sx.beginTransaction();
			bList = (ArrayList<BodyMeasurements>) sx.getNamedQuery("getBodyDatabyEmail").setParameter("userEmail", userEmail).list();
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

		return bList;
	}
	
}
