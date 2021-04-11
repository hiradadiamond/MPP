package week3.lab1.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Department {
	private String name;
	private List<Person> persons;

	Department(String name) {
		this.name = name;
		persons = new ArrayList<Person>();
	}

	public void addPerson(Person p) {
		persons.add(p);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ******* Level1- Polymorphic way *********//
	public double getTotalSalary() {		
		double total= persons.stream()
				.mapToDouble(Person::getSalary)
				.reduce(0,(val1, val2)-> val1+ val2);
		return total;
	}



	public void showAllMembers() {
		persons.stream().forEach(System.out::println);
	}

	public void unitsPerFaculty() {
		persons.stream().filter(p-> p instanceof Faculty)
		.map(e-> {
			Faculty  f= (Faculty)e;
			return f;		
		})
		.peek(e -> System.out.println(e.getName()))
		.forEach(e-> System.out.println(e.getName()+ " "+ e.getTotalUnits()));
	}

	// It works for both StaffStudent and Students who will take course
	public void facultyStudents(String facultyName) {
			List<List<Course>> courses =  persons.stream()
				.filter(p -> p instanceof Faculty)
				.map(e-> {
					Faculty  f = (Faculty)e;					
					return f;		
				})
				.peek(e -> System.out.println("Mapped value: " + e))
				.filter(f-> f.getName().equals(facultyName))
				.map(f -> f.getCourses())
				.peek(e -> System.out.println("Mapped value 2: " + e))
				.collect(Collectors.toList());
		
				
	}

}
