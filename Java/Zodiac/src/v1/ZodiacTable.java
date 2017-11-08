package v1;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Calendar.Builder;
import java.util.Date;

/***
 * This class simulates a zodiac table that contains the zodiac signs.
 * @author caow2
 * @version v1
 */
public class ZodiacTable {
	String[] table;
	
	/**
	 * Constructor that initializes the table depending on the number of intended zodiac signs 
	 * @param numberOfSigns is a thing
	 */
	public ZodiacTable(int numberOfSigns) {
		table = new String[numberOfSigns];
	}
	
	/**
	 * Displays all of the signs in the zodiac table
	 */
	public void display() {
		for(String zodiac: table) {
			System.out.println(zodiac);
		}
	}
	
	/**
	 * Adds a zodiac sign to the table
	 * @param zodiac The sign being added
	 * @param index  The index in the table for the sign
	 */
	public void add(ZodiacSign zodiac, int index) {
		String z = zodiac.toString();
		table[index] = z;
	}
	
	/**
	 * Determines the user's sign through their birthday.
	 * @return The String form of the user's sign.
	 * @throws ParseException (it sure does)
	 */
	public String determineSign() throws ParseException {
		DayStorer dayStore = new DayStorer();
		Calendar bday = dayStore.collectDate();
		SignDecider sign = new SignDecider();
		int i = sign.getSignInt(bday);
		return table[i];
	}
	
	/**
	 * Determines the user's sign through their birthday **new**
	 * @return The String form of the user's sign.
	 */
	public String determineSign(Date birthdate) {
		// Makes a Calendar object from the Date object
		Builder builder = new Calendar.Builder();
		builder = builder.setInstant(birthdate);
		Calendar calendar = builder.build();
				
		//Takes calendar object and 
		SignDecider sign = new SignDecider();
		int i = sign.getSignInt(calendar);
		return table[i];
	}
}
