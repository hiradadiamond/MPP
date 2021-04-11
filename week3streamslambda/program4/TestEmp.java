package week3streamslambda.program4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestEmp {
	public static void main(String[] args) {
		// initialize array of Employees
	      Employee[] employees = {
	         new Employee("Jason", "Red", 5000, "IT"),
	         new Employee("Ashley", "Green", 7600, "IT"),
	         new Employee("Matthew", "Indigo", 3587.5, "Sales"),
	         new Employee("James", "Indigo", 4700.77, "Marketing"),
	         new Employee("Luke", "Indigo", 6200, "IT"),
	         new Employee("Jason", "Blue", 3200, "Sales"),
	         new Employee("Wendy", "Brown", 4236.4, "Marketing")};
	      
	      Stream.of("one", "two", "three", "four")
	         .filter(e -> e.length() > 3)
	         .peek(e -> System.out.println("Filtered value: " + e))
	         .map(String::toUpperCase)
	         .peek(e -> System.out.println("Mapped value: " + e))
	         .collect(Collectors.toList());
 

	      

	      // get List view of the Employees
	    

	      // display all Employees
	   
	        //A method reference.
	      
	      // Predicate (boolean-valued function) that returns true for salaries 
	      //in the range $4000-$6000
	     
	      // Display Employees with salaries in the range $4000-$6000
	      // sorted into ascending order by salary
	      

	      // Display first Employee with salary in the range $4000-$6000
	      

	      // Functions for getting first and last names from an Employee
	      
	    

	      // Comparator for comparing Employees by first name then last name
	      

	      // sort employees by last name, then first name 
	     

	      // sort employees in descending order by last name, then first name
	     
	        

	      // display unique employee last names sorted
	     
	      // display only first and last names
	     

	      // group Employees by department
	     

	      // count number of Employees in each department
	     

	/*  Output looks something like :

	        HR  4
	        IT  8
	        Sales  12
	*/


	      // sum of Employee salaries with DoubleStream sum method
	     
	      // calculate sum of Employee salaries with Stream reduce method
	    

	      // average of Employee salaries with DoubleStream average method
	     
	            
		
	}

}
