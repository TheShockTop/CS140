/***************************************************************
* file: StringMethods.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 2 Task 5
* date last modified: 02 Nov 2016
*
* purpose: This program takes in your first name, middle name,
* last name, age, lucky number, and favourite colour. It then
* formats it into a story to console.
*
****************************************************************/ 

import java.util.Scanner;

public class StringMethods
{
	// method: main
	// purpose: this method takes in your first name, middle name, last name, age, lucky number, and favourite colour.
	// It then formats it into a story to console.
	public static void main(String[] args)
	{

		String firstName;
		String middleName;
		String lastName;
		String favouriteColour;

		int age = 0;
		int luckyNumber = 0;

		Scanner read = new Scanner(System.in);

		System.out.println("Please enter your first name:");
		firstName = read.nextLine();

		System.out.println("Please enter your middle name:");
		middleName = read.nextLine();

		System.out.println("Please enter your last name:");
		lastName = read.nextLine();

		System.out.println("Please enter your age:");
		age = read.nextInt();

		System.out.println("Please enter your lucky number:");
		luckyNumber = read.nextInt();
		read.nextLine();
		
		System.out.println("Please enter your favorite color:");
		favouriteColour = read.nextLine();

		System.out.println();
		System.out.println("A story about " + firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + middleName.substring(0,1).toUpperCase() + middleName.substring(1).toLowerCase() + " " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase() + ":");
		System.out.println();
		System.out.println(" " + firstName.toUpperCase() + " " + middleName.toUpperCase() + " " + lastName.toUpperCase() +" is " + firstName.substring(0,1).toUpperCase() + middleName.substring(0,1).toUpperCase() + lastName.substring(0,1).toUpperCase() + ".");
		System.out.println();
		System.out.println(" " + firstName.substring(0,1).toUpperCase() + middleName.substring(0,1).toUpperCase() + lastName.substring(0,1).toUpperCase() + "'s favorite color is " + favouriteColour.toLowerCase() + ", and " + firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + lastName.substring(0,1).toUpperCase() + ". is " + age + ".");
		System.out.println();
		System.out.println(" The lucky number of " + firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " " + middleName.substring(0,1).toUpperCase() + ". " + lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase() + " is " + luckyNumber + ".");
		System.out.println();
	}
}
