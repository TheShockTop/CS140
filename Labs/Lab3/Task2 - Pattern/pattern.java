/***************************************************************
* file: pattern.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 3 - Task 2
* date last modified: 22 Nov 2016
*
* purpose: This program outputs the following pattern:
* 1 2 3 4 5 6
* 1 2 3 4 5
* 1 2 3 4
* 1 2 3
* 1 2
* 1
*
****************************************************************/ 

public class pattern
{
	// method: main
	// purpose: this method creates a pattern described in JavaDoc above
	public static void main(String[] args)
	{
		int i;
		int j;
		
		for (i = 6; i > 0; i--)
		{
			for (j = 0; j < i; j++)
			{
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
}