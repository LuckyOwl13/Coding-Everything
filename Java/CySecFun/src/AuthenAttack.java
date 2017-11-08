
import java.security.*;
import javax.crypto.*;

import java.util.ArrayList;
import java.util.HashMap;

public class AuthenAttack {
	private HashMap<byte[],MessageDigest> passwords;
	private ArrayList<String> hashes;

	public AuthenAttack() {
		this.passwords = new HashMap<byte[],MessageDigest>();
	}	// end Constructor
	
	public void hashPassword256(String plain){		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");	// initialize the hasher
			byte[] toHash = plain.getBytes();	// turn the input password into a byte array
			
			md.update(toHash);	// set the hasher to the password bytes
			byte [] digest = md.digest();	// hash the password
			
			passwords.put(digest, md);	// store password and hasher
			hashes.add(digest.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}	// end try-catch
	}	// end encodePassword
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the hashes
	 */
	public ArrayList<String> getHashes() {
		return hashes;
	}	// end getHashes

	/**
	 * @return the passwords
	 */
	public HashMap<byte[], MessageDigest> getPasswords() {
		return passwords;
	}	// end getPasswords

	public String performDictionaryAttack(String hash){			
		return null; //returns null if no match is found
		//or the plain text password if a match is found
	}	// end performDictionaryAttack

	
}	// end Class
