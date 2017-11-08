package v1;

import java.util.HashMap;
import java.util.Scanner;

public class PersonApp 
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter person's first name" + "\n");
		String firstNameString = sc.nextLine();
		System.out.print("Enter person's middle name" + "\n");
		String middleNameString = sc.nextLine();
		System.out.print("Enter person's lastname" + "\n");
		String lastNameString = sc.nextLine();
		String emailString;
		do {
			System.out.println("Enter person's email");
			emailString = sc.nextLine();
		}
		while (!Person.validateEmail(emailString));
		
		String ssnString;
		do {
			System.out.print("Enter person's SSN in ###-##-#### format" + "\n");
			ssnString = sc.nextLine();
		}
		while (!Person.validateSsn(ssnString));
		
		Integer ageInt;
		do {
			System.out.print("Enter person's age" + "\n");
			ageInt = sc.nextInt();
		}
		while (!Person.validateAge(ageInt));
		sc.close();
		
		System.out.println();
		
		Person bleep = new Person(1,firstNameString,middleNameString,lastNameString,emailString,ssnString,ageInt);
		Person creep = new Instructor(3,"This","Is","A Guy","aguyT@rowan.edu","123-65-4321",47,"Comp Sci");
		Person sweep = new Student(5,"Test","Tester","Testee","testt@hotmail.org","111-11-1121",23,"Turning Up");
		
		HashMap<Integer,Person> personStore = new HashMap<Integer,Person>();
		personStore.put(bleep.getId(), bleep);
		personStore.put(creep.getId(), creep);
		personStore.put(sweep.getId(), sweep);
		
		for (Integer key : personStore.keySet())
		{
			personStore.get(key).isOldest();
		}
		
		for (Integer key : personStore.keySet())
		{
			Person person = personStore.get(key);
			System.out.println(person + " (" + person.getType() + ")");
			System.out.println(person.getEmailDomain());
			System.out.println(person.getLast4SSN());
			System.out.println(person.isOldest());
			System.out.print(person.getStudies());
			System.out.println();
			
		}
	}
}