/***************************************************************
* file: ICA2-2
*
* class: CS - 140
*
* assignment: ICA 2-2
* date last modified: 14 Oct 2016
*
* purpose: To read a user's input and output it as a line.
*
****************************************************************/
import java.util.Scanner;

public class ICA22
{
	public static void main(String[] args)
	{
		//declare varibles and functions used
		Scanner read = new Scanner(System.in);
		String user = "";
		String value = "";

		/*
		Read input from user and input into varibles
		also value from user
		*/

		System.out.println("Please enter in your username:");
		user = read.nextLine();

		System.out.println("Please enter in your value:");
		value = read.nextLine();

		double value2 = Double.parseDouble(value);
		double value3 = Math.round(value2 * 10);
		double value4 = value3/10;

		System.out.println("Hello, " + user + " the number you gave me was " + value4 + "!");
	}
}
