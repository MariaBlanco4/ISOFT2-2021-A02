package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class UserTest {
	
	static User userArray[];
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userArray = new User[2];
	}
	
	
	@Test
	public final void testReadPosition() throws Exception, Exception {
		assertEquals(userArray.getClass(),User.readPosition("waiter").getClass());
	}

	@Test
	public final void testReadUser() throws SQLException, Exception {
		assertEquals(User.class, User.readUser(1, "jose", "waiter").getClass());
		assertEquals(null, User.readUser(1, "marco", "waiter"));
	}

	@Test
	public final void testRead() throws SQLException, Exception {
		assertEquals(User.class, User.read(1).getClass());
		assertEquals(null, User.read(18));
	}
}