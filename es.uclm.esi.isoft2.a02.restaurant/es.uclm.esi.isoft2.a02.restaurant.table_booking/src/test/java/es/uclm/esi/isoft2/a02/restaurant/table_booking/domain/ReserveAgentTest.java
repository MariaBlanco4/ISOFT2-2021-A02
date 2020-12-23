/**
 * 
 */
package es.uclm.esi.isoft2.a02.restaurant.table_booking.domain;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Operational_table;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.State;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;

/**
 * @author Celia Diaz Fernández and Maria Jesús Dueñas 
 *
 */
public class ReserveAgentTest {
	
	static Operational_table ot;
	static int waiters[];

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ot = new Operational_table(1,Turn.S_Dinner,State.Asking,"01/01/2021",3,-1);
	}

	
	@Test
	public void testGenerate_reserve() throws Exception {
		assertEquals(ot, ReserveAgent.generate_reserve(State.Free, "03/10/2021", 1, Turn.F_Dinner, 2));
	}

	/**
	 * Test method for {@link es.uclm.esi.isoft2.a02.restaurant.table_booking.domain.ReserveAgent#checkReserves(es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn, java.lang.String, int)}.
	 */
	@Test
	public void testCheckReserves() throws Exception {
		assertEquals(0, ReserveAgent.checkReserves(Turn.T_Lunch, "16/04/2021", 6));
		assertEquals(1, ReserveAgent.checkReserves(Turn.F_Lunch, "04/10/2021", 2));
		assertEquals(-1, ReserveAgent.checkReserves(Turn.F_Lunch, "04/10/2021", 9));
	}

	/**
	 * Test method for {@link es.uclm.esi.isoft2.a02.restaurant.table_booking.domain.ReserveAgent#setWaiter(java.lang.String, int, es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn, int)}.
	 */
	@Test
	public void testSetWaiter() throws Exception { 
		assertEquals(-1, ReserveAgent.setWaiter(" ", 2, Turn.T_Dinner, 3));
		assertEquals(0, ReserveAgent.setWaiter("25/12/2020", 2, Turn.T_Dinner, 3));
		assertEquals(-2, ReserveAgent.setWaiter("25/12/2020", 3, Turn.F_Dinner, 3));
	}

	/**
	 * Test method for {@link es.uclm.esi.isoft2.a02.restaurant.table_booking.domain.ReserveAgent#getWaiter(java.lang.String)}.
	 */
	@Test
	public void testGetWaiter() throws Exception {
		assertEquals(waiters,ReserveAgent.getWaiter("waiter")); 
	}

}
