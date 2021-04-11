package week3.lab1.day1;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	private double gpa;
	private List<Course> courses;

	Student(String name, String phone, int age, double gpa) {
		super(name, phone, age);
		this.gpa = gpa; 
		this.courses = new ArrayList<Course>();
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void addCourse(Course course) {
		course.addStudents(this);
		courses.add(course);
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public int getTotalUnits() {
		int totalUnits = 0;
		for(Course course: courses) {
			totalUnits += course.getUnits();
		}
		return totalUnits;
	}
	
	@Override
	public double getSalary() {
		return 0;
	}
}
