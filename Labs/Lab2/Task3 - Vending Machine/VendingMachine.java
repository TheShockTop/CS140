/***************************************************************
* file: VendingMachine.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 2 Task 3
* date last modified: 02 Nov 2016
*
* purpose: This program determine the change to be dispensed from
* a vending machine.
*
****************************************************************/ 
import java.util.Scanner;

public class VendingMachine
{
	// method: main
	// purpose: this method determine the change to be dispensed from a vending machine.
	public static void main(String[] args)
	{

	int itemCost;
	int remaining;
	int quarters;
	int dimes;
	int nickels;

	Scanner read = new Scanner(System.in);

	System.out.print("Enter price of item\n(from 25 cents to a dolar, in 5-cent increments): ");
	itemCost = read.nextInt();

	remaining = 100 - itemCost;

	quarters = remaining/25;
	dimes = ((remaining - (quarters*25))/10);
	nickels = ((remaining - (quarters*25) - (dimes*10))/5);

	System.out.println();
	System.out.print("You bought an item for " + itemCost + " and game me a dollar,\nSo your change is \n" + quarters + " quarters, \n" + dimes + " dimes, and \n" + nickels + " nickels.\n");
	}
}