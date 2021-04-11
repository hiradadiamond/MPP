package week3streamslambda.program4;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmployees {
	public static void main(String[] args) {
		// initialize array of Employees
		Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"), new Employee("Ashley", "Green", 7600, "IT"),
				new Employee("Matthew", "Indigo", 3587.5, "Sales"),
				new Employee("James", "Indigo", 4700.77, "Marketing"), new Employee("Luke", "Indigo", 6200, "IT"),
				new Employee("Jason", "Blue", 3200, "Sales"), new Employee("Wendy", "Brown", 4236.4, "Marketing") };

		// get List view of the Employees
		List<Employee> list = Arrays.asList(employees);

		// display all Employees
		System.out.println("Complete Employee list:");
		list.stream().forEach(System.out::println); // A method reference.

		// Predicate (boolean-valued function) that returns true for salaries
		// in the range $4000-$6000
		Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

		// Display Employees with salaries in the range $4000-$6000
		// sorted into ascending order by salary
		System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");

		list.stream().filter(fourToSixThousand).sorted(Comparator.comparing(Employee::getSalary))
				.forEach(System.out::println);

		// Display first Employee with salary in the range $4000-$6000
		System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
				list.stream().filter(fourToSixThousand).findFirst().get());

		// Functions for getting first and last names from an Employee
		Function<Employee, String> byFirstName = Employee::getFirstName;
		Function<Employee, String> byLastName = Employee::getLastName;
		Function<Employee, String> byFullName = Employee::getFullName;
		Function<Employee, Double> bySalary = Employee::getSalary;

		// Comparator for comparing Employees by first name then last name
		Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

		// sort employees by last name, then first name
		System.out.printf("%nEmployees in ascending order by last name then first:%n");
		list.stream().sorted(lastThenFirst).forEach(System.out::println);

		// sort employees in descending order by last name, then first name
		System.out.printf("%nEmployees in descending order by last name then first:%n");
		list.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

		// display unique employee last names sorted
		System.out.printf("%nUnique employee last names:%n");
		list.stream().map(Employee::getLastName).distinct().sorted().forEach(System.out::println);

		// display only first and last names
		System.out.printf("%nEmployee names in order by last name then first name:%n");
		list.stream().sorted(lastThenFirst).map(Employee::getName).forEach(System.out::println);

		// group Employees by department
		System.out.printf("%nEmployees by department:%n");
		Map<String, List<Employee>> groupedByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		groupedByDepartment.forEach((department, employeesInDepartment) -> {
			System.out.println(department);
			employeesInDepartment.forEach(employee -> System.out.printf("   %s%n", employee));
		});

		// count number of Employees in each department
		System.out.printf("%nCount of Employees by department:%n");

		Map<String, Long> employeeCountByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));

		employeeCountByDepartment
				.forEach((department, count) -> System.out.printf("%s has %d employee(s)%n", department, count));

		/*
		 * Output looks something like :
		 * 
		 * HR 4 IT 8 Sales 12
		 */

		// sum of Employee salaries with DoubleStream sum method
		System.out.printf("%nSum of Employees' salaries (via sum method): %.2f%n",
				list.stream().mapToDouble(Employee::getSalary).sum());

		// calculate sum of Employee salaries with Stream reduce method
		System.out.printf("Sum of Employees' salaries (via reduce method): %.2f%n",
				list.stream().mapToDouble(Employee::getSalary).reduce(0, (value1, value2) -> value1 + value2));

		// average of Employee salaries with DoubleStream average method
		System.out.printf("Average of Employees' salaries: %.2f%n",
				list.stream().mapToDouble(Employee::getSalary).average().getAsDouble());

		System.out.printf("%n count the employee of which last name starts with B: %d",
				list.stream().filter(e -> e.getLastName().startsWith("B")).count());

		System.out.println();
		//Print all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.   %n");
;
		Comparator<Employee> nameCompare = Comparator.comparing(byFullName).thenComparing(bySalary);
		System.out.printf(
				"%n Print all of the Employee objects whose last name begins with the letter  ‘B’  in sorted order.   %n");
		list.stream()
			.filter(e -> e.getLastName().startsWith("B"))
			.sorted(nameCompare)
			.collect(Collectors.toList())
			.forEach(System.out::println);

		System.out.println();

		//change their first name and last name to be All capital letters of employee whose lastname starts with B
