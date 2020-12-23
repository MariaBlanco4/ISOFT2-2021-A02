package es.uclm.esi.isoft2.a02.restaurant.table_booking.domain;


import java.sql.SQLException; 
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.User;

public class LoginAgent {

	/**
	 * 
	 * @param id
	 * @param name
	 * @param position
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static User VerifyLogin(int id, String name, String position) throws SQLException, Exception {
		return User.readUser(id, name, position);
	}

}