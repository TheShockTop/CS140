/***************************************************************
* file: prime.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 3 - Task 4
* date last modified: 22 Nov 2016
*
* purpose: This program takes in a number that the user wants to
* check if it is prime or composite. It will then output whether
* it is prime or composite in console.
*
* @param n integer supplied by user
* 
****************************************************************/ 

import java.util.*;
import java.io.*;

public class prime
{
	// method: main
	// purpose: this method prints to console whether int n is prime or not.
	public static void main(String[] args)
	{
		int n = 0;
		boolean isPrime;
		
		Scanner console = new Scanner(System.in);
		
		System.out.printf("Enter number to check if prime: ");
		n = console.nextInt();
		
		if (isPrime(n))
		{
			System.out.printf("%d is prime.%n", n);
		}
		else
		{
			System.out.printf("%d is composite.%n", n);
		}
	}
	
	// method: isPrime
	// purpose: this method determines whether the int provided by user is prime or not
	// if prime, then it returns true.
	public static boolean isPrime(int n) 
	{
		int i;
	
		//if 2 then true
		if (n==2) return true;
		//if multiple of 2, then composite.
		if (n%2==0) return false;
		//if zero divisior or unit, then false.
		if (n==0 || n==1) return false;
		//if not even, then check odd
		//checks for 3, 5, 7, so on until we get to n.
		for(i=3; i<n; i+=2) 
		{
			if(n%i==0) return false;
		}	
		return true;
	}
}