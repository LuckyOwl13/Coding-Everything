import java.util.Scanner;

public class ScanItUp {
	
	public static void scan(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter what day it is (monday, tuesday, etc): ");
		String day = sc.nextLine();
		sc.close();
		
		day = day.toLowerCase().trim();
		
		if(!day.equals("friday")) System.out.println("Even though it's not friday,");
		System.out.println("IT'S TIME TO PARTY !!");
	}
}
