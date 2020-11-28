package Domain;
public class ReserveAgent {

	/**
	 * 
	 * @param turn
	 * @param n_chairs
	 * @param reserved_hour
	 * @param Date
	 * @param table_booking
	 * @param hour
	 */
	public static boolean generate_reserve(Turn turn, int n_chairs, String reserved_hour, String date, int table_booking, String hour) {
		//String sql = "";
		//Table.insertTable(sql);
		//Table table = Table.read
		throw new UnsupportedOperationException();
		//int reserve_id, int table_booking, String date, Turn turn, String reserve_hour
		
	}

	/**
	 * 
	 * @param turn
	 * @param Date
	 * @param n_charis
	 * @param hour
	 */
	public static Reserve[] checkReserves(Turn turn, String date, int n_charis, String hour) {
		String sql = "";
		Reserve [] reserve = Reserve.read(sql);
		if(reserve == null) {
			return null;
		}
		return reserve;
	}

	/**
	 * 
	 * @param id_table
	 * @param state
	 */
	public static boolean changeState(int id_table, State state) {
		String sql = "";
		Table table = Table.readState(sql);
		if(table == null) {
			return false;
		}
		table.setState(state);
		return true;
		
	}

	/**
	 * 
	 * @param id_table
	 * @param waiter
	 */
	public static boolean setWaiter(int id_table, int waiter) {
		String sql = ""; 
		Table t = Table.readWaiter(sql);
		if (t == null) {
			return false;
		}
		t.setWaiter(waiter);
		return true;
	}

	/**
	 * 
	 * @param position
	 */
	public static String[] getWaiter(String position) {
		String sql = "";
		User [] user = User.readPosition(sql);
		if (user==null) {
			return null;
		}
		return user;
	}

}
