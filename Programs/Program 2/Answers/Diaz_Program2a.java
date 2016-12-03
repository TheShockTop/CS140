/*************************************************************** 
* file: Diaz_Program2a.java 
* author: T. Diaz 
* class: CS 140 – Intro to CS 
* 
* assignment: program 2a 
* date last modified: 10/18/2013 
* 
* purpose: The purpose is to write a message to the screen which
* converts data from tons, pounds, and ounces to kg
* 
****************************************************************/ 

import java.util.Scanner;

public class Diaz_Program2a {

    // method: main
    // purpose: prints out tons, pounds, and ounces as kg

    public static void main(String[] args) {
	double miles;
	double feet;
	double inches;
	double meters;
	Scanner kb = new Scanner(System.in);
	System.out.print("Enter miles: ");
	miles = kb.nextDouble();
	kb.nextLine();
	System.out.print("Enter feet: ");
	feet = kb.nextDouble();
	kb.nextLine();
	System.out.print("Enter inches: ");
	inches = kb.nextDouble();
	kb.nextLine();
	meters = Math.round(((miles*5280+feet+(inches/12))/3.3)*10)/10.0;
	System.out.println((int)miles+" mile(s), "+(int)feet+" feet, "+(int)inches+" inch(es) converts to "+meters+" meter(s).\n");
    }
}