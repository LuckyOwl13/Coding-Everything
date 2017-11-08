package horses_and_burros.v1;

import java.time.LocalTime;
/**
 * An Exception to be thrown when the statistic data file cannot be found
 * 
 * @author Keenan McElwee,
 */
public class StatisticDataNotFoundException extends Exception {
	/** Name of the unreached file */
	public String fileName;
	/** Time exception was thrown */
	public LocalTime time;
	
	/**
	 * Constructor of the class
	 * @param fileName the name of the unreached file
	 */
	public StatisticDataNotFoundException(String fileName) {
		this.fileName = fileName;
		time = LocalTime.now();
	}
}
