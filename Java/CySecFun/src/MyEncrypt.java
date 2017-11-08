import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;//Cipher object encrypts
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;//a crypto key
import java.security.KeyFactory;//turns bytes into Key objects
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;


public class MyEncrypt 
{
	private PrivateKey privKey;
	private PublicKey publicKey;
	
	public MyEncrypt()
	{
		
	} 
	
	public SecretKey generateSymmetricAESKey()
	{
		SecretKey sk = null;
		String alg = "AES";
		try 
		{
			KeyGenerator kg = KeyGenerator.getInstance(alg);
			kg.init(128);//set key size to 128
			sk = kg.generateKey();
			
		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.err.println("No algorithm " + alg + " exists");
			e.printStackTrace();
		}
		return sk;
	}
	
	public void generateRSAKeyPair(String alg)
	{
		try 
		{
			KeyPairGenerator kg = KeyPairGenerator.getInstance(alg);//can generate a pair in an algorithm specific way like this
			kg.initialize(2048);//initialise with key size 2048
			KeyPair keypair = kg.genKeyPair();
	        privKey = keypair.getPrivate();
	        System.out.println("private key is " + privKey);
	        publicKey = keypair.getPublic();
	        System.out.println("public key is " + publicKey.toString());

		} 
		catch (NoSuchAlgorithmException e) 
		{
			System.err.println("No algorithm " + alg + " exists");
			e.printStackTrace();
		}
		
	}
	
	public PrivateKey get_privateKey()
	{
		return privKey;
	}
	
	public PublicKey get_publicKey()
	{
		return publicKey;
	}
	
	public byte [] encryptRSA(String toEncrypt, Key k)
	{
		Cipher c = null;
		try 
		{
			c= Cipher.getInstance("RSA/ECB/PKCS1Padding");
			c.init(Cipher.ENCRYPT_MODE, k);
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		byte[] encryptedBytes = null;
		try 
		{
			encryptedBytes = c.doFinal(toEncrypt.getBytes("UTF-8"));
		} 
		catch(IllegalBlockSizeException e)
		{
			
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("encrypted is " + new String(encryptedBytes));
		return encryptedBytes;
	}
	
	public void decryptRSA(byte [] encrypted, Key k)
	{
		try 
		{
			Cipher d_c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			d_c.init(Cipher.DECRYPT_MODE, k);
			byte [] decrypted = d_c.doFinal(encrypted);
			String decryptedS = new String(decrypted);
			System.out.println("decrypted is " +decryptedS);
			
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String encryptAES(SecretKey k, String toEncrypt)
	{
		Cipher c = null;
		try 
		{
			c= Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, k);
		} 
		catch (NoSuchAlgorithmException | NoSuchPaddingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvalidKeyException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] encryptedBytes = null;
		try {
			encryptedBytes = c.doFinal(toEncrypt.getBytes("UTF-8"));
		} 
		catch (IllegalBlockSizeException e) {
			System.err.println("illegal block size");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			System.err.println("bad padding exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) 
		{
			System.err.println("unsupported encoding");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String encrypted =new String(encryptedBytes);
        System.out.println("encrypted: " + new String(encrypted));
		return encrypted;
		
	}
	
	public String decryptAES(SecretKey k, String encrypted)
	{
		String decrypted="";
		try 
		{
			Cipher c_d = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c_d.init(Cipher.DECRYPT_MODE, k);
			byte [] decryptedBytes = c_d.doFinal(encrypted.getBytes());
			decrypted = new String(decryptedBytes);
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (NoSuchPaddingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.err.println("decrypted "  + decrypted);
		return decrypted;
		
	}
}
