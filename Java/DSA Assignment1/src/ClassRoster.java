import java.util.HashSet;

public class ClassRoster {

	private HashSet<Student> students;

	public ClassRoster() {
		this.students = new HashSet<Student>();;
	}

	/**
	 * @return the students
	 */
	public HashSet<Student> getStudents() {
		return students;
	}

	public void add(Student studen){
		students.add(studen);
	}		


}




