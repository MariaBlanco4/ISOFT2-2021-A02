package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

/**
 * @author MariaJesus
 *
 */
public class Control_operational_tableTest {
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','10/04/2021',6,2);");	
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','11/04/2021',6,2);");
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','12/04/2021',6,2);");
	}


	@AfterClass
	public static void setUpAfterClass() throws Exception {
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='10/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='11/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Busy' AND date='12/04/2021' AND n_chairs= 6 AND waiter=2;");
	}

	@Test
	public final void testChangeState() throws Exception {
		assertEquals(true,Control_operational_table.changeState(State.valueOf(State.class, "Free"), 6, "11/04/2021", Turn.valueOf(Turn.class, "T_Lunch")));
		assertEquals(true,Control_operational_table.changeState(State.valueOf(State.class, "Busy"), 6, "12/04/2021", Turn.valueOf(Turn.class, "T_Lunch")));
		assertEquals(false,Control_operational_table.changeState(State.valueOf(State.class, "Waiting"), 6, "13/04/2021", Turn.valueOf(Turn.class, "T_Lunch")));
	}

	@Test
	public final void testDeleteReserve() throws Exception {
		assertEquals(1,Control_operational_table.deleteReserve(6,  Turn.valueOf(Turn.class, "T_Lunch"), "10/04/2021")); 
		assertEquals(0,Control_operational_table.deleteReserve(6,  Turn.valueOf(Turn.class, "T_Lunch"), "20/04/2021"));
	}
}