/***************************************************************
* file: EducationLearningTools.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 3 - Task 5
* date last modified: 22 Nov 2016
*
* purpose: This program takes randomly generates two ints:
* randomIntA and randomIntB and multiplies them together. It
* then asks user for the answer. If answered correctly, a "correct
* string" is printed to console and another two ints are randomly
* generated and the two are multiplied and asks for the answer from
* user again. If answered incorrectly, a "wrong string" is printed
* and tells user to try again until the correct answer is reached.
*
* @param min int min for generation range
* @param max int max for generation range
*
****************************************************************/ 

import java.util.*;
import java.util.regex.*;

public class EducationLearningTools
{
	public static int randomIntA;
	public static int randomIntB;
	public static int answer;
	public static int answerInt;
	public static final int DEBUG = 0;
	public static String wrongRandom;
	public static String rightRandom;
	
	// method: main
	// purpose: this method prints out to console the two randomly generated int from randomInt()
	// and then asks user to supply an answer. If correct then a correctString is randomly printed
	// and then generates two ints and does it all over again. Same with incorrect answers, only with
	// the incorrectString and the same question is asked.
	public static void main(String[] args) throws InputMismatchException
	{
		int i;
		
		do
		{
			Scanner console = new Scanner(System.in);	
			randomInt(0,9);
			System.out.printf("What is %d times %d?%n", randomIntA, randomIntB);
			answerInt = console.nextInt();
			
			if (answerInt == answer)
			{
				randomRight();
				System.out.printf("%s%n", rightRandom);
				if (DEBUG == 1) System.out.println("DEBUG: Correct!!!!!!!!!!!!!!!!!!!");
			}
			else if (answerInt == -1)
			{
				System.exit(0);
			}
			else
			{				
				while (answerInt != answer)
				{
					randomWrong();
					System.out.printf("%s%n", wrongRandom);
					answerInt = console.nextInt();
					
					if (answerInt == -1) System.exit(0);
				}
					
				if (DEBUG == 1) System.out.println("DEBUG: Incorrect!!!!!!!!!!!!!!!!!!!");
			}
		} 
		while (answerInt != -2);
	}
	
	// method: randomInt
	// purpose: this method randomly generates two int
	// and multiplies the two
	public static void randomInt(int min, int max)
	{
		Random random = new Random();
		randomIntA = random.nextInt((max - min) + 1) + min;
		randomIntB = random.nextInt((max - min) + 1) + min;
		
		//@see https://xkcd.com/221/
		//randomIntA = 2 //chosen by https://www.random.org/
		//randomIntB = 4
		
		answer = randomIntA * randomIntB;
		if (DEBUG == 1) System.out.println("DEBUG: randomInt");
	}
	
	// method: randomWrong
	// purpose: chooses a random "wrong" string
	public static void randomWrong()
	{
		int randInt;
		int max = 4;
		int min = 1;
		Random random = new Random();
		
		randInt = random.nextInt((max - min) + 1) + min;
		
		if (randInt == 1)
			wrongRandom = "No. Please try again.";
		else if (randInt == 2)
			wrongRandom = "Wrong. Try once more.";
		else if (randInt == 3)
			wrongRandom = "Don't give up!";
		else if (randInt == 4)
			wrongRandom = "No. Keey Trying.";
		
		
		if (DEBUG == 1) System.out.println("DEBUG: randomWrong");
	}
	
	// method: randomRight
	// purpose: this method chooses a random "wrong" string.
	public static void randomRight()
	{
		int randInt;
		int max = 4;
		int min = 1;
		Random random = new Random();
		
		randInt = random.nextInt((max - min) + 1) + min;
		
		if (randInt == 1)
			rightRandom = "Very good!";
		else if (randInt == 2)
			rightRandom = "Excellent!";
		else if (randInt == 3)
			rightRandom = "Nice work!";
		else if (randInt == 4)
			rightRandom = "Keep up the good work!";
		
		if (DEBUG == 1) System.out.println("DEBUG: randomRight");
	}
}