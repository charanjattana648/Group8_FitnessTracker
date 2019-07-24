package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Boundary.BodyMeasurementsDAOImpl;
import com.csis3275.Entities.BodyMeasurements;

class BodyMeasurementsDAOImplTest {
	
	BodyMeasurementsDAOImpl bodyDao;
	BodyMeasurements body;
	
	StandardServiceRegistry ssr = null;
	Metadata meta = null;
	SessionFactory factory = null;
	Session sx = null;
	Transaction tx = null;
	int newId;
	
	@BeforeEach
	void setUp() throws Exception {
		body = new BodyMeasurements();
		bodyDao = new BodyMeasurementsDAOImpl();
		try {
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			factory = meta.getSessionFactoryBuilder().build();
		} catch (Throwable e) {
			System.err.println("Error : " + e.getMessage());
		}
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
