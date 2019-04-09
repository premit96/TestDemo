/**
 * 
 */
package StatAnalysis;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/**
 * @author premit
 *
 */

public class Statistics {
	/**default constructor for Statistics class*/
	  private static int [] unmodifiedNumbers, numbers;

	   public Statistics()
	  {
	     unmodifiedNumbers = new int [1000];
	  }

	    /**reads numbers from files and puts them into an array*/
	    public void readFromFile()
	  {

	      try
	      {

	        Scanner in = new Scanner(new File("random_sets.txt"));
	        int x;
	        for(x = 0; in.hasNextInt(); x++)
	            unmodifiedNumbers[x] = in.nextInt();
	        numbers = new int [x];
	        for(int y = 0; y < x; y++)
	            numbers[y] = unmodifiedNumbers[y];
	      }
	      catch(Exception e)
	      {
	          System.out.println(e.getMessage());
	     }
	    }

	    /**calculates and returns and prints average*/
	    public static double avg()
	    {
	      double average = 0;
	     try
	    {
	        Scanner in = new Scanner(new File("random_sets.txt"));
	        double total = 0;

	        for(int x = 0; x < numbers.length; x++)  
	            total += x;
	        average = (double)total/numbers.length;
	        System.out.println(average);

	      }
	      catch(Exception c)
	      {
	          System.out.println(c.getMessage());
	      }
	      return average;
	    }

	    /**calculates and displays mode*/
	     public static void mode()
	   { 

	     int count = 0, mode = -1, maxCount = 0;
	    try 
	    {
	       count = 0;
	       Scanner in = new Scanner(new File("random_sets.txt"));
	      for(int x = 0; x < numbers.length; x++)
	       {

	        for(int y = 0; y < numbers.length; y++)
	            if(numbers[y] == numbers[x])
	                count++;
	        if(count > maxCount)
	        {
	            mode = numbers[x];
	            maxCount = count;
	        }
	     }
	      }
	      catch(Exception b)
	    {
	        System.out.println(b.getMessage());
	    }
	    System.out.println(mode);
	  }

	  /**calculates and displays standard deviation*/
	   public static void stddev()
	  {
	  double stddev = 0;
	  long total = 0;
	  double average = avg();

	    try
	    {
	        Scanner in = new Scanner(new File("random_sets.txt"));
	      for(int x = 0; x < numbers.length; x++)
	        total += Math.pow((average - numbers[x]), 2);
	      System.out.println(Math.sqrt((double)total/(numbers.length - 1)));
	    }
	   catch(Exception d)
	   {
	       System.out.println(d.getMessage());
	   }
	  System.out.println(stddev);
	 }
	 }