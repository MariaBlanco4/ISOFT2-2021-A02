package es.uclm.esi.isoft2.a02.restaurant.statistics.domain;

import es.uclm.esi.isoft2.a02.restaurant.dependencies.domain.Statistics;

public class Control_statistics {
	public static double [] getStatistics() throws Exception {
		double [] result = new double [4];
		Statistics stat=null ;
		try {
		stat = Statistics.readStatistics();
		}catch(Exception e) {
			System.out.println("Can't read the statistics");
			stat=null;
		}
		if(stat!=null) {
		result[0] = stat.getTakeCommand();
		result[1] = stat.getPreparationTimeMeal();
		result[2] = stat.getTimeDeliveryNote();
		result[3] = stat.getPreparationTimeTable();
		}
		
		return result;
	}
}
