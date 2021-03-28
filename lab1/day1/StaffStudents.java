package lab1.day1;

import java.time.LocalDate;

public class StaffStudents extends Student {
	private Staff staff;
	private LocalDate startingDate;
	
	
	StaffStudents(String name, String phone, int age, double salary, double gpa) {
		super(name,phone,age,gpa);
		this.staff =  new Staff(name,phone,age,salary);
	}
	
	@Override
	public void addCourse(Course course) {
		this.startingDate = LocalDate.now();
		super.addCourse(course);
	}
	
	@Override
	public double getSalary() {
		return this.staff.getSalary();
	}

}
