package week3.lab1.day1;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String number;
	private String title;
	private int units;
	private Faculty faculty;
	private List<Student> studentList;
	
	
	Course(String number, String title, int units, Faculty faculty) {
		this.number = number;
		this.title = title;
		this.units = units;
		this.faculty = faculty;
		this.studentList = new ArrayList<Student>();
	}
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Number: " + this.getNumber() + ", ");
		output.append("Title: " + this.getTitle() + ", ");
		output.append("Units: " + this.getUnits()+ ", ");
		return output.toString();
	}
	
	public void addStudents(Student s) {
		studentList.add(s);
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	

}
