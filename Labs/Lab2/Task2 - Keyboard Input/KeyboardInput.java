/***************************************************************
* file: KeyboardInput.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 2 Task 2
* date last modified: 02 Nov 2016
*
* purpose: This program takes your name, age, and company name and
* outputs a message.
*
****************************************************************/ 
import java.util.Scanner;

public class KeyboardInput
{
	// method: main
	// purpose: this method takes your name, age, and company name and outputs a message.
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		String name;
		String companyName;

		int age;

		System.out.print("Enter your name: ");
		name = read.nextLine();

		System.out.print("Enter your age: ");
		age = read.nextInt();

		read.nextLine();
		System.out.print("Enter your Company Name: ");
		companyName = read.nextLine();

//		System.out.printf("My name is %s, my age is %d and%nI hope to work for %s %n", name, age, companyName);
		System.out.println("My name is " + name + ", my age is " + age + " and\nI hope to work for " + companyName + ".");
	}
}
