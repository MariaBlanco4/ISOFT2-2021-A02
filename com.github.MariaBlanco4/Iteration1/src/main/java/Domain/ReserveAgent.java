package Domain;

import DomainDependencies.Operational_table;
import DomainDependencies.State;
import DomainDependencies.Turn;

public class ReserveAgent {

	/**
	 * 
	 * @param state
	 * @param Date
	 * @param n_table
	 * @param turn
	 * @param n_chairs
	 */
	public static int generate_reserve(State state, String date, int n_table, Turn turn, int n_chairs) throws Exception { 
		Operational_table opt = new Operational_table(n_table, turn, state, date, n_chairs, -1);
		opt.setState(state);
		return opt.insertTable(turn, n_table, state, date, n_chairs);
	}

	/**
	 * 
	 * @param turn
	 * @param Date
	 * @param n_chairs
	 */
	public static int checkReserves(Turn turn, String date, int n_chairs) throws Exception { 
		Table [] tt = Table.read(turn, n_chairs);
		Operational_table opt;
		
		if (tt == null) {
			return -1;
		} else {
			for(int i=0; i<tt.length; i++) {
				opt = Operational_table.read(tt[i].getN_table(), date, turn);
				if (opt == null) return tt[i].getN_table();
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param date
	 * @param n_table
	 * @param turn
	 * @param waiter
	 */
	public static int setWaiter(String date, int n_table, Turn turn, int waiter) throws Exception {
		Operational_table opt = Operational_table.readWaiter(date, n_table, turn, waiter);
		if (opt==null) {
			return -1;	
		}else {
			opt.setWaiter(waiter);
			int result = opt.updateW(n_table, date, turn, waiter);
			if (result == 1) {
				//Updated properly
				return 0;
			} else {
				return -2;
			}
		}
	}

	/**
	 * 
	 * @param position
	 */
	public static int[] getWaiter(String position) throws Exception {
		User[] u = User.readPosition(position);
		int[] waiters = new int[u.length];
		
		if (u == null) {
			return null;
		}else {
			for (int i=0; i<u.length; i++) {
				waiters[i] = u[i].getId();
			}
			return waiters;
		}
	}

}