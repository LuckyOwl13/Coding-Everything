package v1;

import java.util.Scanner;

public class Driver {
	static Simulator sim = new Simulator(100,100);
	
	public static void main (String[] args)
	{
		Randomizer rando = new Randomizer(1121);
		
		scan();
	}
	
	public static void scan(){
		Scanner sc = new Scanner(System.in);
		System.out.println("To run the Simulator, enter one of the following");
		System.out.println('\t' + "1 - Simulate one step");
		System.out.println('\t' + "5 - Simulate 5 steps");
		System.out.println('\t' + "C - Simulate 100 steps");
		System.out.println('\t' + "L - Simulate 500 steps");
		System.out.println('\t' + "M - Simulate 4000 steps");
		System.out.println('\t' + "X - End simulation");
		int i = 0;
		do{
			char[] input = sc.nextLine().toCharArray();
			parseScan(input);
		}while (i < 9999);
	}
	
	private static void parseScan(char[] input){
		for (char in : input){	
			switch (in){
				default: 	System.out.println("Not a valid input");
				case '1': 	System.out.println("Simulating 1 step");
							sim.simulateOneStep();
					break;
				case '5': 	System.out.println("Simulating 5 steps");
							sim.simulate(5);
					break;
				case 'C':
				case 'c': 	System.out.println("Simulating 100 steps");
							sim.simulate(100);
					break;
				case 'L':
				case 'l': 	System.out.println("Simulating 500 steps");
							sim.simulate(500);
					break;
				case 'M':
				case 'm': 	System.out.println("Simulating 4000 steps");
							sim.runLongSimulation();
					break;
				case 'x':
				case 'X': 	System.exit(0);
			}
		}
	}
	
	
	
	
	
	
	
	
}
