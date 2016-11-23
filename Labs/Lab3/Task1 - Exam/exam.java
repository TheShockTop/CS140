/*
convert to for loops

import java.util.*;

public class exam
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int passes = 0;
		int failures = 0;
		int students = 0;
		int result;
		
		while (students < 10)
		{
			System.out.print("enter result (1=pass, 0=fail): ");
			result = keyboard.nextInt();
			if (result == 1)
				passes++;
			else
				failures++;
			students++
		}
		System.out.println(passes + " passed\n" + failures + " failed");
		if (passes < 5)
			System.out.println("Raise tuition");
	}
}
*/

/***************************************************************
* file: exam.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 3 - Task 1
* date last modified: 22 Nov 2016
*
* purpose: This program is rewritten from the program above and
* adds a statement to verify whether user input is 1 or 0.
* This program takes in ten 1s and 0s, passes and fails, respectively.
* It then outputs how many failed or passed, depending on input.
*
****************************************************************/ 

import java.util.*;

public class exam
{
	// method: main
	// purpose: this method asks user for 1 or 0, pass or fail and then
	// returns how many passed and failed.
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		int passes = 0;
		int failures = 0;
		int students = 0;
		int result;
		int i;

		for (students = 0; students < 10; i++)
		{
			System.out.print("Enter result (1 = pass, 0 = fail): ");
			result = read.nextInt();
			if (result == 1)
			{
				passes++;
			}
			else if (result == 0)
			{
				failures++;
			}
			else
			{
				System.out.println("Please try again.");
				i--;
			}
		}
		System.out.println(passes + " passed\n" + failures + " failed");
		if (passes < 5)
			System.out.println("Raise tuition");
	}
}
