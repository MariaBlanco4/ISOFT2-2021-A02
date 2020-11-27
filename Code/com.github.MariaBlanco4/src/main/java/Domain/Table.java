package Domain;
public class Table {

	private static int MAX_TABLES = 10;
	private int id_table;
	private State state;
	private int n_chairs;
	private int waiter;
	private String date;

	
	
	/**
	 * 
	 * @param reserve_id
	 * @param reserve_hour
	 * @param turn
	 */
	public Table(int id_table, State state, int n_chairs, int waiter, String date) {
		this.id_table = id_table;
		this.state = state;
		this.n_chairs = n_chairs;
		this.waiter = waiter;
		this.date = date;
		throw new UnsupportedOperationException();
	}
	
	
	public int getId_table() {
		return this.id_table;
	}

	/**
	 * 
	 * @param id_table
	 */
	public void setId_table(int id_table) {
		this.id_table = id_table;
	}

	public State getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(State state) {
		this.state = state;
	}

	public int getN_chairs() {
		return this.n_chairs;
	}

	/**
	 * 
	 * @param n_chairs
	 */
	public void setN_chairs(int n_chairs) {
		this.n_chairs = n_chairs;
	}

	public int getWaiter() {
		return this.waiter;
	}

	/**
	 * 
	 * @param waiter
	 */
	public void setWaiter(int waiter) {
		this.waiter = waiter;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param Date
	 */
	public void setDate(String date) {
		this.date = date;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public Table readWaiter(String sql) {
		// TODO - implement Table.readWaiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public static Table readState(String sql) {
		// TODO - implement Table.readState
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public static int insertTable(String sql) {
		// TODO - implement Table.insertTable
		throw new UnsupportedOperationException();
	}

}