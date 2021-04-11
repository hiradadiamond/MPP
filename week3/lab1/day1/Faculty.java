package week3.lab1.day1;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends Person {
	private double salary;
	private List<Course> courses;
	
	Faculty(String name, String phone, int age, double salary){
		super(name,phone,age);
		this.salary = salary;
		courses = new ArrayList<Course>();
		int S = Integer.MAX_VALUE;
	}
	
	@Override
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public int getTotalUnits() {
		int totalUnits = 0;
		for(Course course: courses) {
			totalUnits += course.getUnits();
		}
		return totalUnits;
	}

	@Override
	public String toString() {
		return "Faculty [salary=" + salary + ", courses=" + courses + "]";
	}

	@Override
	public void myabstract() {
		System.out.println("My Abstract Method");
	}
}
