package es.uclm.esi.isoft2.a02.restaurant.table_booking.domain;

<<<<<<< HEAD
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Operational_table;
=======
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Operational_table; 
>>>>>>> Merge
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.State;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.User;

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
		int result = 0;
		
		if (tt[0] == null) {
			result = -1;
		} else {
			for(int i=0; i<tt.length; i++) {
				opt = Operational_table.read(tt[i].getN_table(), date, turn);
				if (opt == null) {
					result = tt[i].getN_table();
				}
			}
		}
		return result;
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
		int result;
		if (opt==null) {
			result = -1;	
		}else {
			opt.setWaiter(waiter);
			int resultOpt = opt.updateW(n_table, date, turn, waiter);
			if (resultOpt == 1) {
				//Updated properly
				result = 0;
			} else {
				result = -2;
			}
		}
		return result;
	}

	/**
	 * 
	 * @param position
	 */
	public static int[] getWaiter(String position) throws Exception {
		User[] u = User.readPosition(position);
		int[] waiters = new int[u.length];
		
		if (u[0] != null){
			for (int i=0; i<u.length; i++) {
				waiters[i] = u[i].getId();
			}
			
		}
		return waiters;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> Merge
