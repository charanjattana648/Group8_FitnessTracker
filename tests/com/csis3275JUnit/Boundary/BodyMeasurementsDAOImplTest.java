package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	void test_Session_factory() {	
		
		assertAll("heading",
				()->assertNotNull(ssr, "StandardServiceRegistry is null"),
				()->assertNotNull(meta, "meta is null"),
				()->assertNotNull(factory, "factory is null"));
		if(sx!=null)
		{
		sx.close();
		}
		factory.close();
	}

	@Test
	void testCreateBodyData() {
		
		bodyData();
		int bodyId = bodyDao.createBodydata(body);
		assertNotEquals(0, bodyId);
		
	}
	
	@Test
	void testGetBodyList()
	{
		List<BodyMeasurements> bodyList = new ArrayList<BodyMeasurements>();
		bodyList = bodyDao.getBodyDataList();
		assertNotNull(bodyList);
		assertFalse(bodyList.isEmpty());
	}
	
	@Test
	void testGetBody()
	{
		int id = 116;
	    body = bodyDao.getBodyData(id);
		assertNotNull(body);
	    assertEquals(id, body.getId());
	
	}
	
	public void bodyData() {
		body.setUserEmail("guri@gmail.com");
		body.setUnit("Metric");
		body.setHeightFeets(0);
		body.setHeightInches(0);
		body.setHeightCm(168);
		body.setHeightType("cm");
		body.setWeight(77);
		body.setWeightType("kg");
		
		double heightInMeters = body.getHeightCm() / (double) 100;
		
		double bmiValues = body.getWeight() / (heightInMeters * heightInMeters);
		
		body.setBmiValues(bmiValues);
		body.setHealthProblem("Diabetes");
		body.setFitnessPlanType("Weight Loss Plan");
		body.setUserGoalType("Loose 0.3 LB");
	}

}
