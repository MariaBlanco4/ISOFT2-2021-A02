package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;


import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class Operational_tableTest {
	static Operational_table operationalTable;
	static Operational_table operationalTable1;
	static Operational_table operationalTable2;
	static Operational_table operationalTable3;
	static Operational_table operationalTable4;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		operationalTable= new Operational_table(0, null, null, null, 0);
		operationalTable1= new Operational_table(0, null, null, null, 0);
		operationalTable2= new Operational_table(0, null, null, null, 0);
		operationalTable3= new Operational_table(0, null, null, null, 0);
		operationalTable4= new Operational_table(0, null, null, null, 0);
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','18/04/2021',6,2);");	
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','19/04/2021',6,2);");
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','21/04/2021',6,2);");
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','16/04/2021',6,2);");
		Broker.getBroker().insert("INSERT INTO A02dbservice.Operational_table VALUES (6,'T_Lunch', 'Reserved','17/04/2021',6,2);");
	}


	@AfterClass
	public static void setUpAfterClass() throws Exception {
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='18/04/2021' AND n_chairs= 6 AND waiter=1;");	
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Busy' AND date='19/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='21/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='16/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='17/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='18/04/2021' AND n_chairs= 6 AND waiter=2;");	
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='19/04/2021' AND n_chairs= 6 AND waiter=2;");
		Broker.getBroker().delete("DELETE FROM A02dbservice.Operational_table WHERE n_table=6 AND turn='T_Lunch' AND state='Reserved' AND date='25/04/2021' AND n_chairs= 6 AND waiter=0;");
	}
	
	
	

	@Test
	public final void testInsertTable() throws Exception {
		assertEquals(1,operationalTable.insertTable(Turn.T_Lunch,6,State.Reserved,"25/04/2021",6));
		assertEquals(0,operationalTable.insertTable(Turn.valueOf(Turn.class, "T_Lunch"),6,State.valueOf(State.class, "Reserved"),"16/04/2021",6));
		
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testRead() throws Exception {
		assertEquals(Operational_table.class,operationalTable4.readWaiter("21/04/2021",6,  Turn.valueOf(Turn.class, "T_Lunch"), 2).getClass());
		assertEquals(null,operationalTable4.readWaiter("20/04/2021",6,  Turn.valueOf(Turn.class, "T_Lunch"), 2));
		
		
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testDelete() throws Exception {
		assertEquals(1,operationalTable1.delete(6, Turn.valueOf(Turn.class, "T_Lunch"), "17/04/2021"));
		assertEquals(0,operationalTable1.delete(6, Turn.valueOf(Turn.class, "T_Lunch"), "20/04/2021"));
		
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdateW() throws Exception {
		assertEquals(1,operationalTable2.updateW(6, "18/04/2021", Turn.valueOf(Turn.class, "T_Lunch"), 1));
		assertEquals(0,operationalTable2.updateW(6, "20/04/2021", Turn.valueOf(Turn.class, "T_Lunch"), 1));
		
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdateS() throws Exception {
		assertEquals(1,operationalTable2.updateS(6, "19/04/2021", Turn.valueOf(Turn.class, "T_Lunch"), State.valueOf(State.class, "Busy")));
		assertEquals(0,operationalTable2.updateS(6, "20/04/2021", Turn.valueOf(Turn.class, "T_Lunch"), State.valueOf(State.class, "Busy")));
		
		//fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testReadWaiter() throws Exception {
		assertEquals(Operational_table.class,operationalTable3.readWaiter("21/04/2021",6,  Turn.valueOf(Turn.class, "T_Lunch"), 2).getClass());
		assertEquals(null,operationalTable3.readWaiter("20/04/2021",6,  Turn.valueOf(Turn.class, "T_Lunch"), 2));
		
		
		//fail("Not yet implemented"); // TODO
	}

}