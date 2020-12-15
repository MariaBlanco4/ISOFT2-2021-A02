package DomainDependencies;

public class Control_operational_table {
	public static boolean changeState(State new_state, int n_table, String date, Turn turn) throws Exception{
		Operational_table opt = Operational_table.read(n_table, date, turn);
		if (opt==null) {
			return false;
		} else {
			if (new_state.equals(State.Free)) {
				opt.delete(n_table, turn, date);
				return true;
			} else { 
				opt.setState(new_state);
				opt.updateS(n_table, date, turn, new_state);
				return true;
			}
		}
	}
	
	public static int deleteReserve(int n_table, Turn turn, String date) throws Exception {
		return Operational_table.delete(n_table, turn, date);
	}
	
}