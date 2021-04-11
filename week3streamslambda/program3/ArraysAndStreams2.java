package week3streamslambda.program3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndStreams2
{
   public static void main(String[] args)
   {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
      List<String> words = Arrays.asList(strings);

      // display original strings
      System.out.printf("Original strings: %s%n", Arrays.asList(strings));

      // strings in uppercase
      System.out.printf("strings in uppercase: %s%n",
         Arrays.stream(strings)
         		.map(s-> s.toUpperCase())
         		.collect(Collectors.toList()));
     

      // strings greater than "m" (case insensitive) sorted ascending
      System.out.printf("strings greater than m sorted ascending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("m") > 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .collect(Collectors.toList()));

      // strings greater than "m" (case insensitive) sorted descending
      System.out.printf("strings greater than m sorted descending: %s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("m") > 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .collect(Collectors.toList()));
      
      //CountWords method
       countWords(words, 'e', 'u',  5);
      	
       
	
   }
	public static void countWords(List<String> words, char c, char d, int len) {		
		words.toArray();		
		System.out.printf("Count: %d", words.stream()
		 .filter(w-> w.contains(""+c))
	     .filter(w-> !w.contains(""+ d))
	     .filter(w-> (5 == w.length())).count());

   }
} // end class ArraysAndStreams2


