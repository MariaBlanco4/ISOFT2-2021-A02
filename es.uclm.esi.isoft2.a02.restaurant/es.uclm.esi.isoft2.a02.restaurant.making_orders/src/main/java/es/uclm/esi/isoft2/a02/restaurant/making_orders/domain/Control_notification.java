package es.uclm.esi.isoft2.a02.restaurant.making_orders.domain;

import java.sql.SQLException;  
import java.util.ArrayList;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.User;

public class Control_notification {
	/**
	 * 
	 * @param message
	 * @param destination
	 */
	public static boolean notify(String message, int origin, int destination) throws SQLException, Exception{
		boolean not = false;
		int notify = 0;
		//destination => id of the destination
		if(User.read(destination) != null){
			notify = Notification.insertNotification(message, origin, destination);
			not = true;
		}else{
			not = false;
		}
		return not;
	} 

	public static String[] getNotifications(int id_user) throws SQLException, Exception{
		Notification[] n = null;
		Notification current_notification = new Notification(id_user);
		ArrayList<String> notifications = new ArrayList<String>();
		String[] notifies = null;
		if((n = Notification.readNotification(id_user)) != null){
			for(int i =0 ; i< n.length ; i ++){
				current_notification = n[i];
				notifications.add(i, current_notification.getMessage()); 
				if(Notification.deleteNotification(current_notification.getId_notification()) != 1){
					notifies = null;
					break;
				}

			}
			notifies = new String[notifications.size()];
			for(int i= 0 ; i< notifies.length ; i++)
				notifies[i] = notifications.get(i);
		}else n = null;
		return notifies;
	}
}
