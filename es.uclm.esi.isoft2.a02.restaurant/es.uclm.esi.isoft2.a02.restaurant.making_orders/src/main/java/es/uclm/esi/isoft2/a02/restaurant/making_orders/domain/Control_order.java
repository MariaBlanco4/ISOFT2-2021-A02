package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import java.sql.SQLException;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Operational_table;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Order;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.State;
import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Turn;

public class Control_order {

	/**
	 * 
	 * @param n_table
	 * @param date
	 * @param turn
	 * @param drinks
	 * @param dishes
	 */
	public static int checkOrder(int n_table, String date, Turn turn, 
			String[] drinks, String[] dishes) throws SQLException, Exception{
		
		Operational_table ot = Operational_table.read(n_table, date, turn);
		Order od;
		State state;
		
		Dish ds;
										
		Ingredient ing;
		Drink dr;
		
		String type; //for each string in ingredients
		
		String[] current_ingredients = new String[6]; // To introduce each [] of ingredients 
		int order = 0; //Return, if == 0 : proper , if == -1 : error 
		
		if(ot != null) {
			state = ot.getState();
			if(state == State.Asking) {
				od = new Order(n_table, date); //Here we need to create the Order object
				for(int i = 0 ; i < dishes.length && order != -1 || dishes[i+1]!=null; i++) {
					ds = Dish.readDish(dishes[i]);
					if(ds != null) {
						current_ingredients = ds.getIngredients(); //Array of each ingredient
						for(int j = 0; j<current_ingredients.length && order !=-1 && dishes!=null; j++) {
							if((ing = Ingredient.readIngredient(current_ingredients[j])) != null) {
								if(ing.checkAmountIngredient() == false) {
									order = -1;
								}
							}	
						}
						type = ds.getType();
						switch(type) {
							case "starter":
								od.addStarter(ds.getName());
								break;
							case "first_course":
								od.addFirstCourse(ds.getName());
								break;
							case "second_course":
								od.addSecondCourse(ds.getName());
								break;
							case "dessert":
								od.addDessert(ds.getName());
								break;
						}
					} else {
						order = -1;
						break;
					}
					if(dishes[i+1]==null && i<(dishes.length-1)) {
						break;
					}
				}

				for(int i = 0 ; i<drinks.length && order !=-1 && drinks!=null; i++) {
					if((dr = Drink.readDrink(drinks[i])) != null){
						if(!dr.checkAmountDrink()) {
							order = -1;
							break;
						}else {
							od.addDrink(dr.getName());
						}
					} if(drinks[i+1]==null && i<(drinks.length-1)) {
						break;
					}
				}
				
				for(int i = 0 ; i < dishes.length && order != -1 && dishes!=null;  i++) {
					if((ds = Dish.readDish(dishes[i])) != null) {
						current_ingredients =ds.getIngredients();
						for(int j=0 ; j<current_ingredients.length && order != -1; j++) {
							if((ing = Ingredient.readIngredient(current_ingredients[i])) != null) {
								if(!ing.checkAmountIngredient()) {
									order = -1;
									break;
								}else {
									if((ing.updateIngredient(ing.getName(), (ing.getAmount()-1))) == 0) {
										order = -1;
										break;
									}
								}
							} if(dishes[i+1]==null && i<(dishes.length-1)){
								break;
							}
						}
						
					}
				}
				
				for(int i = 0 ; i <drinks.length && order != -1 && drinks!=null; i++) {
					if((dr = Drink.readDrink(drinks[i])) != null) {
						if(!dr.checkAmountDrink()) {
							order = -1;
							break;
						}else {
							if((dr.updateDrink(dr.getName(), (dr.getAmount()-1))) == 0){
								order = -1;
								break;
							}
						}
					}
					if (drinks[i+1]==null && i<(drinks.length-1)) {
						break;
					}
				}
				
				if((od.insertOrder(od.getDrinks(), od.getStarters(), od.getFirstCourses(), od.getSecondCourses(),
								od.getDesserts(), n_table, date)) == 0) {
					order = -1;
				} else {
					ot.setState(State.Waiting_for_food);
					if((ot.updateS(n_table, date, turn, ot.getState())) == 0) {
						order = -1;
					}
				}
			} else order = -1;
		} else order=-1;
		
		return order;
	}
	
	public static int charge_order (int id_operational_table, String date, Turn turn) throws SQLException, Exception {
		int price = 0;
		Order order = null;
		try {
			order= Order.read(id_operational_table);
		}catch(Exception e) {
			order = null;
			price = 0;
		}
		
		for (int i=0; i<6; i++){
			Dish dish = null;
			try {
				dish = Dish.readDish(order.getStarters()[i]);
			}catch(Exception e) {
				break;
			}
			price += dish.getPrice();
		}
		
		for (int i=0; i<6; i++){
			Dish dish = null;
			try {
				dish = Dish.readDish(order.getFirstCourses()[i]);
			}catch(Exception e) {
				break;
			}
			price += dish.getPrice();
		}
		
		for (int i=0; i<6; i++){
			Dish dish = null;
			try {
				dish = Dish.readDish(order.getSecondCourses()[i]);
			}catch(Exception e) {
				break;
			}
			price += dish.getPrice();
		}
		
		for (int i=0; i<6; i++){
			Dish dish = null;
			try {
				dish = Dish.readDish(order.getDesserts()[i]);
			}catch(Exception e) {
				break;
			}
			price += dish.getPrice();
		}
		
		for (int i=0; i<6; i++){
			Drink drink = null;
			try {
				drink = Drink.readDrink(order.getDrinks()[i]);
			}catch(Exception e) {
				break;
			}
			price += drink.getPrice();
		}
			
		return price;
	}
}