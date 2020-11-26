public class Reserve {

	private int reserve_id;
	private int table_booking;
	private String Date;
	private Turn turn;
	private String hour;

	/**
	 * 
	 * @param sql
	 */
	public int insert(String sql) {
		// TODO - implement Reserve.insert
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sql
	 */
	public Reserve[] read(String sql) {
		// TODO - implement Reserve.read
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reserve_id
	 * @param reserve_hour
	 * @param turn
	 */
	public Reserve(int reserve_id, String reserve_hour, Turn turn) {
		// TODO - implement Reserve.Reserve
		throw new UnsupportedOperationException();
	}

	public String getDate() {
		// TODO - implement Reserve.getDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Date
	 */
	public void setDate(String Date) {
		// TODO - implement Reserve.setDate
		throw new UnsupportedOperationException();
	}

	public int getReserve_id() {
		return this.reserve_id;
	}

	/**
	 * 
	 * @param reserve_id
	 */
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}

	public int getTable_booking() {
		return this.table_booking;
	}

	/**
	 * 
	 * @param table_booking
	 */
	public void setTable_booking(int table_booking) {
		this.table_booking = table_booking;
	}

	public Turn getTurn() {
		return this.turn;
	}

	/**
	 * 
	 * @param turn
	 */
	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public String getHour() {
		return this.hour;
	}

	/**
	 * 
	 * @param hour
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

}