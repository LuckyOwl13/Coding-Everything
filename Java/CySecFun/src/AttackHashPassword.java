
import java.util.HashMap;

public class AttackHashPassword 
{
	private HashMap<String, String> dictionary = new HashMap(10);
	
	//a method which performs a dictionary attack on a hex representation of a hashed password
	public String performDictionaryAttack(String hash)
	{
		boolean inDict = dictionary.containsKey(hash);
		if(inDict == true)
		{
			return dictionary.get(hash);
		}
		else
		{
			System.err.println("not found :(");
			//returns null if no match is found
			return null;	
		}	
		//if instead the student uses a 2D array then in the first col is the key (hashed passwords)
		//second col is the value plaintext and should go something like this
		/*
		 * int numCols=2;
		 * int numRows=10;
		 * String [][] dict = {{"5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8","password"},{"cbfdac6008f9cab4083784cbd1874f76618d2a97","password123"},{"",""},{"",""}};
		 * for(int r=0;c<numRows;r++) 
		 * {
		 * 	for(int c=0;c<numCols;c++)
		 * 	{
		 *   if(c==0)//check if it's in the hash col
		 * 	 {
		 * 		if(dict[r][c].equals(hash))
		 * 		{ return dict[r][c+1]}
		 *   }
		 * 	}
		 * }
		 *if you get to the end and it's not found then return null
		 *System.err.println("not found");
		 *return null;
		 */
	}
	
	//a method which performs a brute force attack on a hex representation of a hashed password
	public String performBruteForce(String hash)
	{
		/*
		 * 
		 * there are likely more efficient algorithms out there, but this demonstrates the point 
		 */
			MyHash h = new MyHash();
		    String choices = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		    
		    //first populate an array with all the character choices, include 1 for empty string
			//since you can have passwords less than 5 characters long
			
		    String[] alpha = new String[choices.length() + 1];// add 1 space for empty string
		    for (int i = 1; i < alpha.length; i++) //starting from 1 since you want to be able to add a single empty space
			//at start
		    {
		        alpha[i] = choices.substring(i - 1, i);//gets each letter using substring from the choices string
				//e.g. i=1 means substring (0,1) which is the first char
				//i=2 means substring (1,2) which gives the second and so forth
				
		    }
		    alpha[0] = "";//add in empty string at pos 0
		    String guess = "";//set a string guess to be the empty string

		    for (int i = 0; i < alpha.length; i++) //approach is to go through all options in the alphabet array
		    	//then check all combinations of characters for 5 character length password
		    {
		        for (int j = 0; j < alpha.length; j++) 
		        {
		            for (int k = 0; k < alpha.length; k++) 
		            {
		                for (int l = 0; l < alpha.length; l++) 
		                {
		                    for (int m = 0; m < alpha.length; m++) 
		                    {
							//so e.g. first guess will be "", then a, then aa and so forth
		                        guess = alpha[i] + "" + alpha[j] + "" + alpha[k] + "" + alpha[l] + "" + alpha[m];
								//System.out.println("next guess is " + guess);
		                        if (h.generateSHAhash(guess).equals(hash)) 
		                        {
		                            return guess;
		                        }
		                    }
		                }
		            }
		        }
		    }
		//returns null if no match is found
		return null;
		//or the plain text password if a match is found
	}
	
	//basic dictionary population, not very realistic size
	public void populateDictionary()
	{
		String [] passwords = {"password","password123","123456","qwerty","football",
				"1234","starwars","monkey","welcome","letmein"};
		MyHash h = new MyHash();
		//iterates through the passwords dictionary and generates the hash
		//stores in a hashmap with the hash as the key and the plaintext passwords
		//as the value
		for(int pos=0;pos<passwords.length;pos++)
		{
			String hashedPwd = h.generateSHAhash(passwords[pos]);
			dictionary.put(hashedPwd,passwords[pos]);	
		}
		
	}
}