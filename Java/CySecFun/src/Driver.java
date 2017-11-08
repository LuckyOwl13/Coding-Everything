
public class Driver {

	public static void main(String[] args) {
		AuthenAttack aa = new AuthenAttack();
		
		aa.hashPassword256("this is a password");
		System.out.println(aa.getHashes());
	}	
	
	
	
}	// end Class









