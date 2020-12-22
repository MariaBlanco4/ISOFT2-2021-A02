package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain; 

import java.sql.SQLException;
import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;
<<<<<<< HEAD
=======

>>>>>>> Merge
public class Operational_table {

	private int n_table;
	private Turn turn;
	private State state;
	private String date;
	private int n_chairs;
	private int waiter = 0;
<<<<<<< HEAD

=======
	private String lastTimeStateChanged;
	
	public Operational_table(int n_table, Turn turn, State state, String date, int n_chairs, int waiter, String lastTimeStateChanged) {
		this.n_table=n_table;
		this.turn=turn;
		this.state=state;
		this.date=date;
		this.n_chairs=n_chairs;
		this.waiter=waiter;
		this.lastTimeStateChanged = lastTimeStateChanged;
	}
	
>>>>>>> Merge
	public Operational_table(int n_table, Turn turn, State state, String date, int n_chairs, int waiter) {
		this.n_table=n_table;
		this.turn=turn;
		this.state=state;
		this.date=date;
		this.n_chairs=n_chairs;
		this.waiter=waiter;
	}
	
	public Operational_table(int n_table, Turn turn, State state, String date, int n_chairs) {
		this.n_table=n_table;
		this.turn=turn;
		this.state=state;
		this.date=date;
		this.n_chairs=n_chairs;
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
	public void setDate(String Date) {
		this.date = Date;
	}

	/**
	 * 
	 * @param turn
	 * @param n_table
	 * @param state
	 * @param date
	 * @param n_chairs
	 */
	public int insertTable(Turn turn, int n_table, State state, String date, int n_chairs) throws Exception {
		String sql = "INSERT INTO Operational_table VALUES (" + n_table + ",'" + turn + "','" + state + "', '"+ date +"'," + n_chairs + ", null);";
		return Broker.getBroker().insert(sql);
	}

	/**
	 * 
	 * @param n_table
	 * @param date
	 * @param turn
	 */
	public static Operational_table read(int n_table, String date, Turn turn) throws Exception {
		String sql ="SELECT * FROM Operational_table WHERE n_table=" + n_table + " AND turn='" + turn + "' AND date='"+ date +"';";
		Operational_table auxOpTable = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql); 
		
		auxVector = new Vector<Object>();

        if (vBroker.size() >= 1){
        	auxVector = (Vector<Object>) vBroker.elementAt(0);
        	auxOpTable = new Operational_table((Integer) auxVector.elementAt(0), Turn.valueOf(Turn.class, auxVector.elementAt(1).toString()), State.valueOf(State.class, auxVector.elementAt(2).toString()), (String) auxVector.elementAt(3), (Integer) auxVector.elementAt(4));
    	} 
        return auxOpTable;	
	}

	/**
	 * 
	 * @param n_table
	 * @param turn
	 * @param date
	 */
	public static int delete(int n_table, Turn turn, String date) throws Exception {
		String sql = "DELETE FROM Operational_table WHERE n_table=" + n_table + " AND turn='" + turn + "' AND date='"+ date +"';";
		return Broker.getBroker().delete(sql);
	}

	/**
	 * 
	 * @param n_table
	 * @param Date
	 * @param turn
	 * @param waiter
	 */
	public int updateW(int n_table, String date, Turn turn, int waiter) throws Exception {
		String sql = "UPDATE Operational_table SET waiter=" + waiter + " WHERE n_table=" + n_table + " AND turn='" + turn + "' AND date='"+ date +"';"; 
		return Broker.getBroker().update(sql);
	}

	/**
	 * 
	 * @param n_table
	 * @param Date
	 * @param turn
	 * @param state
	 * @throws Exception 
	 */
	public int updateS(int n_table, String date, Turn turn, State state) throws Exception { 
		String sql = "UPDATE Operational_table SET state='" + state + "' WHERE n_table=" + n_table + " AND turn='" + turn + "' AND date='"+ date +"';";
		return Broker.getBroker().update(sql);
	}
	
	/**
	 * 
	 * @param n_table
	 * @param date
	 * @param turn
	 * @param waiters
	 */
	public static Operational_table readWaiter(String date, int n_table, Turn turn, int waiter) throws Exception {
		String sql ="SELECT * FROM Operational_table WHERE n_table=" + n_table + " AND turn='" + turn + "' AND date='"+ date +"';";
		Operational_table auxOpTable = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);
		
		auxVector = new Vector<Object>();
		
		if(vBroker.size() >= 1) {
			auxVector = (Vector<Object>) vBroker.elementAt(0); 
			auxOpTable = new Operational_table((Integer) auxVector.elementAt(0), Turn.valueOf(Turn.class, auxVector.elementAt(1).toString()), State.valueOf(State.class, auxVector.elementAt(2).toString()), (String) auxVector.elementAt(3), (Integer) auxVector.elementAt(4));
		} 
		return auxOpTable;
		
	}
<<<<<<< HEAD
=======
	
	public String getlastTimeStateChanged() {
		return this.lastTimeStateChanged; 
	}
	
	public int updateLastTimeStateChanged(int n_table, String date, Turn turn, String actualTime) throws Exception{
		String sql = "UPDATE Operational_table SET n_table=" + n_table + ", date='" + date + "', turn='" + turn + "', lastTimeStateChanged='" + actualTime + "';";
		return Broker.getBroker().update(sql);
	}
>>>>>>> Merge
}