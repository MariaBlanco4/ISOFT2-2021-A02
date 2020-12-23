package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class NotificationTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Broker.getBroker().insert("INSERT INTO Notification (message, origin, destination) VALUES ('Dish for table 1 is ready.', 1, 5);");
		Broker.getBroker().insert("INSERT INTO Notification (message, origin, destination) VALUES ('Dish for table 2 is ready.', 1, 2);");
	}
	
	@Test
	public void testInsertNotification() throws SQLException, Exception {
		assertEquals(1, Notification.insertNotification("Dish for table 1 is ready.", 1, 2));
		assertEquals(0, Notification.insertNotification("Dish for table 2 is ready aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.", 20, 20));
	}

	@Test
	public void testReadNotification() throws SQLException, Exception {
		assertEquals(Notification[].class, Notification.readNotification(2).getClass());
		assertEquals(Notification[].class, Notification.readNotification(20).getClass());
	}
	
	@Test
	public void testDeleteNotification() throws SQLException, Exception {
		Notification nt = Notification.readNotification(5)[0];
		assertEquals(1, Notification.deleteNotification(nt.getId_notification()));
		assertEquals(0, Notification.deleteNotification(20));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Broker.delete("TRUNCATE TABLE Notification");
	}

}
