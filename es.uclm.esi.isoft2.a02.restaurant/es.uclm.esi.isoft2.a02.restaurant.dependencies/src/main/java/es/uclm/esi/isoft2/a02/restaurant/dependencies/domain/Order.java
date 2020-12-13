package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class Order {

	private int orderID;
	private String[] drinks = new String[6];
	private String[] starters = new String[6];
	private String[] firstCourses = new String[6];
	private String[] secondCourses = new String[6];
	private String[] desserts = new String[6];
	private int id_operational_table;
	private String date;
	
	/**
	 * 
	 * @param drinks
	 * @param starters
	 * @param firstCourse
	 * @param secondCourse
	 * @param dessert
	 * @param id_operational_table
	 * @param date
	 */
	public Order(String[] drinks, String[] starters, String[] firstCourses, String[] secondCourses, String[] desserts, int id_operational_table, String date) {
		super();
		this.drinks = drinks;
		this.starters = starters;
		this.firstCourses = firstCourses;
		this.secondCourses = secondCourses;
		this.desserts = desserts;
		this.id_operational_table = id_operational_table;
		this.date = date;
	}

	public Order(int id_operational_table, String date) {
		super();
		this.id_operational_table = id_operational_table;
		this.date = date;
	}


	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String[] getDrinks() {
		return this.drinks;
	}

	public void setDrinks(String[] drinks) {
		this.drinks = drinks;
	}

	public String[] getStarters() {
		return this.starters;
	}

	public void setStarters(String[] starters) {
		this.starters = starters;
	}

	public String[] getFirstCourses() {
		return this.firstCourses;
	}

	public void setFirstCourses(String[] firstCourse) {
		this.firstCourses = firstCourse;
	}

	public String[] getSecondCourses() {
		return this.secondCourses;
	}

	public void setSecondCourses(String[] secondCourse) {
		this.secondCourses = secondCourse;
	}

	public String[] getDesserts() {
		return this.desserts;
	}

	public void setDesserts(String[] dessert) {
		this.desserts = dessert;
	}

	public int getId_operational_table() {
		return this.id_operational_table;
	}

	public void setId_operational_table(int id_operational_table) {
		this.id_operational_table = id_operational_table;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * 
	 * @param drinks
	 * @param starters
	 * @param firstCourse
	 * @param secondCourse
	 * @param dessert
	 * @param id_operational_table
	 * @param date
	 * id_operational_table, date
	 * drink_1, drink_2 ,drink_3 , drink_4, drink_5, drink_6
	 * starter_1, starters_2, starters_3, starter_4, starter_5,starter_6
	 * firstCourse_1, firstCourse_2, firstCourse_3,firstCourse_4,firstCourse_5,firstCourse_6
	 * secondCourse_1,secondCourse_2,secondCourse_3,secondCourse_4,secondCourse_5,secondCourse_6
	 * dessert_1, dessert_2, dessert_3, dessert_4, dessert_5, dessert_6
	 * DDBB : drink_1, drink_2..., firstCourse_1, firstCourse_2...
	 * max 6
	 */
	public int insertOrder(String[] drinks, String[] starters, String[] firstCourse, String[] secondCourse,
			String[] dessert, int id_operational_table, String date) throws Exception{

		String sql = "INSERT INTO Order (id_operational_table,date,drink_1, drink_2 ,drink_3 , drink_4, drink_5, drink_6,"
				+ "starter_1, starter_2, starter_3, starter_4, starter_5,starter_6, firstCourse_1, firstCourse_2, firstCourse_3,firstCourse_4,firstCourse_5,firstCourse_6,"
				+ "secondCourse_1,secondCourse_2,secondCourse_3,secondCourse_4,secondCourse_5,secondCourse_6,"
				+ "dessert_1, dessert_2, dessert_3, dessert_4, dessert_5, dessert_6) VALUES (" +id_operational_table+", '"+date+"',"
				+"'"+drinks[0]+"','" +drinks[1]+"','" +drinks[2]+"','" +drinks[3]+"','" +drinks[4]+ "','" +drinks[5]+","
				+"'"+starters[0]+"','" +starters[1]+"','" +starters[2]+"','" +starters[3]+"','" +starters[4]+"','"+starters[5]+"',"
				+"'"+firstCourse[0]+"','"+firstCourse[1]+"','"+firstCourse[2]+",'"+firstCourse[3]+"','"+firstCourse[4]+"','"+firstCourse[5]+"',"
				+"'"+secondCourse[0]+"', '"+secondCourse[1]+"','"+secondCourse[2]+"','"+secondCourse[3]+"','"+secondCourse[4]+"','"+secondCourse[5]+"',"
				+"'"+desserts[0]+"', '"+desserts[1]+"', '"+desserts[2]+"', '"+desserts[3]+"', '"+desserts[4]+"', '"+desserts[5]+"');";
		System.out.println(sql);
		return Broker.getBroker().insert(sql);	
	}


	/**
	 * Null when no dish inside
	 * @param String
	 */
	public void addFirstCourse(String firstCourse) {
	
		for (int i = 0; i <= firstCourses.length - 1; i++) {
			if (firstCourses[i] == null) {
				firstCourses[i] = firstCourse;
				break;
			}
		}
	}

	/**
	 * 
	 * @param starter
	 */
	public void addStarter(String starter) {
		for (int i = 0; i <= starters.length - 1; i++) {
			if (starters[i] == null) {
				starters[i] = starter;
				break;
			}
		}//TE AMO y yo a ti mi vida <3 
	}

	/**
	 * 
	 * @param secondCourse
	 */
	public void addSecondCourse(String secondCourse) {
		for (int i = 0; i <= secondCourses.length - 1; i++) {
			if (secondCourses[i] == null) {
				secondCourses[i] = secondCourse;
				break;
			}
		}
	}

	/**
	 * 
	 * @param dessert
	 */
	public void addDessert(String dessert) {
		for (int i = 0; i <= desserts.length - 1; i++) {
			if (desserts[i] == null) {
				desserts[i] = dessert;
				break;
			}
		}
	}

	/**
	 * 
	 * @param drink
	 */
	public void addDrink(String drink) {
		for (int i = 0; i <= drinks.length - 1; i++) {
			if (drinks[i] == null) {
				drinks[i] = drink;
				break;
			}
		}
	}

	
}