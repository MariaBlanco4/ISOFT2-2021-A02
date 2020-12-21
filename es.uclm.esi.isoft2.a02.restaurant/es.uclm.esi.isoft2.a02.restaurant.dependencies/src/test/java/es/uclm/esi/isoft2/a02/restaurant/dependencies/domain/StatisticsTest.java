package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class StatisticsTest {
	private static Statistics s = new Statistics();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Broker.getBroker().insert("INSERT INTO A02dbservice.Statistics(name_statistic,time) VALUES('preparation_time_meal',10.6);");
		Broker.getBroker().insert("INSERT INTO A02dbservice.Statistics(name_statistic,time) VALUES('preparation_time_meal',10.6);");
	}

	public static void tearDownAfterClass() throws Exception {
		Broker.getBroker().delete("DELETE FROM A02dbservice.Statistics WHERE id_statistics > 0;"); 
	}


	@Test
	public void testReadStatistics() throws SQLException, Exception{
		assertEquals(s.getClass(), Statistics.readStatistics().getClass());
		assertEquals(s.getClass(), Statistics.readStatistics().getClass());
		//fail("Not yet implemented");
	}

	@Test
	public void testInsertStatistics() throws SQLException, Exception {
		assertEquals(1, Statistics.insertStatistics("preparation_time_meal", 10.6));
		assertEquals(0, Statistics.insertStatistics("algoenpreparaciooooooooooooooooooooooooooooooooooooooooooooooooon",5));
		//fail("Not yet implemented");
	}


}
