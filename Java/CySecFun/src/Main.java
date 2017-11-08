import java.security.MessageDigest;

public class Main 
{
	public static void main(String [] args)
	{

		//SECURE RANDOM NUMBER GENERATION EXAMPLE 
		/*SecureRandomDemo secureRDemo = new SecureRandomDemo();
		SecureRandom randGen = secureRDemo.generateRandomInstance("SHA1PRNG");
		System.out.println("random int is " + randGen.nextInt());
		System.out.println("next random int is " + randGen.nextInt());*/
		
		
		//AES encrypt and decrypt
/*		MyEncrypt encryptor = new MyEncrypt();
		SecretKey k = encryptor.generateSymmetricAESKey();
		String encrypted = encryptor.encryptAES(k, "hello my name is Rosanne");
		System.out.println("decrypting");
		String decrypt = encryptor.decryptAES(k, encrypted);*/
				
		//RSA encrypt and decrypt
		/*MyEncrypt rsa_demo = new MyEncrypt();
		rsa_demo.generateRSAKeyPair("RSA");
		byte [] encrypted = rsa_demo.encryptRSA("you can call me snowball, cause my fur is soft and white", rsa_demo.get_privateKey());
		rsa_demo.decryptRSA(encrypted, rsa_demo.get_publicKey());*/
		
		//SHA256 MESSAGE DIGEST EXAMPLE
		/*MyHash  h = new MyHash();
		h.generateSHAhashFromFile("C:/Users/Keenan/workspace/CySecFun/test.txt");
		byte [] d1 = h.getDigest();	
		
		MyHash h2 = new MyHash();
		h2.generateSHAhash("different");
		byte [] d =h2.getDigest();
				
		System.out.println(MessageDigest.isEqual(d1,d));*/

		//DIGITAL SIGNATURE EXAMPLE
		/*MyDigitalSigner ds=new MyDigitalSigner();
		ds.signFile("test.txt","SHA1withDSA");
		ds.writeOutSignature();
		//now verify the signature
		ds.verifySignature("rosepk", "sig", "test.txt");*/
		
		//DICTIONARY ATTACK EXAMPLE
		//successful attack
		/*AttackHashPassword attacker = new AttackHashPassword();
		attacker.populateDictionary();
		MyHash h = new MyHash();*/
		
		//successful
		/*String hashedPwd = h.generateSHAhash("password");
		//unsuccessful
		//String hashedPwd = h.generateSHAhash("myfakepassword");
		System.out.println("hashed password is " + hashedPwd);
		String result = attacker.performDictionaryAttack(hashedPwd);
		System.out.println(" result is " + result);*/
		
		//BRUTE FORCE EXAMPLE
		/*String bhashedPwd = h.generateSHAhash("red");
		String bresult = attacker.performBruteForce(bhashedPwd);
		System.out.println("the result of brute force is " + bresult);*/
	}

}