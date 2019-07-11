package com.csis3275.Boundary;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.csis3275.Entities.BodyMeasurements;

/**
 * BodyMeasurementsDAOImpl class
 * @author Gurinder Singh 300289450
 *
 */
public class BodyMeasurementsDAOImpl implements BodyMeasurementsDAO {
	
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
	public List<BodyMeasurements> getBodyData(){
		
		Session session = null;
		Transaction transaction = null;
		SessionFactory factory = null;
		
		List<BodyMeasurements> userBodyList = null;
		
		try {
			factory = DietDAOImpl.getFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			String sql = "SELECT d FROM BodyMeasurements d";
			userBodyList = session.createQuery(sql).list();
			
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
	

}
