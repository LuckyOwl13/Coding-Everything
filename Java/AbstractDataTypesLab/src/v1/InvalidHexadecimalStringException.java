package v1;

import java.util.ArrayList;
/**
 * Exception thrown when an invalid string is passed to be formatted into a HexNumber
 * @author Keenan McElwee,
 */
public class InvalidHexadecimalStringException extends RuntimeException {
	/** The string that tried to be made a HexNumber */
	public String hexVal;
	/** This's response to the passed parameters in construction */
	public String answer;
	
	/**
	 * Constructor for the class
	 * @param isValid If the passed string was valid
	 * @param hexVal The string that tried and failed to be made a HexNumber
	 */
	public InvalidHexadecimalStringException(String hexVal) {
		this.hexVal = hexVal;
		findError(); // calls findError to set answer
	}
	/**
	 * Evaluates the input string for what hecked up the process
	 * @param hexVal the input string that tripped the exception
	 */
	public void findError(){
		answer = "no error"; // intitialize answer so if no problem's found no problem's reported
		String badCharacters = ""; // initialize string for bad characters in input
		
		// forEach through hexVal string and evaluates each character
		for (char c : hexVal.toLowerCase().toCharArray()) { 
		    if (!(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F') && !(c >= '0' && c <= '9')){
		        badCharacters += c; // if current character is invalid, added to badCharacter
		    }
		}
		// sets answer to formatted string with badCharacters if any invalids were found
		if(badCharacters.length() > 0){
			answer = "HEXADECIMAL STRING CONTAINS INVALID CHARACTERS (" + badCharacters + ")\nHEXADECIMALS CAN ONLY CONTAIN a-f,A-F,0-9";
		}
	}
	
	
	
	
	
	
}
