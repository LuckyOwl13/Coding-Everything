package v1.controls;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import v1.models.Catalog;
import v1.models.Course;
import v1.models.Department;
import v1.models.Faculty;
import v1.models.Hybrid;
import v1.models.Instructor;
import v1.models.Online;
import v1.models.Section;
import v1.models.Student;
import v1.models.Term;
import v1.models.Timeslot;
import v1.models.Traditional;
import v1.views.RegistrarGUI;

public class Driver {
	static Random RAND = new Random(1337);
	public static void main(String[] args) {
		
		Faculty facult = new Faculty();
		Term ter = new Term("Fall 2017");
		Catalog catalo = new Catalog();
		Student studen = new Student(123,"Hollowniczky");
		
		createInstructors(facult);
		createCourses(catalo);
		createSections(facult,catalo,ter);
		
		new SectionTally(ter, studen);
	}
	
	
	
	private static void createInstructors(Faculty facult){
		facult.addInstructor(new Instructor(123,"Mathas"));
		facult.addInstructor(new Instructor(124,"Urmum"));
		facult.addInstructor(new Instructor(125,"Bartend"));
		facult.addInstructor(new Instructor(126,"Spelltome"));
		facult.addInstructor(new Instructor(127,"Gotheem"));
		facult.addInstructor(new Instructor(128,"Gitgud"));
		facult.addInstructor(new Instructor(129,"McElwee"));
		facult.addInstructor(new Instructor(120,"Myers"));
		facult.addInstructor(new Instructor(131,"Kaleidiscope"));
		facult.addInstructor(new Instructor(132,"Brown"));
		facult.addInstructor(new Instructor(133,"Smith"));
	}
	
	private static void createCourses(Catalog catalo){
		catalo.addCourse(new Course("ART 321","Look At This Art",Department.ART));
		catalo.addCourse(new Course("ART 666","Get A Load of This Art",Department.ART));
		catalo.addCourse(new Course("BIO 101","Life n Stuff",Department.BIOLOGY));
		catalo.addCourse(new Course("CHEM 103","Atoms. Yeah",Department.CHEMISTRY));
		catalo.addCourse(new Course("CHEM 104","Also Molecules",Department.CHEMISTRY));
		catalo.addCourse(new Course("CHEM 105","Maybe also: Bonds?",Department.CHEMISTRY));
		catalo.addCourse(new Course("CSCI 102","(Not) Digital 1",Department.COMPUTER_SCIENCE));
		catalo.addCourse(new Course("CSCI 105","IOOP",Department.COMPUTER_SCIENCE));
		catalo.addCourse(new Course("CSCI 202","OOPDA",Department.COMPUTER_SCIENCE));
		catalo.addCourse(new Course("CSCI 404","CLASS NOT FOUND",Department.COMPUTER_SCIENCE));
		catalo.addCourse(new Course("ECON 101","How Am Money ??",Department.ECONOMICS));
		catalo.addCourse(new Course("ECON 201","/I/ Am Money",Department.ECONOMICS));
		catalo.addCourse(new Course("ENGL 101","Comp 1",Department.ENGLISH));
		catalo.addCourse(new Course("ENGL 102","Comp 2",Department.ENGLISH));
		catalo.addCourse(new Course("HIST 101","The Past: Exists",Department.HISTORY));
		catalo.addCourse(new Course("HIST 102","Now Is Also The Past",Department.HISTORY));
		catalo.addCourse(new Course("HIST 201","Get Hecked, Greece",Department.HISTORY));
		catalo.addCourse(new Course("MUS 101","Make At Least One Note",Department.MUSIC));
		catalo.addCourse(new Course("MUS 102","Make Another One. Harmony",Department.MUSIC));
		catalo.addCourse(new Course("MATH 123","Calc 1",Department.MATHEMATICS));
		catalo.addCourse(new Course("PHIL 101","What Truly Is Philosophy?",Department.PHILOSOPHY));
		catalo.addCourse(new Course("PHYS 101","Hit Shit Together",Department.PHYSICS));
		catalo.addCourse(new Course("PSYC 234","Rory's Course",Department.PSYCHOLOGY));
		catalo.addCourse(new Course("PSYC 235","More About Rory",Department.PSYCHOLOGY));
		catalo.addCourse(new Course("PSYC 236","Gitting Gud",Department.PSYCHOLOGY));
		catalo.addCourse(new Course("PSYC 237","Best Department's Best Course",Department.PSYCHOLOGY));
	}
	
	private static void createSections(Faculty facult,Catalog catalo,Term ter){
				
		int instructorInt = RAND.nextInt(facult.getInstructors().size());
		for(int courseInt = 0;courseInt < catalo.getCourses().size();++courseInt){
			if (instructorInt >= facult.getInstructors().size()) instructorInt = 0;
			
			ter.addSection(new Traditional(facult.getInstructors().get(RAND.nextInt(facult.getInstructors().size())),
					catalo.getCourses().get(courseInt),pickTimeSlot(),pickTimeSlot()));
			ter.addSection(new Hybrid(facult.getInstructors().get(RAND.nextInt(facult.getInstructors().size())),
					catalo.getCourses().get(courseInt),pickTimeSlot()));
			ter.addSection(new Online(facult.getInstructors().get(RAND.nextInt(facult.getInstructors().size())),
					catalo.getCourses().get(courseInt)));
			}
	}
	
	
	private static DayOfWeek pickRandomDay(){
		return DayOfWeek.of(RAND.nextInt(5) + 1);
	}	
	private static LocalTime[] pickRandomStartTime(){
		int startHour = RAND.nextInt(11) + 8;
		LocalTime[] times = new LocalTime[]{LocalTime.of(startHour, 0),LocalTime.of(startHour, 50)};
		return times;
	}
	private static Timeslot pickTimeSlot(){
		LocalTime[] times = pickRandomStartTime();
		return new Timeslot(pickRandomDay(),times[0],times[1]);
	}
	
	
	
	
	
}
