/*************************************************************** 
* file: Diaz_Grading.java 
* author: T. Diaz 
* class: CS 140 – Intro to CS 
* 
* assignment: program 5
* date last modified: 11/28/2013 
* 
* purpose: The purpose is to calculate the mean, mode,
* minimum, and maximum of student grades while ignoring invalid data.
* 
****************************************************************/ 

import java.util.Scanner;
import java.io.*;

public class Diaz_Grading
{
	    static int stuId1, stuEc1; static double stuGr1, stuGrE1;
	    static int stuId2, stuEc2; static double stuGr2, stuGrE2;
	    static int stuId3, stuEc3; static double stuGr3, stuGrE3;
	    static int stuId4, stuEc4; static double stuGr4, stuGrE4;
	    static int stuId5, stuEc5; static double stuGr5, stuGrE5;
	    static int stuId6, stuEc6; static double stuGr6, stuGrE6;
	    static int stuId7, stuEc7; static double stuGr7, stuGrE7;
	    static int stuId8, stuEc8; static double stuGr8, stuGrE8;
	    static int stuId9, stuEc9; static double stuGr9, stuGrE9;
	    static int stuId10, stuEc10; static double stuGr10, stuGrE10;
	    static int stuId11, stuEc11; static double stuGr11, stuGrE11;
	    static double mean, mode, min, max, meanE, modeE, minE, maxE;
	    static int minStu, maxStu, minStuE, maxStuE, valid;

	    // method: main
	    // purpose: calls the other methods in proper order to calculate
	    // and display the mean, mode, etc...

	    public static void main(String[] args) throws IOException{
	
	        File grades = new File("gradeInput.txt");
		validateFile(grades);
		validateData(grades);
	
		mean = mean(false);
		meanE = mean(true);
	
		mode = mode(false);
		modeE = mode(true);
	
		min = min(false);
		minE = min(true);
	
		max = max(false);
		maxE = max(true);
			
		System.out.println();
		printData();
	    }

	    // method: validateFile
	    // purpose: makes sure the file exists, yells and calls you a liar if it doesn't.

	    public static void validateFile(File inputFile) throws IOException{
		if(!inputFile.exists()){
		    System.out.print("FILE DOES NOT EXIST! YOU LIAR!!!!");
		    System.exit(0);
		}
	    }

	    // method: validateData
	    // purpose: runs through the data from the file and makes sure its valid
	    // sets default data we can ignore if a student has invalid data.

