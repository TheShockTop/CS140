/***************************************************************
 * file: Liu_ArrayProcessing.java
 * author: B. Liu
 * class: CS 140 - Introduction to Computer Science
 *
 * assignment: program 6
 * date last modified: 28 - Nov - 2016
 *
 * purpose: This program will read a file name from the end user and
 * check if the file is there. If it does not exist, the program will
 * terminate, otherwise, it continues. In the file, the first line
 * be read and provide the number of objects to be stored in the array.
 * Thereafter, the scanner object will read from file and into the array.
 * The program will then process the array, sorting the array in reverse
 * and determine the sum, mean, min, and max of said array. Furthermore,
 * it will then print out the evens in the array into the file even.out
 * and odds int the array into odd.out.
 *
 * @param int[] array array from main <- for all functions unless said otherwise
 *
 ****************************************************************/
import java.util.*;
import java.io.*;
import java.lang.*;
import java.lang.Object;

public class Liu_ArrayProcessing
{
	static final int DEBUG = 0;
	static int ARRAY_SIZE;
	
	//method: main
	//purpose: to assign array inputarray from inputdata() and to run print(inputarray)
	public static void main(String[] args) throws IOException
	{	
		int[] inputArray = inputData();
		print(inputArray);
	}
	
	//method: inputdata
	//purpose: asks user for file and tries to read the file. if not found then the program will exit.
	//         otherwise, it will create an array and store it by using the object scanner.
	//@return inputArray returns int array from file
	public static int[] inputData() throws FileNotFoundException, IOException
	{	
		int i;
		
		String stringFileInput;
		
		File fileInput = new File("null");
		
		Scanner console = new Scanner(System.in);
		
		System.out.printf("%nPlease enter a file name: ");
		
		stringFileInput = console.nextLine();
		fileInput = new File(stringFileInput);
		System.out.printf("%n");
		
		if (!fileInput.exists())
		{
			System.out.printf("File %s cannot be located. Please check your directory or spelling and try again.", stringFileInput);
			
			System.exit(1);
		}
		
		Scanner fileInputScanner = new Scanner(fileInput);
		ARRAY_SIZE = fileInputScanner.nextInt();
		
		int[] inputArray = new int[ARRAY_SIZE];
		
		for (i = 0; i < ARRAY_SIZE; i++) inputArray[i] = fileInputScanner.nextInt();
		
		if (DEBUG == 1)
		{
			for (i = 0; i < ARRAY_SIZE; i++)
			{
				System.out.printf("DEBUG: ARRAY %d in index %d.%n", inputArray[i], i);
			}
		}
		
		return inputArray;
	}
	
