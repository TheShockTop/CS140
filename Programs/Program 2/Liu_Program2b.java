/***************************************************************
* file: Liu_Program2b.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Program2
* date last modified: 05 October 2016
*
* purpose: This program will take in the user's data and convert it into miles,
* feet, and inches.
* 
*
****************************************************************/ 
import java.util.Scanner;

public class Liu_Program2b
{
	public static void main(String[] args)
	{
		//hold user inputed metre
		double metre;
		//hold preliminary value
		double feet0;
		//hold calculated mile
		double mile;
		//hold calculated feet
		double feet;
		//hold calculated inch
		double inch;
		// create Scanner object to read user input
		Scanner read = new Scanner(System.in);
		
		// get user's metres
		System.out.print("Enter meters: ");
		metre = read.nextDouble();
		
		//convert metre to mile, feet, inch
		//convert metre to feet
		feet0 = (metre * 3.3);
		//convert feet to miles
		mile = (feet0 / 5280);
		//convert double to int
		int mileInt = (int) mile;
		//convert feet to feet whilst subtracting the mile calculated
		feet = (feet0 - (mileInt * 5280));
		//convert double to int
		int feetInt = (int) feet;
		//convert feet to inches
		inch = ((feet0 - ((mileInt * 5280) + feetInt)) * 12);
		//round inch
		inch = Math.round(inch * 10);
		inch = inch/10;
		
		//display output
		System.out.println( (int) metre + " meters(s) convert to " + mileInt + " mile(s), " + feetInt + " feet, " + inch + " inch(es).");
	}
}
