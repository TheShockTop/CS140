/***************************************************************
* file: FileIO.java
* author: B. Liu
* class: CS 140 - Introduction to Computer Science
*
* assignment: Lab 3 - Task 3
* date last modified: 22 Nov 2016
*
* purpose: This program takes in either inFile1.dat or
* inFile2.dat and outputs to two files, fully capitalized:
* outFile and appFile. outFile is overwritten everytime the
* program is ran whereas appFile is appended.
*
* @param inputFile input file from user
* @param appendFile input file from user
*
*
* 
****************************************************************/ 

import java.util.*;
import java.io.*;


public class FileIO
{
    public static String inputFile;
    public static String outputFile;
    public static String appendFile;
    public static String fromFile;
    public static String day0;
    public static String day0Cap;
    public static String day1;
    public static String day1Cap;
    public static String day2;
    public static String day2Cap;
    public static File input;
    public static File output;
    public static File append;

    public static final int DEBUG = 0;

	// method: main
	// purpose: runs ask method, readfile method, outputfile method and appendfile method
    public static void main(String[] args) throws IOException
    {
        ask();
        readfile(input);
        outputfile(output);
        appendfile(append);
        System.exit(0);
    }
	
	// method: ask()
	// purpose: this method asks the user to input the file names that will be read from
	// and outputted to, first file outputted to will be overwritten and the second file
	// will be appended to.
    public static void ask() throws IOException
    {
        Scanner console = new Scanner(System.in);

        //inFile1.dat or inFile2.dat
        do
        {
            System.out.print("enter input filename: ");
            inputFile = console.nextLine();
            input = new File(inputFile);
        }
        while (!input.exists());

        //outFile
        System.out.print("enter output filename: ");
        outputFile = console.nextLine();
        output = new File(outputFile);
        //appFile
        System.out.print("enter another output filename (append): ");
        appendFile = console.nextLine();
        append = new File(appendFile);
        System.out.printf("check your output files -- %s, %s", outputFile, appendFile);

        if (DEBUG == 1)
        {
            System.out.printf("%nDEBUG: Method ask ran successfully.");
        }
    }

	// method: readfile
	// purpose: this method reads the file and inputs it into a string placeholder
	// it is the split into an array [I'm sorry I got lazy] and the string in the array are then capitalized. 
    public static void readfile(File inputFile) throws IOException
    {
        int commas = 0;
        String read = "";

        Scanner fileInput = new Scanner(inputFile);

        fromFile = fileInput.nextLine();

        String[] daysplit = fromFile.split(", ");

        day0 = daysplit[0];
        day1 = daysplit[1];

        for(int i = 0; i < fromFile.length(); i++)
        {
            if(fromFile.charAt(i) == ',')
            {
                commas++;
            }
        }

        if (commas == 2)
        {
            day2 = daysplit[2];
            day2Cap = day2.toUpperCase();
        }
        else
        {
            day2Cap = "";
        }

        day0Cap = day0.toUpperCase();
        day1Cap = day1.toUpperCase();

        fileInput.close();

        if (DEBUG == 1)
        {
            System.out.println("DEBUG: Method readfile ran successfully.");
        }
    }

	// method: outputfile
	// purpose: this method overwrites the file inputted by user and
	// writes the strings into the file.
    public static void outputfile(File inputFile) throws IOException
    {
        FileWriter fw = new FileWriter(inputFile, false);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(day0Cap);
        pw.println(day1Cap);
        if (!(day2Cap.length() == 0))
        {
            pw.println(day2Cap);
        }

        pw.close();
        fw.close();

        if (DEBUG == 1)
        {
            System.out.println("DEBUG: Method outputfile ran successfully.");
        }
    }

	// method: appendFile
	// purpose: this method appends the strings into the file inputted by user.
    public static void appendfile(File appendFile) throws IOException
    {
        if(!appendFile.exists())
        {
            appendFile.createNewFile();
        }

        FileWriter fw = new FileWriter(appendFile, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(day0Cap);
        pw.println(day1Cap);
        if (!(day2Cap.length() == 0))
        {
            pw.println(day2Cap);
        }

        pw.close();
        fw.close();

        if (DEBUG == 1)
        {
            System.out.println("DEBUG: Method appendfile ran successfully.");
        }
    }
}