	    public static void validateData(File inputFile) throws IOException{
		Scanner fileInput = new Scanner(inputFile);

		int temp1=0;
		int temp2=0;
		double temp3=0.0;
		String id="",ec="",gr="";

		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId1=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId1=-1;
				stuEc1=-1;
				stuGr1=-1;
				stuGrE1=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId1=-1;
			stuEc1=-1;
			stuGr1=-1;
			stuGrE1=-1;
		}
		if(fileInput.hasNextInt()&&stuId1!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc1=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId1=-1;
				stuEc1=-1;
				stuGr1=-1;
				stuGrE1=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId1!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId1=-1;
			stuEc1=-1;
			stuGr1=-1;
			stuGrE1=-1;
		}
		if(fileInput.hasNextDouble()&&stuId1!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr1=temp3;
				stuGrE1=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId1=-1;
				stuEc1=-1;
				stuGr1=-1;
				stuGrE1=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId1!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId1=-1;
			stuEc1=-1;
			stuGr1=-1;
			stuGrE1=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId2=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId2=-1;
				stuEc2=-1;
				stuGr2=-1;
				stuGrE2=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId2=-1;
			stuEc2=-1;
			stuGr2=-1;
			stuGrE2=-1;
		}
		if(fileInput.hasNextInt()&&stuId2!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc2=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId2=-1;
				stuEc2=-1;
				stuGr2=-1;
				stuGrE2=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId2!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId2=-1;
			stuEc2=-1;
			stuGr2=-1;
			stuGrE2=-1;
		}
		if(fileInput.hasNextDouble()&&stuId2!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr2=temp3;
				stuGrE2=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId2=-1;
				stuEc2=-1;
				stuGr2=-1;
				stuGrE2=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId2!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId2=-1;
			stuEc2=-1;
			stuGr2=-1;
			stuGrE2=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId3=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId3=-1;
				stuEc3=-1;
				stuGr3=-1;
				stuGrE3=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId3=-1;
			stuEc3=-1;
			stuGr3=-1;
			stuGrE3=-1;
		}
		if(fileInput.hasNextInt()&&stuId3!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc3=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId3=-1;
				stuEc3=-1;
				stuGr3=-1;
				stuGrE3=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId3!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId3=-1;
			stuEc3=-1;
			stuGr3=-1;
			stuGrE3=-1;
		}
		if(fileInput.hasNextDouble()&&stuId3!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr3=temp3;
				stuGrE3=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId3=-1;
				stuEc3=-1;
				stuGr3=-1;
				stuGrE3=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId3!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId3=-1;
			stuEc3=-1;
			stuGr3=-1;
			stuGrE3=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId4=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId4=-1;
				stuEc4=-1;
				stuGr4=-1;
				stuGrE4=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId4=-1;
			stuEc4=-1;
			stuGr4=-1;
			stuGrE4=-1;
		}
		if(fileInput.hasNextInt()&&stuId4!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc4=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId4=-1;
				stuEc4=-1;
				stuGr4=-1;
				stuGrE4=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId4!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId4=-1;
			stuEc4=-1;
			stuGr4=-1;
			stuGrE4=-1;
		}
		if(fileInput.hasNextDouble()&&stuId4!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr4=temp3;
				stuGrE4=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId4=-1;
				stuEc4=-1;
				stuGr4=-1;
				stuGrE4=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId4!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId4=-1;
			stuEc4=-1;
			stuGr4=-1;
			stuGrE4=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId5=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId5=-1;
				stuEc5=-1;
				stuGr5=-1;
				stuGrE5=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId5=-1;
			stuEc5=-1;
			stuGr5=-1;
			stuGrE5=-1;
		}
		if(fileInput.hasNextInt()&&stuId5!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc5=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId5=-1;
				stuEc5=-1;
				stuGr5=-1;
				stuGrE5=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId5!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId5=-1;
			stuEc5=-1;
			stuGr5=-1;
			stuGrE5=-1;
		}
		if(fileInput.hasNextDouble()&&stuId5!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr5=temp3;
				stuGrE5=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId5=-1;
				stuEc5=-1;
				stuGr5=-1;
				stuGrE5=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId5!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId5=-1;
			stuEc5=-1;
			stuGr5=-1;
			stuGrE5=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId6=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId6=-1;
				stuEc6=-1;
				stuGr6=-1;
				stuGrE6=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId6=-1;
			stuEc6=-1;
			stuGr6=-1;
			stuGrE6=-1;
		}
		if(fileInput.hasNextInt()&&stuId6!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc6=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId6=-1;
				stuEc6=-1;
				stuGr6=-1;
				stuGrE6=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId6!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId6=-1;
			stuEc6=-1;
			stuGr6=-1;
			stuGrE6=-1;
		}
		if(fileInput.hasNextDouble()&&stuId6!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr6=temp3;
				stuGrE6=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId6=-1;
				stuEc6=-1;
				stuGr6=-1;
				stuGrE6=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId6!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId6=-1;
			stuEc6=-1;
			stuGr6=-1;
			stuGrE6=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId7=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId7=-1;
				stuEc7=-1;
				stuGr7=-1;
				stuGrE7=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId7=-1;
			stuEc7=-1;
			stuGr7=-1;
			stuGrE7=-1;
		}
		if(fileInput.hasNextInt()&&stuId7!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc7=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId7=-1;
				stuEc7=-1;
				stuGr7=-1;
				stuGrE7=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId7!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId7=-1;
			stuEc7=-1;
			stuGr7=-1;
			stuGrE7=-1;
		}
		if(fileInput.hasNextDouble()&&stuId7!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr7=temp3;
				stuGrE7=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId7=-1;
				stuEc7=-1;
				stuGr7=-1;
				stuGrE7=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId7!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId7=-1;
			stuEc7=-1;
			stuGr7=-1;
			stuGrE7=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId8=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId8=-1;
				stuEc8=-1;
				stuGr8=-1;
				stuGrE8=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId8=-1;
			stuEc8=-1;
			stuGr8=-1;
			stuGrE8=-1;
		}
		if(fileInput.hasNextInt()&&stuId8!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc8=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId8=-1;
				stuEc8=-1;
				stuGr8=-1;
				stuGrE8=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId8!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId8=-1;
			stuEc8=-1;
			stuGr8=-1;
			stuGrE8=-1;
		}
		if(fileInput.hasNextDouble()&&stuId8!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr8=temp3;
				stuGrE8=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId8=-1;
				stuEc8=-1;
				stuGr8=-1;
				stuGrE8=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId8!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId8=-1;
			stuEc8=-1;
			stuGr8=-1;
			stuGrE8=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId9=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId9=-1;
				stuEc9=-1;
				stuGr9=-1;
				stuGrE9=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId9=-1;
			stuEc9=-1;
			stuGr9=-1;
			stuGrE9=-1;
		}
		if(fileInput.hasNextInt()&&stuId9!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc9=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId9=-1;
				stuEc9=-1;
				stuGr9=-1;
				stuGrE9=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId9!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId9=-1;
			stuEc9=-1;
			stuGr9=-1;
			stuGrE9=-1;
		}
		if(fileInput.hasNextDouble()&&stuId9!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr9=temp3;
				stuGrE9=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId9=-1;
				stuEc9=-1;
				stuGr9=-1;
				stuGrE9=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId9!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId9=-1;
			stuEc9=-1;
			stuGr9=-1;
			stuGrE9=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId10=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId10=-1;
				stuEc10=-1;
				stuGr10=-1;
				stuGrE10=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId10=-1;
			stuEc10=-1;
			stuGr10=-1;
			stuGrE10=-1;
		}
		if(fileInput.hasNextInt()&&stuId10!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc10=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId10=-1;
				stuEc10=-1;
				stuGr10=-1;
				stuGrE10=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId10!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId10=-1;
			stuEc10=-1;
			stuGr10=-1;
			stuGrE10=-1;
		}
		if(fileInput.hasNextDouble()&&stuId10!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr10=temp3;
				stuGrE10=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId10=-1;
				stuEc10=-1;
				stuGr10=-1;
				stuGrE10=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId10!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId10=-1;
			stuEc10=-1;
			stuGr10=-1;
			stuGrE10=-1;
		}
		//-----------------------------------------------------------------------------------------------
		if(fileInput.hasNextInt()){
			temp1=fileInput.nextInt();
			if(temp1>-1&&temp1<99999&&(temp1+"").length()==5)
				stuId11=temp1;
			else {
				System.out.println("\tIgnoring student with invalid ID number "+temp1);
				stuId11=-1;
				stuEc11=-1;
				stuGr11=-1;
				stuGrE11=-1;
			}
		}
		else {
			id=fileInput.next();
			System.out.println("\tIgnoring student with invalid ID number "+id);
			stuId11=-1;
			stuEc11=-1;
			stuGr11=-1;
			stuGrE11=-1;
		}
		if(fileInput.hasNextInt()&&stuId11!=-1){
			temp2=fileInput.nextInt();
			if(temp2>-1&&temp2<6)
				stuEc11=temp2;
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+temp2);
				stuId11=-1;
				stuEc11=-1;
				stuGr11=-1;
				stuGrE11=-1;
			}
		}
		else {
			ec=fileInput.next();
			if(stuId11!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid extra credit "+ec);
			stuId11=-1;
			stuEc11=-1;
			stuGr11=-1;
			stuGrE11=-1;
		}
		if(fileInput.hasNextDouble()&&stuId11!=-1){
			temp3=fileInput.nextDouble();
			if(temp3>=0.0&&temp3<=100.0){
				stuGr11=temp3;
				stuGrE11=temp3+(double)temp2;
				valid++;
			}
			else {
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+temp3);
				stuId11=-1;
				stuEc11=-1;
				stuGr11=-1;
				stuGrE11=-1;
			}
		}
		else {
			gr=fileInput.next();
			if(stuId11!=-1)
				System.out.println("\tIgnoring student "+temp1+" with invalid grade "+gr);
			stuId11=-1;
			stuEc11=-1;
			stuGr11=-1;
			stuGrE11=-1;
		}
		//-----------------------------------------------------------------------------------------------
	}

	// method: mean
	// purpose: calculates the mean of the grades from the valid data.

	public static double mean(Boolean gradeType){
		double average = 0.0;

		if(gradeType){
			if(stuGrE1!=-1)
				average+=stuGrE1;
			if(stuGrE2!=-1)
				average+=stuGrE2;
			if(stuGrE3!=-1)
				average+=stuGrE3;
			if(stuGrE4!=-1)
				average+=stuGrE4;
			if(stuGrE5!=-1)
				average+=stuGrE5;
			if(stuGrE6!=-1)
				average+=stuGrE6;
			if(stuGrE7!=-1)
				average+=stuGrE7;
			if(stuGrE8!=-1)
				average+=stuGrE8;
			if(stuGrE9!=-1)
				average+=stuGrE9;
			if(stuGrE10!=-1)
				average+=stuGrE10;
			if(stuGrE11!=-1)
				average+=stuGrE11;
		}
		else{
			if(stuGr1!=-1)
				average+=stuGr1;
			if(stuGr2!=-1)
				average+=stuGr2;
			if(stuGr3!=-1)
				average+=stuGr3;
			if(stuGr4!=-1)
				average+=stuGr4;
			if(stuGr5!=-1)
				average+=stuGr5;
			if(stuGr6!=-1)
				average+=stuGr6;
			if(stuGr7!=-1)
				average+=stuGr7;
			if(stuGr8!=-1)
				average+=stuGr8;
			if(stuGr9!=-1)
				average+=stuGr9;
			if(stuGr10!=-1)
				average+=stuGr10;
			if(stuGr11!=-1)
				average+=stuGr11;
		}
			
		return average/valid;
	}

	// method: mode
	// purpose: calculates the mode of the grades from the valid data.

	public static double mode(Boolean gradeType){
		double foundMode=0;
		int count1=1, count2=1, count3=1;
		int count4=1, count5=1, count6=1;
		int count7=1, count8=1, count9=1;
		int count10=1, count11=1;
		if(gradeType){
			if(stuGrE1!=-1){
				if(stuGrE1==stuGrE2)
					count1++;
				if(stuGrE1==stuGrE3)
					count1++;
				if(stuGrE1==stuGrE4)
					count1++;
				if(stuGrE1==stuGrE5)
					count1++;
				if(stuGrE1==stuGrE6)
					count1++;
				if(stuGrE1==stuGrE7)
					count1++;
				if(stuGrE1==stuGrE8)
					count1++;
				if(stuGrE1==stuGrE9)
					count1++;
				if(stuGrE1==stuGrE10)
					count1++;
				if(stuGrE1==stuGrE11)
					count1++;
			}
			else{ count1=0;}
			if(stuGrE2!=-1){
				if(stuGrE2==stuGrE1)
					count2++;
				if(stuGrE2==stuGrE3)
					count2++;
				if(stuGrE2==stuGrE4)
					count2++;
				if(stuGrE2==stuGrE5)
					count2++;
				if(stuGrE2==stuGrE6)
					count2++;
				if(stuGrE2==stuGrE7)
					count2++;
				if(stuGrE2==stuGrE8)
					count2++;
				if(stuGrE2==stuGrE9)
					count2++;
				if(stuGrE2==stuGrE10)
					count2++;
				if(stuGrE2==stuGrE11)
					count2++;
			}
			else{ count2=0;}
			if(stuGrE3!=-1){
				if(stuGrE3==stuGrE1)
					count3++;
				if(stuGrE3==stuGrE2)
					count3++;
				if(stuGrE3==stuGrE4)
					count3++;
				if(stuGrE3==stuGrE5)
					count3++;
				if(stuGrE3==stuGrE6)
					count3++;
				if(stuGrE3==stuGrE7)
					count3++;
				if(stuGrE3==stuGrE8)
					count3++;
				if(stuGrE3==stuGrE9)
					count3++;
				if(stuGrE3==stuGrE10)
					count3++;
				if(stuGrE3==stuGrE11)
					count3++;
			}
			else{ count3=0;}
			if(stuGrE4!=-1){
				if(stuGrE4==stuGrE1)
					count4++;
				if(stuGrE4==stuGrE2)
					count4++;
				if(stuGrE4==stuGrE3)
					count4++;
				if(stuGrE4==stuGrE5)
					count4++;
				if(stuGrE4==stuGrE6)
					count4++;
				if(stuGrE4==stuGrE7)
					count4++;
				if(stuGrE4==stuGrE8)
					count4++;
				if(stuGrE4==stuGrE9)
					count4++;
				if(stuGrE4==stuGrE10)
					count4++;
				if(stuGrE4==stuGrE11)
					count4++;
			}
			else{ count4=0;}
			if(stuGrE5!=-1){
				if(stuGrE5==stuGrE1)
					count5++;
				if(stuGrE5==stuGrE2)
					count5++;
				if(stuGrE5==stuGrE3)
					count5++;
				if(stuGrE5==stuGrE4)
					count5++;
				if(stuGrE5==stuGrE6)
					count5++;
				if(stuGrE5==stuGrE7)
					count5++;
				if(stuGrE5==stuGrE8)
					count5++;
				if(stuGrE5==stuGrE9)
					count5++;
				if(stuGrE5==stuGrE10)
					count5++;
				if(stuGrE5==stuGrE11)
					count5++;
			}
			else{ count5=0;}
			if(stuGrE6!=-1){
				if(stuGrE6==stuGrE1)
					count6++;
				if(stuGrE6==stuGrE2)
					count6++;
				if(stuGrE6==stuGrE3)
					count6++;
				if(stuGrE6==stuGrE4)
					count6++;
				if(stuGrE6==stuGrE5)
					count6++;
				if(stuGrE6==stuGrE7)
					count6++;
				if(stuGrE6==stuGrE8)
					count6++;
				if(stuGrE6==stuGrE9)
					count6++;
				if(stuGrE6==stuGrE10)
					count6++;
				if(stuGrE6==stuGrE11)
					count6++;
			}
			else{ count6=0;}
			if(stuGrE7!=-1){
				if(stuGrE7==stuGrE1)
					count7++;
				if(stuGrE7==stuGrE2)
					count7++;
				if(stuGrE7==stuGrE3)
					count7++;
				if(stuGrE7==stuGrE4)
					count7++;
				if(stuGrE7==stuGrE5)
					count7++;
				if(stuGrE7==stuGrE6)
					count7++;
				if(stuGrE7==stuGrE8)
					count7++;
				if(stuGrE7==stuGrE9)
					count7++;
				if(stuGrE7==stuGrE10)
					count7++;
				if(stuGrE7==stuGrE11)
					count7++;
			}
			else{ count7=0;}
			if(stuGrE8!=-1){
				if(stuGrE8==stuGrE1)
					count8++;
				if(stuGrE8==stuGrE2)
					count8++;
				if(stuGrE8==stuGrE3)
					count8++;
				if(stuGrE8==stuGrE4)
					count8++;
				if(stuGrE8==stuGrE5)
					count8++;
				if(stuGrE8==stuGrE6)
					count8++;
				if(stuGrE8==stuGrE7)
					count8++;
				if(stuGrE8==stuGrE9)
					count8++;
				if(stuGrE8==stuGrE10)
					count8++;
				if(stuGrE8==stuGrE11)
					count8++;
			}
			else{ count8=0;}
			if(stuGrE9!=-1){
				if(stuGrE9==stuGrE1)
					count9++;
				if(stuGrE9==stuGrE2)
					count9++;
				if(stuGrE9==stuGrE3)
					count9++;
				if(stuGrE9==stuGrE4)
					count9++;
				if(stuGrE9==stuGrE5)
					count9++;
				if(stuGrE9==stuGrE6)
					count9++;
				if(stuGrE9==stuGrE7)
					count9++;
				if(stuGrE9==stuGrE8)
					count9++;
				if(stuGrE9==stuGrE10)
					count9++;
				if(stuGrE9==stuGrE11)
					count9++;
			}
			else{ count9=0;}
			if(stuGrE10!=-1){
				if(stuGrE10==stuGrE1)
					count10++;
				if(stuGrE10==stuGrE2)
					count10++;
				if(stuGrE10==stuGrE3)
					count10++;
				if(stuGrE10==stuGrE4)
					count10++;
				if(stuGrE10==stuGrE5)
					count10++;
				if(stuGrE10==stuGrE6)
					count10++;
				if(stuGrE10==stuGrE7)
					count10++;
				if(stuGrE10==stuGrE8)
					count10++;
				if(stuGrE10==stuGrE9)
					count10++;
				if(stuGrE10==stuGrE11)
					count10++;
			}
			else{ count10=0;}
			if(stuGrE11!=-1){
				if(stuGrE11==stuGrE1)
					count11++;
				if(stuGrE11==stuGrE2)
					count11++;
				if(stuGrE11==stuGrE3)
					count11++;
				if(stuGrE11==stuGrE4)
					count11++;
				if(stuGrE11==stuGrE5)
					count11++;
				if(stuGrE11==stuGrE6)
					count11++;
				if(stuGrE11==stuGrE7)
					count11++;
				if(stuGrE11==stuGrE8)
					count11++;
				if(stuGrE11==stuGrE9)
					count11++;
				if(stuGrE11==stuGrE10)
					count11++;
			}
			else{ count11=0;}
		
			int maximum=0;
			if(maximum<count1){
				maximum=count1;
				foundMode=stuGrE1;
			}
			if(maximum<count2){
				maximum=count2;
				foundMode=stuGrE2;
			}
			if(maximum<count3){
				maximum=count3;
				foundMode=stuGrE3;
			}
			if(maximum<count4){
				maximum=count4;
				foundMode=stuGrE4;
			}
			if(maximum<count5){
				maximum=count5;
				foundMode=stuGrE5;
			}
			if(maximum<count6){
				maximum=count6;
				foundMode=stuGrE6;
			}
			if(maximum<count7){
				maximum=count7;
				foundMode=stuGrE7;
			}
			if(maximum<count8){
				maximum=count8;
				foundMode=stuGrE8;
			}
			if(maximum<count9){
				maximum=count9;
				foundMode=stuGrE9;
			}
			if(maximum<count10){
				maximum=count10;
				foundMode=stuGrE10;
			}
			if(maximum<count11){
				maximum=count11;
				foundMode=stuGrE11;
			}
		}
		else{
			if(stuGr1!=-1){
				if(stuGr1==stuGr2)
					count1++;
				if(stuGr1==stuGr3)
					count1++;
				if(stuGr1==stuGr4)
					count1++;
				if(stuGr1==stuGr5)
					count1++;
				if(stuGr1==stuGr6)
					count1++;
				if(stuGr1==stuGr7)
					count1++;
				if(stuGr1==stuGr8)
					count1++;
				if(stuGr1==stuGr9)
					count1++;
				if(stuGr1==stuGr10)
					count1++;
				if(stuGr1==stuGr11)
					count1++;
			}
			else{ count1=0;}
			if(stuGr2!=-1){
				if(stuGr2==stuGr1)
					count2++;
				if(stuGr2==stuGr3)
					count2++;
				if(stuGr2==stuGr4)
					count2++;
				if(stuGr2==stuGr5)
					count2++;
				if(stuGr2==stuGr6)
					count2++;
				if(stuGr2==stuGr7)
					count2++;
				if(stuGr2==stuGr8)
					count2++;
				if(stuGr2==stuGr9)
					count2++;
				if(stuGr2==stuGr10)
					count2++;
				if(stuGr2==stuGr11)
					count2++;
			}
			else{ count2=0;}
			if(stuGr3!=-1){
				if(stuGr3==stuGr1)
					count3++;
				if(stuGr3==stuGr2)
					count3++;
				if(stuGr3==stuGr4)
					count3++;
				if(stuGr3==stuGr5)
					count3++;
				if(stuGr3==stuGr6)
					count3++;
				if(stuGr3==stuGr7)
					count3++;
				if(stuGr3==stuGr8)
					count3++;
				if(stuGr3==stuGr9)
					count3++;
				if(stuGr3==stuGr10)
					count3++;
				if(stuGr3==stuGr11)
					count3++;
			}
			else{ count3=0;}
			if(stuGr4!=-1){
				if(stuGr4==stuGr1)
					count4++;
				if(stuGr4==stuGr2)
					count4++;
				if(stuGr4==stuGr3)
					count4++;
				if(stuGr4==stuGr5)
					count4++;
				if(stuGr4==stuGr6)
					count4++;
				if(stuGr4==stuGr7)
					count4++;
				if(stuGr4==stuGr8)
					count4++;
				if(stuGr4==stuGr9)
					count4++;
				if(stuGr4==stuGr10)
					count4++;
				if(stuGr4==stuGr11)
					count4++;
			}
			else{ count4=0;}
			if(stuGr5!=-1){
				if(stuGr5==stuGr1)
					count5++;
				if(stuGr5==stuGr2)
					count5++;
				if(stuGr5==stuGr3)
					count5++;
				if(stuGr5==stuGr4)
					count5++;
				if(stuGr5==stuGr6)
					count5++;
				if(stuGr5==stuGr7)
					count5++;
				if(stuGr5==stuGr8)
					count5++;
				if(stuGr5==stuGr9)
					count5++;
				if(stuGr5==stuGr10)
					count5++;
				if(stuGr5==stuGr11)
					count5++;
			}
			else{ count5=0;}
			if(stuGr6!=-1){
				if(stuGr6==stuGr1)
					count6++;
				if(stuGr6==stuGr2)
					count6++;
				if(stuGr6==stuGr3)
					count6++;
				if(stuGr6==stuGr4)
					count6++;
				if(stuGr6==stuGr5)
					count6++;
				if(stuGr6==stuGr7)
					count6++;
				if(stuGr6==stuGr8)
					count6++;
				if(stuGr6==stuGr9)
					count6++;
				if(stuGr6==stuGr10)
					count6++;
				if(stuGr6==stuGr11)
					count6++;
			}
			else{ count6=0;}
			if(stuGr7!=-1){
				if(stuGr7==stuGr1)
					count7++;
				if(stuGr7==stuGr2)
					count7++;
				if(stuGr7==stuGr3)
					count7++;
				if(stuGr7==stuGr4)
					count7++;
				if(stuGr7==stuGr5)
					count7++;
				if(stuGr7==stuGr6)
					count7++;
				if(stuGr7==stuGr8)
					count7++;
				if(stuGr7==stuGr9)
					count7++;
				if(stuGr7==stuGr10)
					count7++;
				if(stuGr7==stuGr11)
					count7++;
			}
			else{ count7=0;}
			if(stuGr8!=-1){
				if(stuGr8==stuGr1)
					count8++;
				if(stuGr8==stuGr2)
					count8++;
				if(stuGr8==stuGr3)
					count8++;
				if(stuGr8==stuGr4)
					count8++;
				if(stuGr8==stuGr5)
					count8++;
				if(stuGr8==stuGr6)
					count8++;
				if(stuGr8==stuGr7)
					count8++;
				if(stuGr8==stuGr9)
					count8++;
				if(stuGr8==stuGr10)
					count8++;
				if(stuGr8==stuGr11)
					count8++;
			}
			else{ count8=0;}
			if(stuGr9!=-1){
				if(stuGr9==stuGr1)
					count9++;
				if(stuGr9==stuGr2)
					count9++;
				if(stuGr9==stuGr3)
					count9++;
				if(stuGr9==stuGr4)
					count9++;
				if(stuGr9==stuGr5)
					count9++;
				if(stuGr9==stuGr6)
					count9++;
				if(stuGr9==stuGr7)
					count9++;
				if(stuGr9==stuGr8)
					count9++;
				if(stuGr9==stuGr10)
					count9++;
				if(stuGr9==stuGr11)
					count9++;
			}
			else{ count9=0;}
			if(stuGr10!=-1){
				if(stuGr10==stuGr1)
					count10++;
				if(stuGr10==stuGr2)
					count10++;
				if(stuGr10==stuGr3)
					count10++;
				if(stuGr10==stuGr4)
					count10++;
				if(stuGr10==stuGr5)
					count10++;
				if(stuGr10==stuGr6)
					count10++;
				if(stuGr10==stuGr7)
					count10++;
				if(stuGr10==stuGr8)
					count10++;
				if(stuGr10==stuGr9)
					count10++;
				if(stuGr10==stuGr11)
					count10++;
			}
			else{ count10=0;}
			if(stuGr11!=-1){
				if(stuGr11==stuGr1)
					count11++;
				if(stuGr11==stuGr2)
					count11++;
				if(stuGr11==stuGr3)
					count11++;
				if(stuGr11==stuGr4)
					count11++;
				if(stuGr11==stuGr5)
					count11++;
				if(stuGr11==stuGr6)
					count11++;
				if(stuGr11==stuGr7)
					count11++;
				if(stuGr11==stuGr8)
					count11++;
				if(stuGr11==stuGr9)
					count11++;
				if(stuGr11==stuGr10)
					count11++;
			}
			else{ count11=0;}
		
			int maximum=0;
			if(maximum<count1){
				maximum=count1;
				foundMode=stuGr1;
			}
			if(maximum<count2){
				maximum=count2;
				foundMode=stuGr2;
			}
			if(maximum<count3){
				maximum=count3;
				foundMode=stuGr3;
			}
			if(maximum<count4){
				maximum=count4;
				foundMode=stuGr4;
			}
			if(maximum<count5){
				maximum=count5;
				foundMode=stuGr5;
			}
			if(maximum<count6){
				maximum=count6;
				foundMode=stuGr6;
			}
			if(maximum<count7){
				maximum=count7;
				foundMode=stuGr7;
			}
			if(maximum<count8){
				maximum=count8;
				foundMode=stuGr8;
			}
			if(maximum<count9){
				maximum=count9;
				foundMode=stuGr9;
			}
			if(maximum<count10){
				maximum=count10;
				foundMode=stuGr10;
			}
			if(maximum<count11){
				maximum=count11;
				foundMode=stuGr11;
			}
		}
		return foundMode;
	}

	// method: min
	// purpose: calculates the minimum of the grades from the valid data.

	public static double min(Boolean gradeType){
		double minimum = 200.0;

		if(gradeType){
			if(minimum>stuGrE1&&stuGrE1!=-1){
				minimum=stuGrE1;
				minStuE=stuId1;
			}
			if(minimum>stuGrE2&&stuGrE2!=-1){
				minimum=stuGrE2;
				minStuE=stuId2;
			}
			if(minimum>stuGrE3&&stuGrE3!=-1){
				minimum=stuGrE3;
				minStuE=stuId3;
			}
			if(minimum>stuGrE4&&stuGrE4!=-1){
				minimum=stuGrE4;
				minStuE=stuId4;
			}
			if(minimum>stuGrE5&&stuGrE5!=-1){
				minimum=stuGrE5;
				minStuE=stuId5;
			}
			if(minimum>stuGrE6&&stuGrE6!=-1){
				minimum=stuGrE6;
				minStuE=stuId6;
			}
			if(minimum>stuGrE7&&stuGrE7!=-1){
				minimum=stuGrE7;
				minStuE=stuId7;
			}
			if(minimum>stuGrE8&&stuGrE8!=-1){
				minimum=stuGrE8;
				minStuE=stuId8;
			}
			if(minimum>stuGrE9&&stuGrE9!=-1){
				minimum=stuGrE9;
				minStuE=stuId9;
			}
			if(minimum>stuGrE10&&stuGrE10!=-1){
				minimum=stuGrE10;
				minStuE=stuId10;
			}
			if(minimum>stuGrE11&&stuGrE11!=-1){
				minimum=stuGrE11;
				minStuE=stuId11;
			}
		}
		else{if(minimum>stuGr1&&stuGr1!=-1){
				minimum=stuGr1;
				minStu=stuId1;
			}
			if(minimum>stuGr2&&stuGr2!=-1){
				minimum=stuGr2;
				minStu=stuId2;
			}
			if(minimum>stuGr3&&stuGr3!=-1){
				minimum=stuGr3;
				minStu=stuId3;
			}
			if(minimum>stuGr4&&stuGr4!=-1){
				minimum=stuGr4;
				minStu=stuId4;
			}
			if(minimum>stuGr5&&stuGr5!=-1){
				minimum=stuGr5;
				minStu=stuId5;
			}
			if(minimum>stuGr6&&stuGr6!=-1){
				minimum=stuGr6;
				minStu=stuId6;
			}
			if(minimum>stuGr7&&stuGr7!=-1){
				minimum=stuGr7;
				minStu=stuId7;
			}
			if(minimum>stuGr8&&stuGr8!=-1){
				minimum=stuGr8;
				minStu=stuId8;
			}
			if(minimum>stuGr9&&stuGr9!=-1){
				minimum=stuGr9;
				minStu=stuId9;
			}
			if(minimum>stuGr10&&stuGr10!=-1){
				minimum=stuGr10;
				minStu=stuId10;
			}
			if(minimum>stuGr11&&stuGr11!=-1){
				minimum=stuGr11;
				minStu=stuId11;
			}
		}
			
		return minimum;
	}

	// method: max
	// purpose: calculates the maximum of the grades from the valid data.

	public static double max(Boolean gradeType){
		double maximum = 0.0;

		if(gradeType){
			if(maximum<stuGrE1&&stuGrE1!=-1){
				maximum=stuGrE1;
				maxStuE=stuId1;
			}
			if(maximum<stuGrE2&&stuGrE2!=-1){
				maximum=stuGrE2;
				maxStuE=stuId2;
			}
			if(maximum<stuGrE3&&stuGrE3!=-1){
				maximum=stuGrE3;
				maxStuE=stuId3;
			}
			if(maximum<stuGrE4&&stuGrE4!=-1){
				maximum=stuGrE4;
				maxStuE=stuId4;
			}
			if(maximum<stuGrE5&&stuGrE5!=-1){
				maximum=stuGrE5;
				maxStuE=stuId5;
			}
			if(maximum<stuGrE6&&stuGrE6!=-1){
				maximum=stuGrE6;
				maxStuE=stuId6;
			}
			if(maximum<stuGrE7&&stuGrE7!=-1){
				maximum=stuGrE7;
				maxStuE=stuId7;
			}
			if(maximum<stuGrE8&&stuGrE8!=-1){
				maximum=stuGrE8;
				maxStuE=stuId8;
			}
			if(maximum<stuGrE9&&stuGrE9!=-1){
				maximum=stuGrE9;
				maxStuE=stuId9;
			}
			if(maximum<stuGrE10&&stuGrE10!=-1){
				maximum=stuGrE10;
				maxStuE=stuId10;
			}
			if(maximum<stuGrE11&&stuGrE11!=-1){
				maximum=stuGrE11;
				maxStuE=stuId11;
			}
		}
		else{if(maximum<stuGr1&&stuGr1!=-1){
				maximum=stuGr1;
				maxStu=stuId1;
			}
			if(maximum<stuGr2&&stuGr2!=-1){
				maximum=stuGr2;
				maxStu=stuId2;
			}
			if(maximum<stuGr3&&stuGr3!=-1){
				maximum=stuGr3;
				maxStu=stuId3;
			}
			if(maximum<stuGr4&&stuGr4!=-1){
				maximum=stuGr4;
				maxStu=stuId4;
			}
			if(maximum<stuGr5&&stuGr5!=-1){
				maximum=stuGr5;
				maxStu=stuId5;
			}
			if(maximum<stuGr6&&stuGr6!=-1){
				maximum=stuGr6;
				maxStu=stuId6;
			}
			if(maximum<stuGr7&&stuGr7!=-1){
				maximum=stuGr7;
				maxStu=stuId7;
			}
			if(maximum<stuGr8&&stuGr8!=-1){
				maximum=stuGr8;
				maxStu=stuId8;
			}
			if(maximum<stuGr9&&stuGr9!=-1){
				maximum=stuGr9;
				maxStu=stuId9;
			}
			if(maximum<stuGr10&&stuGr10!=-1){
				maximum=stuGr10;
				maxStu=stuId10;
			}
			if(maximum<stuGr11&&stuGr11!=-1){
				maximum=stuGr11;
				maxStu=stuId11;
			}
		}
			
		return maximum;
	}

	// method: printData
	// purpose: prints out the data we calucated in the format that was specified.

	public static void printData(){

		System.out.printf("%26s%6.2f%n","Mean Earned Grade: ",mean);
		System.out.printf("%26s%6.2f%n%n","Mean Enhanced Grade: ",meanE);

		System.out.printf("%26s%6.2f%n","Mode Earned Grade: ",mode);
		System.out.printf("%26s%6.2f%n%n","Mode Enhanced Grade: ",modeE);

		System.out.printf("%26s%6.2f (student %d)%n","Minimum Earned Grade: ",min,minStu);
		System.out.printf("%26s%6.2f (student %d)%n%n","Minimum Enhanced Grade: ",minE,minStuE);

		System.out.printf("%26s%6.2f (student %d)%n","Maximum Earned Grade: ",max,maxStu);
		System.out.printf("%26s%6.2f (student %d)%n","Maximum Enhanced Grade: ",maxE,maxStuE);
	}
}