package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;
import es.uclm.esi.isoft2.a02.restaurant.making_orders.domain.Ingredient;

public class IngredientTest {

	private static Ingredient ing0;
	private static Ingredient ing1;
	private static Ingredient ing2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ing0 = new Ingredient("bread", 3000, 500);
		ing1 = new Ingredient("butter", 0, 500);
		ing2 = new Ingredient("jose", 0, 500);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Broker.getBroker().update("UPDATE A02dbservice.Ingredient SET amount = 10 WHERE name = 'bread'");
	}

	@Test
	public void testReadIngredient() throws Exception {
		assertEquals(Ingredient.class, Ingredient.readIngredient("bread").getClass());
		assertEquals(null, Ingredient.readIngredient("jose"));
	}

	@Test
	public void testUpdateIngredient() throws Exception {
		assertEquals(1, ing0.updateIngredient(ing0.getName(), 4));
		assertEquals(0, ing2.updateIngredient(ing2.getName(), 5));
	}

	@Test
	public void testCheckAmountIngredient() {
		assertEquals(true, ing0.checkAmountIngredient());
		assertEquals(false, ing1.checkAmountIngredient());
	}


}
