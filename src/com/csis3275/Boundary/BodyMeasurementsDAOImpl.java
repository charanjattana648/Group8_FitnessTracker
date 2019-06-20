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

public class BodyMeasurementsDAOImpl {
	
	public static SessionFactory getFactory() {
		
		SessionFactory factory = null;
		Metadata meta = null;
		StandardServiceRegistry ssr = null;
		
		try {
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			factory = meta.getSessionFactoryBuilder().build();
		}
		catch(Throwable ex) {
			System.err.println("Error: " + ex.getMessage());
		}

		return factory;
	}
	
	public int createBodydata(BodyMeasurements body) {
		
		int newBodyId = 0;
		
		SessionFactory sf = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sf = getFactory();
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
	
	@SuppressWarnings("unchecked")
	public List<BodyMeasurements> getBodyData(){
		
		Session session = null;
		Transaction transaction = null;
		SessionFactory factory = null;
		
		List<BodyMeasurements> userBodyList = null;
		
		try {
			factory = getFactory();
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
