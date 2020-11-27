package Domain;
public class Reserve {

	private int reserve_id;
	private int table_booking;
	private String date;
	private Turn turn;
	private String reserve_hour;

	
	/**
	 * 
	 * @param reserve_id
	 * @param reserve_hour
	 * @param turn
	 */
	public Reserve(int reserve_id, int table_booking, String date, Turn turn, String reserve_hour) {
		this.reserve_id = reserve_id;
		this.table_booking = table_booking;
		this.date = date;
		this.turn = turn;
		this.reserve_hour = reserve_hour;
		
		throw new UnsupportedOperationException();
	}
	
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
	public static Reserve[] read(String sql) {
		// TODO - implement Reserve.read
		throw new UnsupportedOperationException();
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
		return this.reserve_hour;
	}

	/**
	 * 
	 * @param hour
	 */
	public void setReserveHour(String reserve_hour) {
		this.reserve_hour = reserve_hour;
	}

}