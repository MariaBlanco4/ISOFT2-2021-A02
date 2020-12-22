package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class OrderTest {
	
	private static Order order0;
	private static String drinks0 [];
	private static String starters0 [];
	private static String firstCourses0 [];
	private static String secondCourses0 [];
	private static String desserts0 [];
	
	private static Order order1;
	private static String drinks1 [];
	private static String starters1 [];
	private static String firstCourses1 [];
	private static String secondCourses1 [];
	private static String desserts1 [];

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		order0 = new Order(6, "16/04/2024");
		drinks0 = new String[6];
		drinks0[0] = "dfsaaaaa";
		starters0 = new String[6];
		firstCourses0 = new String[6];
		firstCourses0[0] = "fasdfsa";
		secondCourses0 = new String[6];
		desserts0 = new String[6];
		
		order1 = new Order(6, "16/04/2024");
		drinks1 = new String[6];
		drinks1[0] = "dfsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		starters1 = new String[6];
		firstCourses1 = new String[6];
		secondCourses1 = new String[6];
		desserts1 = new String[6];

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Broker.getBroker().delete("TRUNCATE TABLE A02dbservice.Order;");
	}

	@Test
	public void testInsertOrder() throws Exception {
		assertEquals(1, order0.insertOrder(drinks0, starters0, firstCourses0, secondCourses0, desserts0, order0.getId_operational_table(), order0.getDate()));
		assertEquals(0, order0.insertOrder(drinks1, starters1, firstCourses1, secondCourses1, desserts1, order1.getId_operational_table(), order1.getDate()));
	}

	
}
