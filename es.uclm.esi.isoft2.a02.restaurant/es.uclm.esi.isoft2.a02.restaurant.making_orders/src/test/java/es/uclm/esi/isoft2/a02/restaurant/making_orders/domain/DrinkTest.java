package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;
import es.uclm.esi.isoft2.a02.restaurant.making_orders.domain.Drink;

public class DrinkTest {

	static Drink dr0;
	static Drink dr1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dr0 = new Drink("cola", 2, 10);
		dr1 = new Drink("fanta", 2, 0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Broker.getBroker().update("UPDATE A02dbservice.Drink SET amount = 10 WHERE name = 'cola'");
		
	}

	@Test
	public void testReadDrink() throws SQLException, Exception {
		 assertEquals(Drink.class, Drink.readDrink("cola").getClass());
		 assertEquals(null, Drink.readDrink("jose"));
	}

	@Test
	public void testCheckAmountDrink() {
		assertEquals(true, dr0.checkAmountDrink());
		assertEquals(false, dr1.checkAmountDrink());
	}

	@Test
	public void testUpdateDrink() throws SQLException, Exception {
		assertEquals(1, dr0.updateDrink(dr0.getName(), 5));
		assertEquals(0, dr1.updateDrink("jose", 5));
	}

}