	//method: printArray
	//purpose: prints the array, 10 per line.
	public static void printArray(int[] array)
	{
		int i, j, k, l, m, n;
		
		//print 10 integers per line
		
		int tendivisor = (ARRAY_SIZE / 10);
		int modulo10 = (ARRAY_SIZE % 10);
		
		System.out.printf("Printing Array:%n");

		if (tendivisor == 0)
		{
			for (j = 0; j < modulo10; j++ ) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		
		if (tendivisor == 1)
		{
			for (j = 0; j < 10; j++ ) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			for(k = 10; k < 10 + modulo10; k++) System.out.printf("% 8d", array[k]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		
		else if (tendivisor == 2)
		{
			for (j = 0; j < 10; j++) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			for (k = 10; k < 20; k++) System.out.printf("% 8d", array[k]);
			System.out.printf("%n");
			for (l = 20; l < 20 + modulo10; l++) System.out.printf("% 8d", array[l]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		
		else if (tendivisor == 3)
		{
			for (j = 0; j < 10; j++) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			for (k = 10; k < 20; k++) System.out.printf("% 8d", array[k]);
			System.out.printf("%n");
			for (l = 20; l < 30; l++) System.out.printf("% 8d", array[l]);
			System.out.printf("%n");
			for (m = 30; m < 30 + modulo10; m++) System.out.printf("% 8d", array[m]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran printArray().%n DEBUG: ARRAY_SIZE: %d.%n", ARRAY_SIZE);
	}
	
	//method: reverseArray
	//purpose: prints the array but in reverse order
	public static void reverseArray(int[] array)
	{
		int i, j, k, l, m, n;
		
		//print 10 integers per line
		
		int tendivisor = (ARRAY_SIZE / 10);
		int modulo10 = (ARRAY_SIZE % 10);
		
		System.out.printf("Printing Reversed Array:%n");
		
		if (tendivisor == 0)
		{
			for (j = ARRAY_SIZE-1; j > ARRAY_SIZE-(0+modulo10+1); j--) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			System.out.printf("%n");
		}

		if (tendivisor == 1)
		{
			for (k = ARRAY_SIZE-1; k > ARRAY_SIZE-11; k--) System.out.printf("% 8d", array[k]);
			System.out.printf("%n");
			for (j = ARRAY_SIZE-11; j > ARRAY_SIZE-(10+modulo10+1); j--) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		
		else if(tendivisor == 2)
		{
			for (l = ARRAY_SIZE-1; l > ARRAY_SIZE-11; l--) System.out.printf("% 8d", array[l]);
			System.out.printf("%n");
			for (k = ARRAY_SIZE-11; k > ARRAY_SIZE-21; k--) System.out.printf("% 8d", array[k]);
			System.out.printf("%n");
			for (j = ARRAY_SIZE-21; j > ARRAY_SIZE-(20+modulo10+1); j--) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		
		else if (tendivisor == 3)
		{
			for (m = ARRAY_SIZE-1; m > ARRAY_SIZE-11; m--) System.out.printf("% 8d", array[m]);
			System.out.printf("%n");
			for (l = ARRAY_SIZE-11; l > ARRAY_SIZE-21; l--) System.out.printf("% 8d", array[l]);
			System.out.printf("%n");
			for (k = ARRAY_SIZE-21; k > ARRAY_SIZE-31; k--) System.out.printf("% 8d", array[k]);
			System.out.printf("%n");
			for (j = ARRAY_SIZE-31; j > ARRAY_SIZE-(30+modulo10+1); j--) System.out.printf("% 8d", array[j]);
			System.out.printf("%n");
			System.out.printf("%n");
		}
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran reverseArray().%n DEBUG: ARRAY_SIZE: %d.%n", ARRAY_SIZE);
	}
	
	//method: sum
	//purpose: adds up all of the integers in the array
	//@return sum returns sum of array
	public static int sum(int[] array)
	{
		int i;
		int sum = 0;
		
		for (i = 0; i < ARRAY_SIZE; i++) sum += array[i];
		
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran sum().%n DEBUG: ARRAY_SIZE: %d.%n  DEBUG: sum = %d%n", ARRAY_SIZE, sum);
		return sum;
	}
	
	//method: mean
	//purpose: finds the average of the array
	//@return mean returns mean of the array
	public static double mean(int[] array)
	{
		int i;
		double sum = 0;
		double mean;
		
		for (i = 0; i < ARRAY_SIZE; i++) sum += array[i];
		
		mean = (sum / (ARRAY_SIZE));
		
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran mean().%n DEBUG: ARRAY_SIZE: %d.%n  DEBUG: mean = %d.%n", ARRAY_SIZE, mean);
		return mean;
	}
	
	//method: min
	//purpose: finds the min of the array
	//@return min returns the least value in the array
	public static int min(int[] array)
	{
		int i;
		int min = Integer.MAX_VALUE;
		int current;
		
		for (i = 0; i < ARRAY_SIZE; i++) if (array[i] < min) min = array[i];
		
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran min().%n DEBUG: ARRAY_SIZE: %d.%n  DEBUG: min = %d.%n", ARRAY_SIZE, min);
		return min;
	}
	
	//method: max
	//purpose: finds the max of the array
	//@return max returns the greatest value in the array
	public static int max(int[] array)
	{
		int i;
		int max = Integer.MIN_VALUE;
		int current;
		
		for (i = 0; i < ARRAY_SIZE; i++) if (array[i] > max) max = array[i];
		
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran max().%n DEBUG: ARRAY_SIZE: %d.%n  DEBUG: max = %d.%n", ARRAY_SIZE, max);
		return max;
	}
	
	//method: evenOdd
	//purpose: prints the even elements of the array to even.out file
	//         and prints the odd elements of the array to odd.out file
	public static void evenOdd(int[] array) throws IOException
	{
		int i;
		
		PrintWriter evenInput = new PrintWriter(new FileWriter("even.out", false));
		PrintWriter oddInput = new PrintWriter(new FileWriter("odd.out", false));
		
		for (i=0; i< ARRAY_SIZE; i++)
		{
			if(array[i]%2 == 0)
				evenInput.printf("%d%n", array[i]);
			else
				oddInput.printf("%d%n", array[i]);
		}
		
		oddInput.close();
		evenInput.close();
		
		if (DEBUG == 1) System.out.printf("DEBUG: Successfully ran evenOdd().%n DEBUG: ARRAY_SIZE: %d.%n", ARRAY_SIZE);
	}
	
	//method: print
	//purpose: prints everything seen in console.
	public static void print(int[] inputArray) throws IOException
	{
		
		printArray(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed printArray().%n");
		reverseArray(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed reverseArray().%n");
		sum(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed sum().%n");
		mean(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed mean().%n");
		min(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed min().%n");
		max(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed max().%n");
		evenOdd(inputArray);
		if (DEBUG == 1) System.out.printf("DEBUG: inputData() passed evenOdd().%n");
		
		System.out.printf("The sum of all elements is: %d%n", sum(inputArray));
		System.out.printf("The mean of all elements is: %.2f%n", mean(inputArray));
		System.out.printf("The minimum of all elements is: %d%n", min(inputArray));
		System.out.printf("The maximum of all elements is: %d%n%n", max(inputArray));
		System.out.printf("Program completed, remember to inspect 'even.out' and 'odd.out' files.");
		System.out.printf("%n");
	}
	
}

