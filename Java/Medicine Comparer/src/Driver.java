import java.io.*;

public class Driver {
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int test1Pos = 0;	// declare counters for everything
		int test1Neg = 0;
		
		int test2Pos = 0;
		int test2Neg = 0;
		
		int sickCounter = 0;		// declare counters for patients (who are sick or not)
		int fineCounter = 0;
		
				
		// now, the program can get underway	
		
		System.out.print("How many patients were tested: ");
        int select = Integer.parseInt(br.readLine());

		
		while (select-- > 0) {	// Enter the L O O P
			System.out.print("Next patient: ");
			String readIn = br.readLine();	// read input
			
			//System.out.println(readIn);					// echo input to printer
			String[] nextInput = readIn.trim().split("\\s");	// split input on white space (allegedly), put it in a new array

			
			if (nextInput[1].equals("1")) {	// if patient has the disease
				sickCounter++;	// increase count of sick people
				
				if (nextInput[2].equals("1")){	// if they tested positive on Test 1 and were supposed to
					test1Pos++;
				}	// end if-else
				
				if (nextInput[3].equals("1")){	// if they tested positive on Test 1 and were supposed to
					test2Pos++;
				}	// end if-else
				
			} else {
				fineCounter++;	// increase count of fine people
								
				if (nextInput[2].equals("0")){	// if they tested negative on Test 1 and were supposed to
					test1Neg++;
				}	// end if-else
				
				if (nextInput[3].equals("0")){	// if they tested negative on Test 2 and were supposed to
					test2Neg++;
				}	// end if-else
				
			}	// end if-else
		}	// end while

		String betterTest = compareTests(test1Pos,test2Pos,test1Neg,test2Neg);
		String output = test1Pos +"/"+ sickCounter + " " + test2Pos +"/"+ sickCounter + " " + test1Neg +"/"+ fineCounter + " " + test2Neg +"/"+ fineCounter + " " + betterTest;
		
		System.out.println(output);
		
	}

	private static String compareTests(int pos1, int pos2, int neg1, int neg2) {
		String toReturn = null;
		if (pos1 > pos2 && neg1 > neg2) {
			toReturn = "test1";
		} else if (pos1 < pos2 && neg1 < neg2) {
			toReturn = "test2";
		} else {
			toReturn = "neither";
		}	// end if-else-if
				
		
		return toReturn;
	}	// end main





}	// end Driver
