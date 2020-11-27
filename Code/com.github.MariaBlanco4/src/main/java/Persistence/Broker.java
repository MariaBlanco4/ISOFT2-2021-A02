package Persistence;
public class Broker {

	protected static Broker mInstance = null;
	protected connection mDB;

	protected Broker() {
		// TODO - implement Broker.Broker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param SQL
	 */
	public static Vector<Vector<Object>> read(String SQL) {
		// TODO - implement Broker.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param SGLQ
	 */
	public static int insert(String SGLQ) {
		// TODO - implement Broker.insert
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param SGLQ
	 */
	public static int delete(String SGLQ) {
		// TODO - implement Broker.delete
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param SQLG
	 */
	public static int update(String SQLG) {
		// TODO - implement Broker.update
		throw new UnsupportedOperationException();
	}

}