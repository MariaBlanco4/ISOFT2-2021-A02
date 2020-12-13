package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import java.sql.SQLException;  
import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;


public class Notification {

	private int origin;
	private String message;
	private int destination;
	private int id_notification; //autoincremental

	public int getOrigin() {
		return this.origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDestination() {
		return this.destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getId_notification() {
		return this.id_notification;
	}

	public void setId_notification(int id_notification) {
		this.id_notification = id_notification;
	}

	/**
	 * 
	 * @param destination
	 */
	public static Notification[] readNotification(int destination) throws SQLException, Exception { 
		//A VER PARGUEGLA Q DEVUELVE UNA STRING
		String sql = "SELECT id_notification, message, origin, destination FROM Notification WHERE destination= " + destination + ";";
		Vector<Object> vBroker = Broker.getBroker().select(sql);
		Notification[] auxNot = new Notification[(vBroker.size())];
		Vector<Object> auxVector;

		auxVector = new Vector<Object>();

		if (vBroker.size() >= 1) {
			for (int i = 0; i < (vBroker.size()); i ++) {
				auxVector = (Vector<Object>) vBroker.elementAt(i);
				auxNot[i] = new Notification((Integer) auxVector.elementAt(2), (String) auxVector.elementAt(1), (Integer) auxVector.elementAt(3),(Integer)  auxVector.elementAt(0));
				System.out.println(auxNot[i].getMessage());
			}
		}
		return auxNot; 
	}
	public Notification(int origin, String message, int destination, int id_notification) {
		super();
		this.origin = origin;
		this.message = message;
		this.destination = destination;
		this.id_notification = id_notification;
	}

	/**
	 * 
	 * @param id_notification
	 */
	public static int deleteNotification(int id_notification) throws SQLException, Exception{
		String sql = "DELETE FROM Notification WHERE id_notification =" + id_notification + ";";
		Broker.getBroker();
		return Broker.delete(sql);
	}
	/** 
	 * @param message
	 * @param origin
	 * @param destination
	 *	
	 */
	public static int insertNotification(String message, int origin, int destination) throws Exception{
		String sql = "INSERT INTO Notification (message, origin, destination) VALUES('"+message+"',"+origin+","+destination+");";
		Broker.getBroker();
		return Broker.insert(sql);
	}
	/*
	 * Constructor to get the notification
	 */
	public Notification(int destination) {
		super();
		this.destination = destination;
	}


}