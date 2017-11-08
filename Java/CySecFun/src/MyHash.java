
import java.security.*;
import java.io.File;
import java.io.FileInputStream;

public class MyHash 
{
	
	byte [] digest;
	
	public MyHash()
	{
	}
	
	public String generateSHAhash(String pwd) 
	{
		try
		{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte [] pwdBytes = pwd.getBytes();//get a byte array of the string
		md.update(pwdBytes);//adds data to the MD object
		digest = md.digest();//creates the digest,  returns a byte array representation of the digest, digest object resets after calling this
		System.out.println("digest is " + hexRepresentationDigest(digest));
		return hexRepresentationDigest(digest);
		}
		catch(NoSuchAlgorithmException e)
		{
		System.err.println("couldn't find that algorithm implemented");
		}
		return null;
		
	}
	
	public String hexRepresentationDigest(byte [] d)
	{
	StringBuffer sb = new StringBuffer();
		for (byte b : d) 
		{
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
	
	public byte [] getDigest()
	{
		return digest;
		
	}
	
	public boolean checkEqual(byte [] claimed)
	{
	return MessageDigest.isEqual(digest,claimed);
	}
	
	public void generateSHAhashFromFile(String filename)
	{
	File f = new File(filename);
	  // Using java.io.FileInputStream
    byte[] fBytes = fileToByteArray(f);
	try
		{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(fBytes);//adds data to the MD object
		digest = md.digest();//creates the digest,  returns a byte array representation of the digest, resets the message digest after this
		System.out.println("digest is " + hexRepresentationDigest(digest));
		}
		catch(NoSuchAlgorithmException e)
		{
		System.err.println("couldn't find that algorithm implemented");
		}
		//return md;
	
	}

	public byte[] fileToByteArray(File f)
	{
		//FileInputStream obtains input bytes from a file 
		FileInputStream finput = null;
		//FileInputStream.read(byte[] b) reads up to 
		//b.length bytes of data from the input stream into an array of bytes.
		byte [] bytesArray= new byte[(int) f.length()];
		try
		{
		finput = new FileInputStream(f);
		finput.read(bytesArray);
		finput.close();
		}
		catch (Exception e)
		{
		System.err.println("exception caught");
		e.printStackTrace();
		}
		return bytesArray;
		//http://howtodoinjava.com/core-java/io/how-to-read-file-content-into-byte-array-in-java/
	}
}