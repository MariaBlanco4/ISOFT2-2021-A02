package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import java.sql.SQLException;  
import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;



public class Dish {

	private String name;
	private String[] ingredients = new String[6];
	private double price;
	private String type;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param name
	 * @throws Exception 
	 */
	public static Dish readDish(String name) throws Exception{
		String sql = "SELECT * FROM A02dbservice.Dish WHERE name = '"+name+"';";
		Dish ds =  null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);
		
		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			auxVector = (Vector<Object>) vBroker.elementAt(0);
			ds = new Dish((String)auxVector.elementAt(0) /*name*/, (double)auxVector.elementAt(1)/*price*/,
			 	(String) auxVector.elementAt(2)/*Type*/,(String) auxVector.elementAt(3), (String) auxVector.elementAt(4),
				(String) auxVector.elementAt(5),(String) auxVector.elementAt(6),(String) auxVector.elementAt(7),
				(String) auxVector.elementAt(8));
		} 
		return ds;
	}

	public Dish(String name, double price, String type,String ingredient_1, String ingredient_2, String ingredient_3,
			String ingredient_4, String ingredient_5, String ingredient_6) {
		this.name = name;
		this.ingredients[0] = ingredient_1;
		this.ingredients[1] = ingredient_2;
		this.ingredients[2] = ingredient_3;
		this.ingredients[3] = ingredient_4;
		this.ingredients[4] = ingredient_5;
		this.ingredients[5] = ingredient_6;
		this.price = price;
		this.type = type;
		
	}

	public String[] getIngridients() {
		// TODO - implement Dish.getIngridients
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param ingridients
	 * @param price
	 * @param type
	 */
	public Dish(String name) {
		this.name = name;
	}

}