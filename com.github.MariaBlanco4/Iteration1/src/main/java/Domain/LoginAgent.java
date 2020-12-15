package Domain;

import java.sql.SQLException;

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