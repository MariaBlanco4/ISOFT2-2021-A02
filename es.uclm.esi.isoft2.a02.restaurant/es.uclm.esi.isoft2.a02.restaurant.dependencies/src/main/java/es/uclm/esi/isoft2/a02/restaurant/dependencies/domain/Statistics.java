package es.uclm.esi.isoft2.a02.restaurant.dependencies.domain;

import java.util.Vector;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.persistence.Broker;


public class Statistics {
	
	private double takeCommand=0;
	private double preparationTimeMeal=0;
	private double timeDeliveryNote=0;
	private double preparationTimeTable=0;
	
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
		double sumTakeCommand = 0;
		if(vBroker1.size() >= 1) {
			for (int i = 0; i< vBroker1.size(); i++){
				auxVector = (Vector<Object>) vBroker1.elementAt(i);
				sumTakeCommand += (Double) auxVector.elementAt(2);
			}
			double avgTTakeCommand = sumTakeCommand / vBroker1.size();
			stat.setTakeCommand(avgTTakeCommand);
		}
		
		
		String sql2 = "WHERE name_statistic='preparation_time_meal'";
		Vector<Object> vBroker2 = Broker.getBroker().select(sql+sql2);
		if(vBroker2.size() >= 1) {
			double sumPrepTimeMeal = 0;
					
			for (int i = 0; i< vBroker2.size(); i++){
				auxVector = (Vector<Object>) vBroker2.elementAt(i);
				sumPrepTimeMeal += (Double) auxVector.elementAt(2);
			}
			double avgTPrepTM = sumPrepTimeMeal / vBroker2.size();
			stat.setPreparationTimeMeal(avgTPrepTM);
		}
		
		String sql3 = "WHERE name_statistic='time_delivery_note'";
		Vector<Object> vBroker3 = Broker.getBroker().select(sql+sql3);
		if(vBroker3.size() >= 1) {
			
			double sumTDeliveryNote = 0;
			for (int i = 0; i< vBroker3.size(); i++){
				auxVector = (Vector<Object>) vBroker3.elementAt(i);
				sumTDeliveryNote += (Double) auxVector.elementAt(2);
			}
			double avgTTimeDelNote = sumTDeliveryNote / vBroker3.size();
			stat.setTimeDeliveryNote(avgTTimeDelNote);
		}
		
		String sql4 = "WHERE name_statistic='preparation_time_table'";
		Vector<Object> vBroker4 = Broker.getBroker().select(sql+sql4);
		if(vBroker4.size() >= 1) {
			
			double sumPrepTimeTable = 0;
			for (int i = 0; i< vBroker4.size(); i++){
				auxVector = (Vector<Object>) vBroker3.elementAt(i);
				sumPrepTimeTable += (Double) auxVector.elementAt(2);
			}
			double avgTPrepTimeTable = sumPrepTimeTable / vBroker4.size();
			stat.setPreparationTimeTable(avgTPrepTimeTable);
		}
		
		return stat;
	}
	
	public static int insertStatistics (String nameStatistics, double time) throws Exception {
		int result = 0;
		String sql = "INSERT INTO Statistics (name_statistic, time) VALUES ('" + nameStatistics + "', " + time + ");";
		try {
		result = Broker.getBroker().insert(sql);
		}catch(Exception e) {
			result = 0;
		}
		return result;
	}
}
