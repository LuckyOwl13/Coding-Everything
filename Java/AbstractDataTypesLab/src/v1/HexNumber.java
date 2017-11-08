package v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/***
 * HexNumber is an abstact data type for storing numbers in base 16 (0-F);
 * it can also convert numbers between base10 and base16, perform basic
 * operations with hexadecimal numbers, and verify if a string of characters
 * make up a valid hexadecimal number.
 * 
 * @author Keenan McElwee
 */
public class HexNumber {
	/** the long-type, base 16 form of the hexadecimal number */
	private long decimalValue;
	/** the string-type, base 16 form of the hexadecimal number */
	private String hexValue;
	
	
	/**
	 * Overloaded constructor where a base 16 number is passed for creation.
	 * @param hexValue The string form of the hexadecimal number to be made
	 */
	public HexNumber(String hexValue) {
		if (isHex(hexValue)) // validates input string before construction
		{
			this.hexValue = hexValue;
			this.decimalValue = decimalValue(hexValue);
		}		
	}	
	/**
	 * Overloaded constructor where a base 10 number is passed for creation.
	 * @param decimalValue The long form of the hexadecimal number to be made
	 */
	public HexNumber(long decimalValue) {
		this.decimalValue = decimalValue;
		this.hexValue = hexValue(decimalValue);
	}
	
	/**
	 * Returns the long-type, base 16 form of the hexadecimal number
	 * @return long The base 10 form of the constructed HexNumber value
	 */
	public long getDecimalValue() {
		return this.decimalValue;
	}
	/**
	 * Returns the string-type, base 16 form of the hexadecimal number
	 * @return String The base 16 form of the constructed HexNumber value
	 */
	public String getHexValue() {
		return this.hexValue;
	}
	
	/**
	 * @param hexString a String of characters to be checked if it's valid hexadecimal
	 * @return true if it's valid, false if it's not
	 */
	public static boolean isHex(String hexString){
		boolean valid = false;
		if (hexString.matches("^[a-fA-F0-9]*$"))
		{
			valid = true;
		}
		else{
			throw new InvalidHexadecimalStringException(hexString);
		}
		return valid;
	}
	
	/**
	 * @param hexValue The base 16 number to be converted to base 10
	 * @return long The base 10 version of the passed hexadecimal number 
	 */
	public static long decimalValue(String hexValue){
		long decValue = 0;

		boolean isNegative = false;
		char[] hexChars = hexValue.toCharArray();
		int j = 0;
		for (int i = hexChars.length - 1; i >= 0; --i)
		{
			int digit = 0;
			switch(hexChars[i])
			{
				case '0': digit = 0;
				break;
				case '1': digit = 1;
				break;
				case '2': digit = 2;
				break;
				case '3': digit = 3;
				break;
				case '4': digit = 4;
				break;
				case '5': digit = 5;
				break;
				case '6': digit = 6;
				break;
				case '7': digit = 7;
				break;
				case '8': digit = 8;
				break;
				case '9': digit = 9;
				break;
				case 'a':
				case 'A': digit = 10;
				break;
				case 'b':
				case 'B': digit = 11;
				break;
				case 'c':
				case 'C': digit = 12;
				break;
				case 'd':
				case 'D': digit = 13;
				break;
				case 'e':
				case 'E': digit = 14;
				break;
				case 'f':
				case 'F': digit = 15;
				break;
				case '-': isNegative = true;
				break;
				default: ;
				break;
			}
			decValue += digit * (Math.pow(16,j++));
		}
		
		if (isNegative)
		{
			decValue *= -1;
		}
		
		return decValue;
	}
	
