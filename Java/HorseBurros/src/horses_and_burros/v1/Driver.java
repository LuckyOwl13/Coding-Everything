package horses_and_burros.v1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import horses_and_burros.v1.StateStatistic;

/**
 * Driver for the program
 * @author Keenan McElwee, 
 */
public class Driver {
	/** DataSet to be used by the driver */
	private static DataSet data;
	/** Name of the file to be used */
	private static String fileName;
	/** RNG for the driver */
	private static Random rand = new Random();
	
	/**
	 * Driver's main method to use the program
	 * @param args Main's args
	 */
	public static void main(String[] args){
		data = new DataSet();	// Instance of DataSet to be used by the driver
		//fileName = "//H:/workspace/HorseBurros/herdManagement.csv";	// Name of file used by the program 
		fileName = "C:/Users/Keenan/workspace/HorseBurros/herdManagement.cs";
		try{
			loadStatistics(data,fileName,3);	// calls loadStatistic
		}catch (StatisticDataNotFoundException e){
			System.err.printf("\n  At %s couldn't find file: \n'%s'\n  Are you sure the fileName is correct?",e.time,e.fileName);
		}
		displayStatistics();	// calls displayStatistics
		
		System.out.println();	// indent
		StateStatistic newStateStat = StateStatistic.deserialize();		// creates an instance of StateStatistic from the serialized one from earlier
		System.out.printf("\nThere are %s burros and %s horses in %s",
				newStateStat.getNumBurros(),newStateStat.getNumHorses(),newStateStat.getState());  // print out deserialized StateStatistic
	}



	/**
	 * Loads a CSV file into a DataSet instance and serializes one StateStatistic 
	 * instance picked at random
	 * 
	 * @param data the DataSet being loaded into
	 * @param fileName the file being loaded
	 * @param headerCount number of header rows the file has
	 * @throws StatisticDataNotFoundException if the specified datafile cannot be accessed
	 */
	public static void loadStatistics(DataSet data,String fileName,int headerCount) 
			throws StatisticDataNotFoundException{
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			for(int i = 0;i < headerCount;i++){		// skip header lines without info 
				br.readLine();	// reads but does nothing with the next line in the file
			}

			String line = "";	// string within each line in turn will be placed
			int randomSelection = rand.nextInt(10);	// the entry number that will be serialized
			int r = 0;			// entry counter to determine which lucky entry gets serialized
			while ((line = br.readLine()) != null) {	// while there are still more lines to read in file

				// CSV uses comma as separator, spilt line input on ','
				String[] p = line.split(",");
					
					// instantiate and add to the DataSet a StateStatistic made from the input from file
					StateStatistic stateStat = new StateStatistic(State.parseString(p[0]),
							Long.parseLong(p[1]),
							Long.parseLong(p[2]), 
							Long.parseLong(p[3]),
							Long.parseLong(p[4]),
							Long.parseLong(p[5]),
							Long.parseLong(p[6]));
					data.getStats().add(stateStat);
					
					// if this entry is the lucky one, it gets serialized
					if(r == randomSelection){
						stateStat.serialize();
					}
				r++;  // increment counter
			}
		}
		catch (FileNotFoundException e){
			throw new StatisticDataNotFoundException(fileName);
		}
		catch (IOException e){
			System.err.println("Something hecked up");
		}
	}

	/**
	 * Displays the entries loaded into the DataSet
	 */
	public static void displayStatistics(){
		// instantiates a collection for specifically StateStatistics and fills new collection with data's collection but cast to StateStatistic
		ArrayList<StateStatistic> stateStats = new ArrayList<StateStatistic>(20);	
		data.getStats().forEach(s -> stateStats.add((StateStatistic) s));			
		
		// forEach through StateStatistic collection and prints each entry
		System.out.print("\nDisplaying all entries...");
		stateStats.forEach(ss -> {
			System.out.printf("\nThere are %s burros and %s horses in %s",
				ss.getNumBurros(),ss.getNumHorses(),ss.getState());
		});
	}



//	public static Function<String, StateStatistic> mapToStateStatistic = (line) -> {
//		String[] p = line.split(",");
//		long i = 1L;
//		return new StateStatistic(State.parseString(p[0]),
//				Long.parseLong(p[1]),
//				Long.parseLong(p[2]), 
//				Long.parseLong(p[3]),
//				Long.parseLong(p[4]),
//				Long.parseLong(p[5]),
//				Long.parseLong(p[6]));
//	};
























}