package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.sql.SQLException;
import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;


public class User {

	private int id;
	private String name;
	private String position;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param position
	 */
	public User(int id, String name, String position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * 
	 * @param position
	 * @throws Exception
	 * @throws SQLException
	 */
	public static User[] readPosition(String position) throws SQLException, Exception {
		String sql = "SELECT * FROM User WHERE position='" + position + "';";
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);
		User[] auxUser = new User[vBroker.size()];

		auxVector = new Vector<Object>();
		if (vBroker.size() >= 1) {
			for (int i = 0; i < vBroker.size(); i++) {
				auxVector = (Vector<Object>) vBroker.elementAt(i);
				auxUser[i] = new User((Integer) auxVector.elementAt(0), (String) auxVector.elementAt(2), (String) auxVector.elementAt(1));
			}
		}
		return auxUser;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param position
	 * @throws Exception
	 * @throws SQLException
	 */
	public static User readUser(int id, String name, String position) throws SQLException, Exception {
		String sql = "SELECT * FROM User WHERE id= " + id + " AND name= '" + name + "' AND position='" + position + "';";
		User auxUser = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);

		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			auxVector = (Vector<Object>) vBroker.elementAt(0);
			auxUser = new User((Integer) auxVector.elementAt(0), (String) auxVector.elementAt(2), (String) auxVector.elementAt(1));
		}
		return auxUser;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param position
	 * @throws Exception
	 * @throws SQLException
	 */
	public static User read(int id) throws SQLException, Exception {
		String sql = "SELECT * FROM User WHERE id=" + id + ";";
		User auxUser = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);

		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			auxVector = (Vector<Object>) vBroker.elementAt(0);
			auxUser = new User((Integer) auxVector.elementAt(0), (String) auxVector.elementAt(2), (String) auxVector.elementAt(1));
		}
		return auxUser;
	}
}