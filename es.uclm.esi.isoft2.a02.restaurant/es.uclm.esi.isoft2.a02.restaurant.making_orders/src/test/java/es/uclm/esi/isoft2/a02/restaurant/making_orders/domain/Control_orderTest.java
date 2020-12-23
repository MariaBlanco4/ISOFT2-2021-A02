package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class Control_orderTest {
	
	static String [] dish0 = new String[6];
	static String [] dish1 = new String[6];
	static String [] dish2 = new String[6];
	static String [] drink = new String[6];
	static String [] drink1 = new String[6];

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6, 'T_Lunch', 'Asking', '16/04/2021', 6, 1);");
		
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6, 'T_Lunch', 'Asking', '17/04/2021', 6, 1);");
		Broker.getBroker().update("UPDATE Ingredient SET amount=0 WHERE name='chorizo';");

		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6, 'T_Lunch', 'Asking', '18/04/2021', 6, 1);");
		
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6, 'T_Lunch', 'Asking', '19/04/2021', 6, 1);");
		Broker.getBroker().update("UPDATE Drink SET amount=0 WHERE name='fanta';");
		
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6, 'T_Lunch', 'Paying', '20/04/2021', 6, 1);");
		
		dish0[0] = "tortilla";
		dish0[1] = "carrot_cream";
		dish0[2] = "oreo_shake";
		dish1[0] = "variety_cold_cuts";
		dish2[0] = "macarrones con queso";
		drink[0] = "cola";
		drink1[0] =  "fanta";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Broker.delete("TRUNCATE TABLE A02dbservice.Order");
		Broker.delete("TRUNCATE TABLE Operational_table");
		Broker.getBroker().update("UPDATE Drink SET amount=10 WHERE name='cola';");
		Broker.getBroker().update("UPDATE Drink SET amount=10 WHERE name='fanta';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='chorizo';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='onion';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='oreo';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='egg';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='salt';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='sugar';");
		Broker.getBroker().update("UPDATE Ingredient SET amount=10 WHERE name='ice_cream';");
	}

	@Test
	public void testCheckOrder() throws SQLException, Exception {
		assertEquals(0, Control_order.checkOrder(6, "16/04/2021", Turn.T_Lunch, drink, dish0));
		assertEquals(-1, Control_order.checkOrder(6, "17/04/2021", Turn.T_Lunch, drink, dish1));
		assertEquals(-1, Control_order.checkOrder(6, "18/04/2021", Turn.T_Lunch, drink, dish2));
		assertEquals(-1, Control_order.checkOrder(6, "19/04/2021", Turn.T_Lunch, drink1, dish2));
		assertEquals(-1, Control_order.checkOrder(6, "20/04/2021", Turn.T_Lunch, drink1, dish2));
		assertEquals(-1, Control_order.checkOrder(10, "20/04/2021", Turn.T_Lunch, drink1, dish2));
		
	}

}
