/***************************************************************
* file: Liu_MadLibs.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Assignment 4
* date last modified: 03 Nov 2016
*
* purpose: This program prompts user for input with respect to a 
* Mad Lib game read from file. The input from user will be inserted
* into an output file and will be then read and created into a story.
*
****************************************************************/ 

import java.util.*;
import java.io.*;

public class Liu_MadLibs
{
	// method: main
	// purpose: This program prompts user for input with respect to a 
	//          Mad Lib game read from file. The input from user will be inserted
	//          into an output file and will be then read and created into a story.
	public static void main(String[] args) throws IOException
	{
		//declare variables and initalize
		int i    = 0;
		int line = 0;
		
		String userAnswer;
		String madLibs;
		String fileLine;
		String fileLineUser;
		
		File madLibsF;
		File userCompleted;
		
		Scanner read;
		Scanner fileInput;
		Scanner fileOutputScanner;
		
		//Scanner read user input
		read                   = new Scanner(System.in);
		
		//Scanner output to file
		PrintWriter fileOutput = new PrintWriter("MadLibsOutput.txt");

		//Ask for user input on file name
		System.out.println("\nEnter a file name:");
		madLibs                = read.nextLine();
		
		//take user input -- convert to file
		madLibsF               = new File(madLibs);
		
		//Scanner read file input
		fileInput              = new Scanner(madLibsF);
		line                   = fileInput.nextInt();
		fileInput.nextLine();
		
		System.out.print("\nPlease provide a word for each of the following:\n");

		for (i = 0; i < line; i++)
		{
			fileLine   = fileInput.nextLine();
			System.out.println(fileLine);
			userAnswer = read.nextLine();
			fileOutput.println(userAnswer);
			System.out.println();			
		}
		
		//close file to save
		fileOutput.close();
		
		//reopen to read from first line
		userCompleted = new File("MadLibsOutput.txt");
		fileOutputScanner = new Scanner(userCompleted);
		
		//while mad libs text has the remaining line, print user input from file
		while (fileInput.hasNext() && fileOutputScanner.hasNext())
		{
			System.out.print(fileInput.nextLine() + fileOutputScanner.nextLine());
		}
		
		if (fileInput.hasNext() && !fileOutputScanner.hasNext())
		{
			System.out.print(fileInput.nextLine());
		}
		
		System.out.println();
		//close files
		fileInput.close();
		fileOutputScanner.close();
		
		
	}
}