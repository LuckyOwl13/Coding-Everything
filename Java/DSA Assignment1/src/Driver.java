import java.io.*;
import java.util.Iterator;

public class Driver {
	/** Name of the file to be used **/
	private static String fileName = "C:/Users/Keenan/workspace/DSA Assignment1/in.txt";
	/** Collection of Student objects **/
	private static ClassRoster roster;
	/** Reader used to receive input**/
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		roster = new ClassRoster();
		printMenu();
	}


	public static void printMenu() throws NumberFormatException, IOException{

		System.out.print("\nSelect from the following menu:"
				+ "\n\t0. Exit the application"
				+ "\n\t1. Add a student."
				+ "\n\t2. Delete a student."
				+ "\n\t3. Print content of ClassRoster."
				+ "\n\t4. Search ClassRoster for student(s)."
				+ "\n\t5. Display students by level."
				+ "\nMake you menu selection now: ");
		
		int select = Integer.parseInt(br.readLine());
		
		System.out.println(select);

		switch(select){
		case 0: System.exit(0);
		break;
		case 1: addStudent();
		break;
		case 2: deleteStudent();
		break;
		case 3: printRoster();
		break;
		case 4: searchStudent();
		break;
		case 5: searchGrade();
		break;
		default: System.out.println("Error, please use a valid input");
		break;
		}
		printMenu();
	}




	private static void addStudent() throws IOException { // option 1
		String[] newStu = new String[9];
		System.out.print("You are now adding a new student to your ClassRoster."
				+ "\n\tEnter the first name: ");
		String temp = br.readLine();
        System.out.print(temp);
        newStu[0] = temp;
		System.out.print("\n\tEnter the last name: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[1] = temp;
		System.out.print("\n\tEnter the SSN: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[2] = temp;
		System.out.print("\n\tEnter the birth day: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[3] = temp;
		System.out.print("\n\tEnter the birth month: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[4] = temp;
		System.out.print("\n\tEnter the birth year: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[5] = temp;
		System.out.print("\n\tEnter the number of credits: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[6] = temp;
		System.out.print("\n\tEnter the major: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[7] = temp;
		System.out.print("\n\tEnter the minor: ");
		temp = br.readLine();
        System.out.print(temp);
        newStu[8] = temp;

		Student studen = new Student(newStu[0],		//first name
				newStu[1], 		//last name
				newStu[2], 		//ssn
				newStu[4] + " " + newStu[3] + " " + newStu[5], 	//birthday (over three lines)
				Integer.parseInt(newStu[6]), // credits
				newStu[7], 		// major
				newStu[8]);	// minor

		roster.add(studen);

		System.out.println("\nThe student " + studen.getFullName() + "  has been registered!");
	} // end method

	private static void deleteStudent() throws IOException { // option 2
		System.out.print("You are now deleting a student from your ClassRoster."
				+ "\n\tEnter last name of the student to delete : ");
		String lastName = br.readLine();
		System.out.print(lastName + "\n");
		
		for(Iterator<Student> it = roster.getStudents().iterator(); it.hasNext(); ){
			Student stu = it.next();
			if (stu.getLastName().equals(lastName)){
				System.out.print("Do you want to delete " + stu.getFullName() + " for the ClassRoster(Y/N)?");
				if (br.readLine().equals("Y")){				
					System.out.print("\nY\n");
					it.remove();
					System.out.println("The student " + stu.getFullName() + " has been deleted.");
				}else {System.out.print("\nN\n");} // end if
			} // end if
		} // end for

	} // end method

	private static void printRoster() { // option 3
		if (roster.getStudents().size() <= 0) System.out.println("\n\tYour ClassRoster has no registered students.");
		else{ // more than zero students in class roster
			System.out.println("\n\tYour ClassRoster has the following "
					+ roster.getStudents().size() + " registered students:");

			for (Student s : roster.getStudents()){
				System.out.println(s.getFullName() + ":"
						+ "\n\t SSN " + s.getSsn()
						+ "\n\t birthday " + s.getBirthday()
						+ "\n\t credits earned " + s.getCredits()
						+ "\n\t major " + s.getMajor()
						+ "\n\t minor " + s.getMinor());
				System.out.println();
			}
		}
	}

	private static void searchStudent() throws IOException { // option 4
		System.out.print("\tEnter last name of the student to search for: ");
		String lastName = br.readLine();
		System.out.println(lastName + "\n");

		for(Iterator<Student> it = roster.getStudents().iterator(); it.hasNext(); ){
			Student stu = it.next();
			if (stu.getLastName().equals(lastName)){
				System.out.println(stu.getFullName() + ":"
						+ "\n\t SSN " + stu.getSsn()
						+ "\n\t birthday " + stu.getBirthday()
						+ "\n\t credits earned " + stu.getCredits()
						+ "\n\t major " + stu.getMajor()
						+ "\n\t minor " + stu.getMinor());
				System.out.println();
			} // end if
		} // end for

	}

	private static void searchGrade() throws IOException { // option 5
		System.out.print("Enter level to display:(freshman/sophomore/junior/senior) ");
		String grade = br.readLine();
		System.out.println(grade);
		
		int[] creditRange = new int[2];
		switch(grade){
		case "freshman": creditRange[0] = 0;
							creditRange[1] = 23;
		break;
		case "sophomore": creditRange[0] = 24;
							creditRange[1] = 57;
		break;
		case "junior": creditRange[0] = 58;
							creditRange[1] = 89;
		break;
		case "senior": creditRange[0] = 90;
							creditRange[1] = Integer.MAX_VALUE;
		break;
		}
		
		for(Iterator<Student> it = roster.getStudents().iterator(); it.hasNext(); ){
			Student stu = it.next();
			if (creditRange[0] < stu.getCredits() || stu.getCredits() < creditRange[1]){
				System.out.println(stu.getFullName() + ":"
						+ "\n\t SSN " + stu.getSsn()
						+ "\n\t birthday " + stu.getBirthday()
						+ "\n\t credits earned " + stu.getCredits()
						+ "\n\t major " + stu.getMajor()
						+ "\n\t minor " + stu.getMinor());
				System.out.println();
			} // end if
		} // end for
	}












} // end class
