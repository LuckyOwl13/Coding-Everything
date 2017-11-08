package v1.models;

public class Course {
	private String courseNumber;
	private String title;
	private Department department;
	
	public Course(String courseNumber, String title, Department department) {
		this.courseNumber = courseNumber;
		this.title = title;
		this.department = department;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
	
	
}
