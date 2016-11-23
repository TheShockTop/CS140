/***************************************************************
* file: ICA31b.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: ICA 3-1b
* date last modified: 19 October 2016
*
* purpose: This program accepts integer input for their grades
*          it will then calculate their final grade and output
*          it in the user's terminal.
*
****************************************************************/
import java.util.Scanner;

public class ICA31b
{
	public static void main(String[] args)
	{
		double quiz;
		double midterm;
		double finals;
		double grade;

		Scanner userInput = new Scanner(System.in);

		System.out.print("Enter quiz score: ");
		quiz = userInput.nextDouble();

		System.out.print("Enter midterm score: ");
		midterm = userInput.nextDouble();

		System.out.print("Enter finals score: ");
		finals = userInput.nextDouble();

		grade = ((quiz + midterm + finals) / 3);
		grade = Math.round(grade * 10);
		grade = grade / 10;

		if (grade < 50)
		{
			System.out.println("Your overall grade is an F and your percentage grade is " + grade + "%.");
		}
		else if (grade < 70)
		{
			System.out.println("Your overall grade is an C and your percentage grade is " + grade + "%.");
		}
		else if (grade < 90)
		{
			 System.out.println("Your overall grade is an B and your percentage grade is " + grade + "%.");
		}
		else
		{
			 System.out.println("Your overall grade is an A and your percentage grade is " + grade + "%.");
		}
	}
}
