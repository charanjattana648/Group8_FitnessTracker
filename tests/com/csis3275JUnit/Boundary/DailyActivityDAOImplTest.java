package com.csis3275JUnit.Boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author harpreet kaur
 *
 */

import com.csis3275.Boundary.DailyActivityDAOImpl;
import com.csis3275.Boundary.DietDAOImpl;
import com.csis3275.Entities.DailyActivity;
import com.csis3275.Entities.Diet;
/**
 * 
 * @author harpreet Kaur
 * student id :300288768
 * 
 * Testing DailyActivityDAOImpl class
 */

class DailyActivityDAOImplTest {
    
DietDAOImpl dI;
DailyActivity d;
DailyActivityDAOImpl dImp;
SessionFactory factory = null;

@BeforeEach
void setUp() throws Exception {
dI=new DietDAOImpl();
d=new DailyActivity();
dImp=new DailyActivityDAOImpl();
factory=dI.getFactory();
}

@Test
void test_Session_factory() {	
assertNotNull(dI);
assertNotNull(factory, "factory should be null");
}

/**
* setting value  all attributes 
*/

public void addDailyActivity() {
d.setId(5);
d.setDate("07/21/2019");
d.setUserEmail("hkpk@gmail.com");
d.setSleepHour(6);
d.setSleepMinute(35);
d.setWaterGlass(3);
d.setExerciseHour(6);
d.setExerciseMinute(45);
d.setMeditationHour(2);
d.setMeditationMinute(23);
d.setWalkingHour(3);
d.setWalkingMinute(20);
d.setExtraCalories(0);
d.setExtraProtein(0);
d.setExtraFat(0);
d.setWorkType("Heavy");
d.setWorkHour(3);
d.setWorkMinute(45);
}
    
/**
* testing daily Activity data is added
*/
@Test
void testDailyActivityAdd() {
addDailyActivity();
int record=dImp.addDailyActivities(d);
assertNotNull(dImp);
assertNotNull(d);
assertNotNull(record);
assertNotEquals(0, record);
}
/**
* testing ,getting list of DailyActivities by User Email and Date
*/
@Test
void testgetDailyActivity() {
String expectedDate="07/23/2019";
String expectedUserEmail="user@gmail.com";
ArrayList<DailyActivity> daList = new ArrayList<DailyActivity>();
daList=dImp.getDailyActivities(expectedDate, expectedUserEmail);
assertNotNull(daList);
assertEquals(expectedUserEmail, daList.get(0).getUserEmail());

}

/**
* testing ,getting list of DailyActivities by User Email only
*/

@Test
void testgetDailyActivityList() {

String expectedUserEmail="user@gmail.com";
ArrayList<DailyActivity> daList = new ArrayList<DailyActivity>();
daList=dImp.getDailyActivitiesList(expectedUserEmail);
assertNotNull(daList);
assertFalse(daList.isEmpty());
}

}