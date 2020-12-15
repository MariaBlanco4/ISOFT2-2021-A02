package Domain;
public class Timer {

	private double timeToCount;

	/**
	 * 
	 * @param TimeToCount
	 */
	public Timer(double timeToCount) {
		this.timeToCount = timeToCount;
		throw new UnsupportedOperationException();
	}
	
	public double getTimeToCount() {
		return this.timeToCount;
	}

	/**
	 * 
	 * @param Date
	 */
	public void setTimeToCount(double timeToCount) {
		this.timeToCount = timeToCount;
		throw new UnsupportedOperationException();
	}

}