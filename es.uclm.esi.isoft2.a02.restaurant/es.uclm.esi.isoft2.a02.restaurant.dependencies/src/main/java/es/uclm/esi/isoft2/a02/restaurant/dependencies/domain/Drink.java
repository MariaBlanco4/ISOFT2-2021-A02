package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.sql.SQLException; 
import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;


public class Drink {

	private String name;
	private double price;
	private int amount;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @param name
	 */
	public static Drink readDrink(String name) throws SQLException, Exception{
		String sql = "SELECT * FROM Drink WHERE name= '" + name + "';";
		Drink auxDrink = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);

		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			auxVector = (Vector<Object>) vBroker.elementAt(0);
			auxDrink = new Drink((String) auxVector.elementAt(0), (Double) auxVector.elementAt(1), 
									(Integer) auxVector.elementAt(2));
		}
		return auxDrink;
	}

	public boolean checkAmountDrink() {
		int amount = getAmount();
		boolean check = true;
		if (amount - 1 >= 0) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	/**
	 * 
	 * @param name
	 * @param price
	 * @param amount
	 */
	public Drink(String name, double price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param name
	 * @param amount
	 */
	public int updateDrink(String name, int amount) throws SQLException, Exception{
		String sql = "UPDATE Drink SET amount=" + amount + " WHERE name='" + name + "' ;"; //Mirar si está bien lo de las comillas en name.
		return Broker.getBroker().update(sql);
	}

}