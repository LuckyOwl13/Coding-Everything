package v1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/***
 * Driver class that's responsible for executing the zodiac program
 * @author Wen Cao, Caitlin McElwee
 * @version v1
 */
public class Driver {
	
	public static void main(String[] args) throws ParseException {
		Date birthdate = getBirthDate();
		ZodiacTable zodiac = createZodiacTable();
		System.out.println(zodiac.determineSign(birthdate));
	}
	
	
	/**
	 * Gets the birth date of the user  **new**
	 * @return A Date object that corresponds to the user's birth date
	 */
	public static Date getBirthDate() throws ParseException {
		// Prompts the user in the console to input their birthdate (MM/dd)
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your birthdate (format like '11/25'): ");
		String birthdateString = sc.nextLine();
		sc.close();
				
		// Parses the input string into a Date
		DateFormat format = new SimpleDateFormat("MM/dd", Locale.ENGLISH);
		Date date = format.parse(birthdateString);
		return date;		
	}
	
	
	
	/**
	 * Creates a new zodiac table and returns a zodiac table filled with 12 zodiac signs
	 * @return A zodiac table with 12 signs
	 */
	public static ZodiacTable createZodiacTable() {
		ZodiacTable a = new ZodiacTable(12);
		addTo(a);
		return a;
	}
	
	/**
	 * Creates a new zodiac table and returns a zodiac table filled with 13 zodiac signs
	 * @return A zodiac table with 13 signs
	 */
	public static ZodiacTable createZodiacTableFor13() {
		ZodiacTable a = new ZodiacTable(13);
		addTo(a);
		a.add(ZodiacSign.OPIUCHUS, 12);
		return a;
	}
	
	/**
	 * Adds 12 zodiac signs to a specified zodiac table 
	 * @param table The table in which signs are being added
	 */
	public static void addTo(ZodiacTable table) {
		table.add(ZodiacSign.ARIES, 0);
		table.add(ZodiacSign.TAURUS, 1);
		table.add(ZodiacSign.GEMINI, 2);
		table.add(ZodiacSign.CANCER, 3);
		table.add(ZodiacSign.LEO, 4);
		table.add(ZodiacSign.VIRGO, 5);
		table.add(ZodiacSign.LIBRA, 6);
		table.add(ZodiacSign.SCORPIO, 7);
		table.add(ZodiacSign.SAGITTARIUS, 8);
		table.add(ZodiacSign.CAPRICORN, 9);
		table.add(ZodiacSign.AQUARIUS, 10);
		table.add(ZodiacSign.PISCES, 11);
	}
}
