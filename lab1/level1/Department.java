package lab1.level1;

import java.util.ArrayList;
import java.util.List;

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
		double totalSalary = 0;
		for (Person p : persons) {
			totalSalary += p.getSalary();
		}
		return totalSalary;
	}

	// ****** Level1- using instanceof and getClass().getSimpleName()***//
//	public double getTotalSalary() {
//		double totalSalary = 0;
//		for (Person p : persons) {
//			if (p instanceof Faculty) {
//				Faculty f = (Faculty) p;
//				totalSalary += f.getSalary();
//			}
//			if (p.getClass().getSimpleName().equals("Staff")) {
//				Staff s = (Staff) p;
//				totalSalary += s.getSalary();
//			}
//		}
//		return totalSalary;
//	}

	public void showAllMembers() {
		StringBuilder output = new StringBuilder();
		output.append(this.getName() + "\n");
		for (Person p : persons) {
			output.append(p.getClass().getSimpleName() + "- ");
			output.append(p);
			if (p instanceof Student) {
				Student stu = (Student) p;
				output.append(" GPA: " + stu.getGpa());
			}
			output.append("\n");
		}
		System.out.println(output.toString());
	}

	public void unitsPerFaculty() {
		StringBuilder unitsPerFaculty = new StringBuilder();
		for (Person p : persons) {
			if (p instanceof Faculty) {
				Faculty f = (Faculty) p;
				unitsPerFaculty.append(" Faculty Name: ").append(f.getName()).append("Units: ")
						.append(f.getTotalUnits()).append("\n");
			}
		}
		System.out.println(unitsPerFaculty.toString() + "\n");
	}

	// It works for both StaffStudent and Students who will take course
	public void facultyStudents(String facultyName) {
		StringBuilder studentList = new StringBuilder();
		for (Person p : persons) {
			if (p instanceof Faculty) {
				Faculty f = (Faculty) p;
				if (f.getName().equals(facultyName)) {
					f.getCourses().forEach(c -> {
						studentList.append(c.getNumber() + "\n");
						c.getStudentList().forEach(s -> {
							studentList.append(" " + s.getClass().getSimpleName()).append(": " + s.getName())
									.append("\n");
						});
					});
					System.out.println(studentList.toString());
				}
			}
		}
	}

}
