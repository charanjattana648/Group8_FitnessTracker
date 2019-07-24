
package com.csis3275JUnit.Entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.Entities.DailyActivity;

class DailyActivityTest {
	
	DailyActivity da;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		da=new DailyActivity();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testid() {
		
		int expectedid=1;
		
		da.setId(1);
		assertEquals(expectedid, da.getId());
		
	}
	
	@Test
	void testdate() {
		
		String expecteddate="06/27/2019";
		
		da.setDate("06/27/2019");
		assertEquals(expecteddate, da.getDate());
		
	}
	
	@Test
	void testuserEmail() {
		String expectedEmail="hk@gmail.com";
		
		da.setUserEmail("hk@gmail.com");
		assertEquals(expectedEmail, da.getUserEmail());
		
	}
	

}
