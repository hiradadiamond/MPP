package lab1.level1;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends Person {
	private double salary;
	private List<Course> courses;
	
	Faculty(String name, String phone, int age, double salary){
		super(name,phone,age);
		this.salary = salary;
		courses = new ArrayList<Course>();
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
}
