package es.uclm.esi.isoft2.a02.restaurant.table_booking.domain;

import java.sql.SQLException;
import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;


public class Table {

	private int n_table;
	private int n_chairs;
	private Turn turn;

	
	public Table(int n_table, int n_chairs, Turn turn) {
		this.n_table = n_table;
		this.n_chairs = n_chairs;
		this.turn = turn;
	}
	
	
	/**
	 * 
	 * @param turn
	 * @param n_chairs
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static Table[] read(Turn turn, int n_chairs) throws SQLException, Exception {
		String sql = "SELECT * FROM Table_t WHERE turn='" + turn + "' AND n_chairs=" + n_chairs + ";";
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);
		Table [] auxTable = new Table[vBroker.size()];

		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			for(int i=0; i<vBroker.size();i++) {
				auxVector = (Vector<Object>) vBroker.elementAt(i);
				auxTable[i] = new Table((Integer) auxVector.elementAt(0), (Integer) auxVector.elementAt(1), Turn.valueOf(Turn.class, auxVector.elementAt(2).toString()));
			}
		}
		return auxTable;
	}
	
	public int getN_table() {
		return this.n_table;
	}
}