
public class Driver {

	public static void main(String[] args) {
		First firs = new First(-11);
		System.out.println(firs.sumOfDigits());
		
		Second secon = new Second(new int[]{2,3,4,5,67,7,2,5654,6354,656,5,65,3});
		secon.printArray(true);
		secon.printArray(false);
	
		Fourth fourt = new Fourth(100);
		System.out.println(fourt.sumToN());
		
		Fifth fift = new Fifth(6);
		System.out.println(fift.productToN());
	}

}
