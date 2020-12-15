package Domain;
public class LoginAgent {

	public static boolean VerifyLogin(int id, String name, String position) {
		String sql = "";
		User user = User.readUser(sql);
		if(user == null) {
			return false;
		}
		return true;
	}

}