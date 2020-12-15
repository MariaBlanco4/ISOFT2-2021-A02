package Domain;
public class User {

	private int id;
	private String name;
	private String position;

	
	/**
	 * 
	 * @param TimeToCount
	 */
	public User(int id, String name, String position) {
		this.id = id;
		this.name = name;
		this.position = position;
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * 
	 * @param sql
	 */
	public User[] readPosition(String sql) {
		// TODO - implement User.readPosition
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public static User readUser(String sql) {
		// TODO - implement User.readUser
		throw new UnsupportedOperationException();
	}

}