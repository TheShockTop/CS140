/***************************************************************
* file: IsEven.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 2 Task 4
* date last modified: 02 Nov 2016
*
* purpose: This program determine if the number inserted is even.
* 
*
****************************************************************/ 

import java.util.Scanner;

public class IsEven
{
	// method: main
	// purpose: this method determine if the number inserted is even.
	public static void main(String[] args)
	{
		boolean evenOdd=false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer from 0-10: ");
		int n = keyboard.nextInt();

		if (n % 2 == 0 && n >= 0 && n <= 10)
		{
			evenOdd=true;
		}
		else if (n > 10 || n < 0)
		{
			System.out.println("Number not within range.");
			evenOdd=false;
		}
		else
		{
			evenOdd=false;
		}

		System.out.println("Is that number even? "+evenOdd);
	}
}
