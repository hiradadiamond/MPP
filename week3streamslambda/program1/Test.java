package week3streamslambda.program1;

import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		 int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
		// display original values
		 IntStream.of(values).forEach(e-> System.out.print(e));
		 System.out.println();
	    
	      // count, min, max, sum and average of the values
	   System.out.println("Count: "+ IntStream.of(values).count());
	   
	   System.out.println("Min: "+ IntStream.of(values).min().getAsInt());
	   
	   System.out.println("Max: "+ IntStream.of(values).max().getAsInt());
	   
	   System.out.println("Average: "+ IntStream.of(values).average().getAsDouble());

	

	      // sum of values with reduce method
	  System.out.println("Reduced Sum: "+ IntStream.of(values).reduce(0, (x,y)-> x+y));
	  
	      // sum of squares of values with reduce method

	   System.out.println("Reduced Square: "+ IntStream.of(values).reduce(0, (x,y)-> x + y));
	      // product of values with reduce method
	   System.out.println("Reduced Square: "+ IntStream.of(values).reduce(1, (x,y)-> x * y));

	      
	      // even values displayed in sorted order
	   IntStream.of(values).filter(e-> e%2==0).sorted().forEach(e-> System.out.println(e));

	//   Declarative style  WHAT  -  Functional programming style  
	   
	      // odd values multiplied by 10 and displayed in sorted order
	    IntStream.of(values).filter(e-> e%2!=0).map(e-> e*10).sorted().forEach(x->System.out.println(x));

	      // sum range of integers from 1 to 10, exlusive
	    System.out.println(IntStream.range(1, 10).sum());

	      // sum range of integers from 1 to 10, inclusive
	    System.out.println(IntStream.rangeClosed(1, 10).sum());

	
		 
	}

}
