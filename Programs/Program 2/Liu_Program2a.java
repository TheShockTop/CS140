/***************************************************************
* file: Liu_Program2a.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Program2
* date last modified: 05 October 2016
*
* purpose: This program will take in the user's data and convert it into metres.
* User will input miles, feet, and inches and the output will be converted into
* metres on screen.
*
****************************************************************/ 
import java.util.Scanner;

public class Liu_Program2a
{
	public static void main(String[] args)
	{
		// hold user's input miles
		double miles;
		// hold user's input feet
		double feet;
		// hold user's input inches
		double inches;
		// hold computed metres
		double metres;
		// create Scanner object to read user input
		Scanner read = new Scanner(System.in);
		
		// get user's miles
		System.out.print("Enter miles: ");
		miles = read.nextDouble();
		
		// get user's feet
		System.out.print("Enter feet: ");
		feet = read.nextDouble();
		
		// get user's inches
		System.out.print("Enter inches: ");
		inches = read.nextDouble();
		
		// convert to metres
		metres = (((miles * 5280) + (feet) + (inches / 12)) / 3.3);
		metres = Math.round(metres * 10);
		metres = metres/10;
		
		// output metres and user entried data
		System.out.println((int)miles + " mile(s), " + (int)feet 
		                   + " feet, " + (int)inches + " inche(s) converts to " 
						   + metres + " meter(s).");
		
	}
}