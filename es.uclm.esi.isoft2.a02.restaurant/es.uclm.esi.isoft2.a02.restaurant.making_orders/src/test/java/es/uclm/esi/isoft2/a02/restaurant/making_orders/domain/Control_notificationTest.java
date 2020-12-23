package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class Control_notificationTest {
	
	@Test
	public void testNotifyStringIntInt() throws SQLException, Exception {
		assertEquals(true, Control_notification.notify("Plato mesa x listo", 1, 2));
		assertEquals(false, Control_notification.notify("Plato mesa y listo", 3, 15));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Broker.delete("TRUNCATE TABLE Notification");
	}
}
