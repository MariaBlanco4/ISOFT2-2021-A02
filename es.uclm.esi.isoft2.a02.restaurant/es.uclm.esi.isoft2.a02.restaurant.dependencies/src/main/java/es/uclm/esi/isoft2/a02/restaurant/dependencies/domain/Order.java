package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.sql.SQLException;
import java.util.Vector;

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
	public Order(String[] drinks, String[] starters, String[] firstCourses, String[] secondCourses, 
			String[] desserts, int id_operational_table, String date) {
		super();
		
		for(int i =0; i<6;i++) {
			this.drinks[i] = drinks[i];
		}
		for(int i =0; i<6;i++) {
			this.starters[i] = starters[i];
		}
		for(int i =0; i<6;i++) {
			this.firstCourses[i] = firstCourses[i];
		}
		for(int i =0; i<6;i++) {
			this.secondCourses[i] = secondCourses[i];
		}
		for(int i =0; i<6;i++) {
			this.desserts[i] = desserts[i];
		}
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
		int order = 0;
		String sql = "INSERT INTO A02dbservice.Order (id_operational_table,date";
		for(int i = 0; i<drinks.length; i++) {
			if(drinks[i] != null) {
				sql = sql + ", drink_"+(i+1);
			}else {
				break;
			}
		}
		for(int i = 0; i<starters.length; i++) {
			if(starters[i] != null) {
				sql = sql + ", starter_"+(i+1);
			}else {
				break;
			}
		}
		for(int i = 0; i<firstCourse.length; i++) {
			if(firstCourse[i] != null) {
				sql = sql + ", firstCourse_"+(i+1);
			}else {
				break;
			}
		}
		for(int i = 0; i<secondCourse.length; i++) {
			if(secondCourse[i] != null) {
				sql = sql + ", secondCourse_"+(i+1);
			}else {
				break;
			}
		}
		for(int i = 0; i<dessert.length; i++) {
			if(dessert[i] != null) {
				sql = sql + ", dessert_"+(i+1);
			}else {
				break;
			}
		}
		
		sql = sql + ") VALUES ("+id_operational_table+", '"+date+"'";
		
		for(int i = 0; i<drinks.length; i++) {
			if(drinks[i] != null) {
				sql = sql + ", '" + drinks[i] + "'";
			}else {
				break;
			}
		}
		for(int i = 0; i<starters.length; i++) {
			if(starters[i] != null) {
				sql = sql + ", '" + starters[i] + "'";
			}else {
				break;
			}
		}
		for(int i = 0; i<firstCourse.length; i++) {
			if(firstCourse[i] != null) {
				sql = sql + ", '" + firstCourse[i] + "'";
			}else {
				break;
			}
		}
		for(int i = 0; i<secondCourse.length; i++) {
			if(secondCourse[i] != null) {
				sql = sql + ", '" + secondCourse[i] + "'";
			}else {
				break;
			}
		}
		for(int i = 0; i<dessert.length; i++) {
			if(dessert[i] != null) {
				sql = sql + ", '" + dessert[i] + "'";
			}else {
				break;
			}
		}
		sql = sql + ");";
		try {
		order = Broker.getBroker().insert(sql);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			order = 0;
		}
		return order;
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

	public static Order read(int id_operational_table) throws SQLException, Exception {
		String sql = "SELECT * FROM Order WHERE n_table=" + id_operational_table + ";";
		Order auxOrderTable = null;
		Vector<Object> auxVector;
		Vector<Object> vBroker = Broker.getBroker().select(sql);
		
		if (vBroker.size() >= 1){
        	auxVector = (Vector<Object>) vBroker.elementAt(0);
        	String [] drinks = new String[6];
        	for ( int i = 3; i < 9; i++) {
        		drinks[i-3] = (String) auxVector.elementAt(i);
        	}
        	String [] starters = new String[6];
        	for ( int i = 9; i < 15; i++) {
        		starters[i-9] = (String) auxVector.elementAt(i);
        	}
        	String [] first_course = new String[6];
        	for ( int i = 15; i < 21; i++) {
        		first_course[i-15] = (String) auxVector.elementAt(i);
        	}
        	String [] second_course = new String[6];
        	for ( int i = 21; i < 27; i++) {
        		second_course[i-21] = (String) auxVector.elementAt(i);
        	}
        	String [] desserts = new String[6];
        	for ( int i = 27; i < 33; i++) {
        		desserts[i-27] = (String) auxVector.elementAt(i);
        	}
        	auxOrderTable = new Order(drinks, starters, first_course, second_course, 
        			desserts, (Integer) auxVector.elementAt(1), (String) auxVector.elementAt(2));
    	} 
        return auxOrderTable;
	}
	
	/*public static Operational_table read(int n_table, String date, Turn turn) throws Exception {
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
	}*/

	
}