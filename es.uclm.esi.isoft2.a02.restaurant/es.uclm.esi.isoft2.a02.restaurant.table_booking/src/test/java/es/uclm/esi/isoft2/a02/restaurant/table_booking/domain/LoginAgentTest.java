package es.uclm.esi.isoft2.a02.restaurant.table_booking.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.User;

public class LoginAgentTest {
	

/**
 * @author Celia Diaz Fernández and Maria Jesús Dueñas Recuero
 *
 */

	static User u; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		u = new User (1,"jose","waiter");
	}

	@Test
	public void testVerifyLogin() throws Exception {
		assertEquals(u, LoginAgent.VerifyLogin(1,"jose","waiter"));
		assertEquals(null, LoginAgent.VerifyLogin(1,"marcos","waiter"));
	}

}
