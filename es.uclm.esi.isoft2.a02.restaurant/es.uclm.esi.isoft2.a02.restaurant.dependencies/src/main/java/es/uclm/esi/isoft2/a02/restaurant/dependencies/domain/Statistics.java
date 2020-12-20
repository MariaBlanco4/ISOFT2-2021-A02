package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;

public class Statistics {
	
	private double takeCommand;
	private double preparationTimeMeal;
	private double timeDeliveryNote;
	private double preparationTimeTable;
	
	public double getTakeCommand() {
		return takeCommand;
	}

	public void setTakeCommand(double takeCommand) {
		this.takeCommand = takeCommand;
	}

	public double getPreparationTimeMeal() {
		return preparationTimeMeal;
	}

	public void setPreparationTimeMeal(double preparationTimeMeal) {
		this.preparationTimeMeal = preparationTimeMeal;
	}

	public double getTimeDeliveryNote() {
		return timeDeliveryNote;
	}

	public void setTimeDeliveryNote(double timeDeliveryNote) {
		this.timeDeliveryNote = timeDeliveryNote;
	}

	public double getPreparationTimeTable() {
		return preparationTimeTable;
	}

	public void setPreparationTimeTable(double preparationTimeTable) {
		this.preparationTimeTable = preparationTimeTable;
	}

	
	public Statistics (double takeCommand, double preparationTimeMeal, double timeDeliveryNote, double preparationTimeTable) {
		this.takeCommand = takeCommand;
		this.preparationTimeMeal = preparationTimeMeal;
		this.timeDeliveryNote = timeDeliveryNote;
		this.preparationTimeTable = preparationTimeTable;
	}
	
	public Statistics () {
	}
	
	public static Statistics readStatistics () throws Exception {
		Statistics stat = new Statistics();
		String sql = "SELECT * FROM Statistics ";
		Statistics auxStat = null;
		Vector<Object> auxVector;
		
		String sql1 = "WHERE name_statistic='take_command'";
		Vector<Object> vBroker1 = Broker.getBroker().select(sql+sql1);
		if(vBroker1.size() >= 1) {
			auxVector = (Vector<Object>) vBroker1.elementAt(0);
			double sumTakeCommand = 0;
			for (int i = 0; i< auxVector.size(); i++){
				sumTakeCommand += (Double) auxVector.elementAt(i);
			}
			double avgTTakeCommand = sumTakeCommand / auxVector.size();
			stat.setTakeCommand(avgTTakeCommand);
		}
		
		
		String sql2 = "WHERE name_statistic='preparation_time_meal'";
		Vector<Object> vBroker2 = Broker.getBroker().select(sql+sql2);
		if(vBroker2.size() >= 1) {
			auxVector = (Vector<Object>) vBroker2.elementAt(0);
			double sumPrepTimeMeal = 0;
			for (int i = 0; i< auxVector.size(); i++){
				sumPrepTimeMeal += (Double) auxVector.elementAt(i);
			}
			double avgTPrepTM = sumPrepTimeMeal / auxVector.size();
			stat.setPreparationTimeMeal(avgTPrepTM);
		}
		
		String sql3 = "WHERE name_statistic='time_delivery_note'";
		Vector<Object> vBroker3 = Broker.getBroker().select(sql+sql3);
		if(vBroker3.size() >= 1) {
			auxVector = (Vector<Object>) vBroker3.elementAt(0);
			double sumTDeliveryNote = 0;
			for (int i = 0; i< auxVector.size(); i++){
				sumTDeliveryNote += (Double) auxVector.elementAt(i);
			}
			double avgTTimeDelNote = sumTDeliveryNote / auxVector.size();
			stat.setTimeDeliveryNote(avgTTimeDelNote);
		}
		
		String sql4 = "WHERE name_statistic='preparation_time_table'";
		Vector<Object> vBroker4 = Broker.getBroker().select(sql+sql4);
		if(vBroker4.size() >= 1) {
			auxVector = (Vector<Object>) vBroker3.elementAt(0);
			double sumPrepTimeTable = 0;
			for (int i = 0; i< auxVector.size(); i++){
				sumPrepTimeTable += (Double) auxVector.elementAt(i);
			}
			double avgTPrepTimeTable = sumPrepTimeTable / auxVector.size();
			stat.setPreparationTimeTable(avgTPrepTimeTable);
		}
		
		return stat;
	}
	
	public static int insertStatistics (String nameStatistics, double time) throws Exception {
		String sql = "INSERT INTO Statistics (name_statistic, time) VALUES ('" + nameStatistics + "', " + time + ");";
		return Broker.getBroker().insert(sql);
	}
}
