/*************************************************************** 
* file: Diaz_Program2b.java 
* author: T. Diaz 
* class: CS 140 – Intro to CS 
* 
* assignment: program 2b 
* date last modified: 10/18/2013 
* 
* purpose: The purpose is to write a message to the screen which
* converts data from kg to tons, pounds, and ounces
* 
****************************************************************/ 

import java.util.Scanner;

public class Diaz_Program2b {

    // method: main
    // purpose: prints out kg as tons, pounds, and ounces

    public static void main(String[] args) {
	double miles;
	double feet;
	double inches;
	double meters;
	double totalFeet;
	Scanner kb = new Scanner(System.in);
	System.out.print("Enter meters: ");
	meters = kb.nextDouble();
	kb.nextLine();
	totalFeet = meters*3.3;
	miles=totalFeet/5280;
	feet=totalFeet%5280;
	inches=Math.round((totalFeet-((int)miles*5280)-(int)feet)*120)/10.0;
	System.out.println((int)meters+" meter(s) converts to "+(int)miles+" mile(s), "+(int)feet+" feet, "+inches+" inch(es).\n");
    }
}