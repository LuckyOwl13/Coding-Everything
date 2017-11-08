import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomDemo 
{
	public SecureRandomDemo()
	{	}	// end Constructor
	
	/**
	 * A method which returns a SecureRandom object using the getInstance method
	 * @return SecureRandom instance 
	 */
	public SecureRandom generateRandomInstance(String prngType)
	{
		SecureRandom prng = null;
		try 
		{
			prng = SecureRandom.getInstance(prngType);
		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.err.println("Algorithm " + prngType + " not found");
			e.printStackTrace();
		}
		return prng;
	}
	
	/**
	 * A method which returns a SecureRandom object using the default no parameter constructor
	 * differs as it used the default random number algorithm
	 * @return SecureRandom object
	 */
	public SecureRandom generateRandomConstructor()
	{
		SecureRandom my_prng = new SecureRandom();
		return my_prng;
	}
	
	/*
	 * returns the next random integer from the prng sr
	 */
	public int getRandomInt(SecureRandom sr)
	{
		return sr.nextInt();
	}
	
	/**
	 * a method to return an array of random bytes
	 * @param sr a random number generator
	 * @param numBytes the number of random bytes 
	 * @return an array of numBytes random bytes
	 */
	public byte [] getRandomByteArray(SecureRandom sr, int numBytes)
	{
		//int numBytes = 84;
		byte [] toFill = new byte[numBytes];
		sr.nextBytes(toFill);
		return toFill;
	}

}
