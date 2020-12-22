package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;



public class Control_operational_table {
	public static boolean changeState(State new_state, int n_table, String date, Turn turn) throws Exception {
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int seg = calendar.get(Calendar.SECOND);
		Operational_table opt = Operational_table.read(n_table, date, turn);
		boolean result;
		String lastTC = "";
		String actTime = "";

		if (opt == null) {
			result = false;
		} else {
			if (new_state == State.Asking || new_state == State.Waiting_for_food || new_state == State.Served
					|| new_state == State.Waiting || new_state == State.Paying || new_state == State.In_preparation
					|| new_state == State.Free) {
				lastTC = opt.getlastTimeStateChanged();
				actTime = hour + ":" + min + ":" + seg;
				try {
					opt.updateLastTimeStateChanged(n_table, date, turn, actTime);
				} catch (Exception e) {
					result = false;
				}
			}

			String[] parts_lastTC = lastTC.split(":");
			String[] parts_actTime = actTime.split(":");
			double differenceTime = (Double.parseDouble(parts_actTime[0]) * 3600
					+ Double.parseDouble(parts_actTime[1]) * 60 + Double.parseDouble(parts_actTime[2]))
					- (Double.parseDouble(parts_lastTC[0]) * 3600 + Double.parseDouble(parts_lastTC[1]) * 60
							+ Double.parseDouble(parts_lastTC[2]));

			if (opt.getState() == State.Asking && new_state == State.Waiting_for_food) {
				try {
					Statistics.insertStatistics("take_command", differenceTime);
				} catch (Exception e) {
					result = false;
				}
			}

			if (opt.getState() == State.Waiting_for_food && new_state == State.Served) {
				try {
					Statistics.insertStatistics("preparation_time_meal", differenceTime);
				} catch (Exception e) {
					result = false;
				}
			}

			if (opt.getState() == State.Waiting && new_state == State.Paying) {
				try {
					Statistics.insertStatistics("time_delivery_note", differenceTime);
				} catch (Exception e) {
					result = false;
				}
			}

			if (opt.getState() == State.In_preparation && new_state == State.Free) {
				try {
					Statistics.insertStatistics("preparation_time_table", differenceTime);
				} catch (Exception e) {
					result = false;
				}
			}

			if (new_state.equals(State.Free)) {
				opt.delete(n_table, turn, date);
				result = true;
			} else {
				opt.setState(new_state);
				opt.updateS(n_table, date, turn, new_state);
				result = true;
			}
		}
		return result;
	}
	
	public static int deleteReserve(int n_table, Turn turn, String date) throws Exception {
		return Operational_table.delete(n_table, turn, date);
	}
	
}
