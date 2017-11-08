package v1;

public class Driver {
	
	public static void main(String[] args)
	{
		HexNumber nice = new HexNumber("11111111111");
		HexNumber forty = new HexNumber("40");
		HexNumber four = new HexNumber("4");
		HexNumber A = new HexNumber("A");
		HexNumber fourteen = new HexNumber("14");
		HexNumber two = new HexNumber("2");
		
		System.out.println(nice = HexNumber.divide(forty,four));
		System.out.println(nice = HexNumber.add(A,nice));
		System.out.println(nice = HexNumber.subtract(nice,fourteen));
		System.out.println(HexNumber.multiply(nice,two));
		
		try{
			new HexNumber("fh58hnbvjb9 eef afa /.,ff");
		}
		catch(InvalidHexadecimalStringException e){
			System.err.println(e.answer);
		}
		
		
	}
}