	/**
	 * @param decValue The base 10 to be converted to base 10
	 * @return String The base 16 version of the passed base 10 number
	 */
	public static String hexValue(long decValue){
		String hexValue = "";
		
		if (decValue < 0){
			hexValue = "-";
			decValue *= -1;
		}
		
		long max16 = 16;
		while (max16 <= decValue){
			max16 *= 16;
		}
		if (max16 > decValue){
			max16 /= 16;
		}
		
		long next16 = max16;
		
		ArrayList<Integer> divided = new ArrayList<Integer>();  
		
		do {
			int multiplier = (int)  (decValue / next16); 
			divided.add(multiplier);
			
			decValue = decValue % next16;
			next16 /= 16;
		} while (decValue >= 0 && next16 > 0);
		

		char newDigit = '&'; 
		for (int dec : divided){
			switch(dec){
				case 0: newDigit = '0';
					break;
				case 1: newDigit = '1';
					break;
				case 2: newDigit = '2';
					break;
				case 3: newDigit = '3';
					break;
				case 4: newDigit = '4';
					break;
				case 5: newDigit = '5';
					break;
				case 6: newDigit = '6';
					break;
				case 7: newDigit = '7';
					break;
				case 8: newDigit = '8';
					break;
				case 9: newDigit = '9';
					break;
				case 10: newDigit = 'A';
					break;
				case 11: newDigit = 'B';
					break;
				case 12: newDigit = 'C';
					break;
				case 13: newDigit = 'D';
					break;
				case 14: newDigit = 'E';
					break;
				case 15: newDigit = 'F';
					break;
				default: System.out.println("Passed in an int > 15 ???? that doesn't make sense");
					break;
			}
			hexValue += newDigit;
		}
		return hexValue;
	}
	
	/**
	 * Adds two hexadecimal numbers together
	 * 
	 * @param hex1 The first hexadecimal number to be added
	 * @param hex2 The second hexadecimal number to be added
	 * @return HexNumber the sum of the two passed numbers 
	 */
	public static HexNumber add(HexNumber hex1, HexNumber hex2){
		
		long val1 = decimalValue(hex1.toString());
		long val2 = decimalValue(hex2.toString());
		long valTot = val1 + val2;
		
		HexNumber hexTot = new HexNumber(valTot);
		return hexTot;
	}
	/**
	 * Subtracts the second hexadecimal number from the first
	 * 
	 * @param hex1 The hexadecimal number substracted from
	 * @param hex2 The second hexadecimal number subtracting
	 * @return HexNumber the difference between the two passed numbers 
	 */
	public static HexNumber subtract(HexNumber hex1, HexNumber hex2){
			
			long val1 = decimalValue(hex1.toString());
			long val2 = decimalValue(hex2.toString());
			long valTot = val1 - val2;
			
			HexNumber hexTot = new HexNumber(valTot);
			return hexTot;
		}
	/**
	 * Multiplies two hexadecimal numbers together
	 * 
	 * @param hex1 The first hexadecimal number to be multiplied
	 * @param hex2 The second hexadecimal number to be multiplied
	 * @return HexNumber the product of the two passed numbers 
	 */
	public static HexNumber multiply(HexNumber hex1, HexNumber hex2){
		
		long val1 = decimalValue(hex1.toString());
		long val2 = decimalValue(hex2.toString());
		long valTot = val1 * val2;
		
		HexNumber hexTot = new HexNumber(valTot);
		return hexTot;
	}
	/**
	 * Divides the second hexadecimal number from the first
	 * 
	 * @param hex1 The numerator hexadecimal number
	 * @param hex2 The denominator hexadecimal number
	 * @return HexNumber the quotient of the two passed numbers 
	 */
	public static HexNumber divide(HexNumber hex1, HexNumber hex2){
		
		long val1 = decimalValue(hex1.toString());
		long val2 = decimalValue(hex2.toString());
		long valTot = val1 / val2;
		
		HexNumber hexTot = new HexNumber(valTot);
		return hexTot;
	}
	
	/**
	 * Returns a string form of the HexNumber instance
	 * 
	 * @return String The string form of the HexNumber instance
	 */
	@Override
	public String toString(){
		return this.hexValue;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
