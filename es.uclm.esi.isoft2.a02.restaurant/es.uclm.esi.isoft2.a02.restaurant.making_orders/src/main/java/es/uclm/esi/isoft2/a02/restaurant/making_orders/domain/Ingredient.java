package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker; 


public class Ingredient {

	private String name;
	private int amount;
	private int threshold;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getThreshold() {
		return this.threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	/**
	 * 
	 * @param name
	 */
	public static Ingredient readIngredient(String name) throws Exception{
		String sql = "SELECT * FROM Ingredient WHERE name = '" + name + "';";
		Ingredient ing = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);

		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			auxVector = (Vector<Object>) vBroker.elementAt(0);
			ing = new Ingredient((String) auxVector.elementAt(0) /* name */, (int) auxVector.elementAt(1)/* amount */,
					(int)auxVector.elementAt(2)); /* Threshold */
		}
		return ing;
	}
	/**
	 * 
	 * @param name
	 * @param amount
	 */
	public int updateIngredient(String name, int amount) throws Exception{
		String sql = "UPDATE A02dbservice.Ingredient SET amount="+ amount + " WHERE name = '"+name+"';";
		int ing = 0;
		try {
		ing = Broker.getBroker().update(sql);
		}catch(Exception e) {
			ing = 0;
		}
		return ing;
	}

	public boolean checkAmountIngredient() {
		int amount = getAmount();
		boolean check = true;
		if(amount-1 >= 0){
			check = true;
		}else{
			check = false;
		}
		return check;
	}

	/**
	 * 
	 * @param name
	 * @param amount
	 * @param threshold
	 */
	public Ingredient(String name, int amount, int threshold) {
		this.name = name;
		this.amount = amount;
		this.threshold = threshold;
	}

}