public class Notification {

	private int origin;
	private String message;
	private int destination;
	private int id;

	public String getMessage() {
		return this.message;
	}

	/**
	 * 
	 * @param sql
	 */
	public Notification readNotification(String sql) {
		// TODO - implement Notification.readNotification
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public int insertNotification(String sql) {
		// TODO - implement Notification.insertNotification
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public int deleteNotification(String sql) {
		// TODO - implement Notification.deleteNotification
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

}