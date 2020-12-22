package es.uclm.esi.isoft2.a02.restaurant.statistics.domain;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class Control_statisticsTest {

	private double [] result = new double[4];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Broker.getBroker().insert("INSERT INTO Statistics (name_statistic, time) VALUES ('take_command', 12);");
		Broker.getBroker().insert("INSERT INTO Statistics (name_statistic, time) VALUES ('take_command', 18);");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Broker.getBroker().delete("DELETE FROM Statistics WHERE name_statistic = 'take_command' AND time = 12");
		//Broker.getBroker().delete("DELETE FROM Statistics WHERE name_statistic = 'take_command' AND time = 18");
	}

	@Test
	public void testGetStatistics() throws Exception {
		assertEquals(result.getClass(), Control_statistics.getStatistics().getClass());
		
		Broker.getBroker().delete("DELETE FROM Statistics WHERE name_statistic = 'take_command' AND time = 12");
		Broker.getBroker().delete("DELETE FROM Statistics WHERE name_statistic = 'take_command' AND time = 18");
		assertEquals(result.getClass(), Control_statistics.getStatistics().getClass());
	}

}
