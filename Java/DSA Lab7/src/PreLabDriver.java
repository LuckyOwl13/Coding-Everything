import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The value of n0 (the first value for n to be incorrect when passed to rFact() is n = 13,
 * because the value of '13!' is 6227020800 which is too large to be stored in an int
 * (which maxes in storage at    2147483648). The result can be improved by changing the
 * primitive used from int-type to long-type so that larger numbers can be stored.
 * 
 * The value of n1 (the first value for n to be incorrect when passed to lFact() is n = 21,
 * because the value of '13!' is 5.109 x 10^19 which is too large to be stored in a long
 * (which maxes in storage at 9.223 x 10^18). The result can be improved by changing the
 * object used from a long-type primitive to the BigInteger class that larger numbers can 
 * be stored.
 * 
 * n0 = 13, n1 = 21.
 *
 * The recursive calls to the rFact() method adds a new method call to the stack every
 * time rFact() decides its value n > 1, which for large numbers piles up until all 
 * virtual memory is used to hold onto these method calls. When one method call is pushed
 * to the full stack, the runtime environment says "no" and ends the program.
 */
public class PreLabDriver{
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


	public static void main(String[] args) throws NumberFormatException, IOException {
		askInput();
	}	// end Constructor


	public static void askInput() throws NumberFormatException, IOException {

		System.out.print("\nValue for n: ");
		try{
			int n = Integer.parseInt(br.readLine());		
			System.out.println(rFact(n) + " " + n);
			//System.out.println("\n" + lFact((long)n) + " " + n);
		}catch (NumberFormatException e){
			System.out.println("not valid input u lameo");
		}catch (StackOverflowError e){
			System.err.println("good job you broke your computer lol");
			e.printStackTrace();
		}
		askInput();
	}	// end askInput

		
	private static long lFact(long n) {
		long result = 1;

		if (n > 1){	// for n = 0,1 result will be 1 bc that's how it works
			result = n * lFact(n-1);
		}		
		return result;
	}


	private static int rFact(int n){
		int result = 1;

		if (n > 1){	// for n = 0,1 result will be 1 bc that's how it works
			result = n * rFact(n-1);
		}		
		return result;
	}











}	// end class