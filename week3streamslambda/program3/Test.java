package week3streamslambda.program3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		String[] strings = 
	         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

	      // display original strings
	     System.out.println(Arrays.asList(strings));

	      // strings in uppercase
	     System.out.printf("String UpperCase: %s%n",
	     Arrays.stream(strings).map(e-> e.toUpperCase()).collect(Collectors.toList()));

	      // strings greater than "m" (case insensitive) sorted ascending
	     
	     System.out.printf("String UpperCase: %s%n",
	    	     Arrays.stream(strings).filter(e-> e.compareToIgnoreCase("m")>0).sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));
	      

	      // strings greater than "m" (case insensitive) sorted descending
	     System.out.printf("String UpperCase: %s%n",
	    		 Arrays.stream(strings).filter(e-> e.compareToIgnoreCase("m")>0).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList()));
	     
		
	}

}
