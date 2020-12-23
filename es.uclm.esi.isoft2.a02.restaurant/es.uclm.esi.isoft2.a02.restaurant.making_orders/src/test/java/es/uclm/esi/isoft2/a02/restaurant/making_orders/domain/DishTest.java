package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import es.uclm.esi.isoft2.a02.restaurant.making_orders.domain.Dish;

public class DishTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testReadDish() throws Exception {
		assertEquals(Dish.class, Dish.readDish("carrot_cream").getClass());
		assertEquals(null, Dish.readDish("jose"));
	}

}
