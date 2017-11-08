import java.util.Scanner;

public class VowelCounter {
	
	private static String scan(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter what day it is (monday, tuesday, etc): ");
		String input = sc.nextLine();
		sc.close();
		
		return input;
	}
	
	public static void countVowels(){
		char[] inputArray = scan().trim().toLowerCase().toCharArray();
		
		int v = 0, c = 0;
		for(char c : inputArray){
			switch(c){
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':
				v++;
				break;
			case ' ':
				break;
			case '
				
			} // end switch
		} // end for
		
	} // end method
	
}
