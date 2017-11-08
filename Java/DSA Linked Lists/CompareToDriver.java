
public class CompareToDriver {

	public static void main(String[] args) {
		
		System.out.println("\"\" compared to \"\" is " + "".compareTo(""));
		
		System.out.println("\"a\" compared to \"a\" is " + "a".compareTo("a"));
		
		System.out.println("\"a\" compared to \"A\" is " + "a".compareTo("A"));
		System.out.println("\"A\" compared to \"a\" is " + "A".compareTo("a"));
		
		System.out.println("\"t\" compared to \"T\" is " + "t".compareTo("T"));
		System.out.println("\"T\" compared to \"t\" is " + "T".compareTo("t"));
		
		System.out.println("\"a\" compared to \"z\" is " + "a".compareTo("z"));
		
		System.out.println("\"A\" compared to \"Z\" is " + "A".compareTo("Z"));
		
		System.out.println("\"a\" compared to \"Z\" is " + "a".compareTo("Z"));
		
		System.out.println("\"z\" compared to \"A\" is " + "z".compareTo("A"));
		
		System.out.println("\"a\" compared to \"1\" is " + "a".compareTo("1"));
		
		System.out.println("\"1\" compared to \"A\" is " + "1".compareTo("A"));
		
		System.out.println("\"1\" compared to \"z\" is " + "1".compareTo("z"));
		
		System.out.println("\"1\" compared to \"Z\" is " + "1".compareTo("Z"));
		
		System.out.println("\"1\" compared to \"2\" is " + "1".compareTo("2"));
		
		System.out.println("\"!\" compared to \"@\" is " + "!".compareTo("@"));
		
		System.out.println("\"1\" compared to \"9\" is " + "1".compareTo("9"));
		
		System.out.println("\"84\" compared to \"21\" is " + "84".compareTo("21"));
		
		System.out.println("\"200\" compared to \"50\" is " + "200".compareTo("50"));
		System.out.println("\"2000\" compared to \"500\" is " + "2000".compareTo("500"));
		System.out.println("\"2000\" compared to \"5000\" is " + "2000".compareTo("5000"));
		System.out.println("\"2000\" compared to \"50000\" is " + "2000".compareTo("50000"));
		
		System.out.println("\"Hello\" compared to \"Hi\" is " + "Hello".compareTo("Hi"));
		System.out.println("\"Hello\" compared to \"Hi\" is " + "Hello".compareTo("Hi Hi"));
		System.out.println("\"Hello\" compared to \"Heilo\" is " + "Hello".compareTo("Heilo"));
	}

}
