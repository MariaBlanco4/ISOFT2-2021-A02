package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class UserTest {
	
	User u[];
	User uaux;

	@Test
	public void testReadPosition() throws SQLException, Exception {
		assertEquals(u,User.readPosition("cooker"));
	}

	@Test
	public void testReadUser() throws SQLException, Exception {
		assertEquals(uaux,User.readUser(1, "jose", "waiter"));
	}

	@Test
	public void testRead() throws SQLException, Exception {
		assertEquals(uaux,User.read(2));
	}

}