//		list.stream()
//			.filter(e -> e.getLastName().startsWith("B"))
//			.map(e -> {
//				e.setFirstName(e.getFirstName().toUpperCase());
//				e.setLastName(e.getLastName().toUpperCase());
//				return e;		
//			})
//			.collect(Collectors.toList())
//			.forEach(System.out::println);

		list.stream()
			.map(e -> {
				Employee copyEmp = e;
				if(copyEmp.getLastName().startsWith("B")) {
					copyEmp.setFirstName(e.getFirstName().toUpperCase());
					copyEmp.setLastName(e.getLastName().toUpperCase());
//					try {
//						copyEmp = (Employee) e.clone();
//						copyEmp.setFirstName(copyEmp.getFirstName().toUpperCase());
//						copyEmp.setLastName(copyEmp.getLastName().toUpperCase());
//						} 
//					catch (CloneNotSupportedException e2) {
//						e2.printStackTrace();
//						}		
				}
				
				return copyEmp;
			})
			.forEach(System.out::println);

	System.out.println();
		//last name begins with the letter  ‘B’,  then capitalize all the letters in the last name. 
		System.out.println("Print all Employee whose last name starts with B in Cpaital letters only last names");
		list.stream()
			.map(e -> {
				if (e.getLastName().startsWith("B"))
					e.setLastName(e.getLastName().toUpperCase());
				return e;
			})
			.forEach(System.out::println);
		
		
			System.out.println();

		//Use the  Collectors.joining  method to print out All Employee objects.  
		// Convert elements to strings and concatenate them, separated by commas
		System.out.println("Using Collectors.joining print all employees: 4.1");
		String empList = list.stream().map(Employee::toString).collect(Collectors.joining());
		System.out.println(empList);
		
		System.out.println("Using Collectors.joining print all employees: 4.2");
		String emps = list.stream().map(Employee::toString).collect(Collectors.joining(", "));
		System.out.println(emps);
		
		Stream<String> nameStream = list.stream().map(Employee::getFirstName);
		Stream<String> lastnameStream = list.stream().map(Employee::getLastName);
//		Stream.concat(nameStream, lastnameStream).collect(Collectors.joining());
		

		System.out.println();
		// Print out all of the Employee objects’ last names, whose last name begins
		// with the letter ‘I’ in sorted order, and get rid of all the duplicates. Print
		// out only the last names.
		System.out.println("Questions no 5: ");
		Set<String> set = list.stream()
				.filter(e -> e.getLastName().startsWith("I"))
				.map(Employee::getLastName)
				.sorted()
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);
		
		//Print out the average of all the salaries
		System.out.println("Question No: 6");
		double avg = list.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary))
				.getAverage();
		System.out.printf(" Average Salaray: $%,.2f", avg);		
		System.out.printf(" %n Using collector's method: Total Salary of all Employee: $%,.2f",
				list.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary))
				.getSum());

		//Use the  ‘reduce’  method to print out the total salary of all employees
		System.out.println("Question No: 7");
		System.out.println("Using reduce method to get total salary.");
		System.out.printf(" %n Total Salary of all Employee: $%,.2f",
				list.stream()
				.mapToDouble(Employee::getSalary)
				.reduce(0, (x, y) -> (x + y)));

		//Print out only the first names of all the employees.  Use the  ‘map’  method to accomplish this.  
		System.out.println();
		System.out.println("Question no : 8");
		list.stream()
			.map(Employee::getFirstName)
			.forEach(System.out::print);

		//Create an infinite stream of even numbers (0, 2, 4, …) and then, eventually print out only the first 20 even numbers from this stream.  
		System.out.println();
		System.out.println("Question No: 9");
		Stream.iterate(0, n -> (n + 2))
			.limit(20)
			.forEach(System.out::println);
		
		System.out.println();
		
		//***************************************************************//

		System.out.println(" Level 3: questionNo:6.a ");
		System.out.println();
		Map<String, Double> avgSalaryByDept = list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, 
										Collectors.averagingDouble(Employee::getSalary)));

		avgSalaryByDept.forEach((s, sal) -> {
			System.out.printf(" %s Department has $%.2f of average salary.%n", s, sal);
		});

		//Print out each department and the maximum salary for the department
		System.out.println();
		System.out.println(" Level 3- questionNo:6.b ");
		System.out.println();
		Map<String, Optional<Employee>> maxSalaryByDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		maxSalaryByDept.forEach((dept, emp) -> {
			Optional<Double> maxSalary = emp.map(Employee::getSalary);
			System.out.printf(" %s Department has $%.2f of average salary.%n", dept,
					maxSalary.orElse(0.0));			
		});
		
		
		System.out.println();
		System.out.print("Level 3: Question 6.c: ");
		//Print out each department and all of the employees who work at that department
		System.out.printf(" Employees by department:%n");
		Map<String, List<Employee>> empListByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		empListByDepartment.forEach((dept, employeeList)-> {
			System.out.println(dept + " Department");
			employeeList.forEach(aEmployee-> System.out.println("  " + aEmployee));
		});
		
		System.out.println();
		System.out.println("Practice Questions: Use find First employee'sSalary whose salary greater 4000 salary");	
		Optional<Employee> emp1 = list.stream()
			.filter(emp -> emp.getSalary()> 4000).findFirst();
			
		double getSalFirstGreaterThanFourThousnads = emp1.map(Employee::getSalary).orElse(null);
		System.out.println("emp name: "+ emp1.orElse(null) + "Sal: " + getSalFirstGreaterThanFourThousnads );
		
		System.out.println("Practice Questions: Use find Find any employee whose salary greater 4000 salary");	
		Optional<Employee> emp2 = list.stream()
			.filter(emp -> emp.getSalary()> 4000).findAny();
		if(emp2.isPresent())
			System.out.println("emp name: "+ emp2.get().getSalary());
		
	}// end main

} // end class ProcessingEmployees
