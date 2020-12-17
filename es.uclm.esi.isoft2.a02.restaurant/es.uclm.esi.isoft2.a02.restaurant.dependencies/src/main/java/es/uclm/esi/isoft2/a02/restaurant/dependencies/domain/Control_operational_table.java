package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.sql.SQLException;

public class Control_operational_table {
	public static boolean changeState(State new_state, int n_table, String date, Turn turn) throws Exception{
		Operational_table opt = Operational_table.read(n_table, date, turn);
		boolean result;
		if (opt==null) {
			result = false;
		} else {
			if (new_state.equals(State.Free)) {
				opt.delete(n_table, turn, date);
				result = true;
			} else { 
				opt.setState(new_state);
				opt.updateS(n_table, date, turn, new_state);
				result = true;
			}
		}
		return result;
	}
	
	public static int deleteReserve(int n_table, Turn turn, String date) throws Exception {
		return Operational_table.delete(n_table, turn, date);
	}
	
}