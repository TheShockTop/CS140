/*************************************************************** 
* file: Diaz_MadLibs.java 
* author: T. Diaz 
* class: CS 140 – Intro to CS 
* 
* assignment: program 4
* date last modified: 11/18/2013 
* 
* purpose: The purpose is to play a game of madlibs with the
* user by reading data from a file and prompting the user for answers.
* 
****************************************************************/ 

import java.io.*;
import java.util.Scanner;

public class Diaz_MadLibs {
	
    // method: main
    // purpose: begins the madlibs game as described above
    // by asking the user for a file, reading in the info
    // and forming the story.

    public static void main(String[] args) throws Exception{
        String files = "";
        String filing = "";
        File fileName;
        File aFileName = new File("E:/Cal Poly/CS 140/F_13/Programs/MLAnswers.txt");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        files=keyboard.nextLine();
        filing="E:/Cal Poly/CS 140/F_13/Programs/"+files;
        fileName = new File(filing);
        Scanner inputFile = new Scanner(fileName);
        int n = inputFile.nextInt();
        inputFile.nextLine();
        String word;
        PrintWriter outputFile;
        Scanner answerFile = new Scanner(aFileName);
        FileWriter fwriter = new FileWriter(aFileName);
        outputFile = new PrintWriter(fwriter);
            
        String madLibs;
        for(int i=0; i<n; i++){
           word = inputFile.nextLine();
           System.out.println(word);
           madLibs = keyboard.nextLine();
           outputFile.println(madLibs);
        }
        outputFile.close();
        int j = 0;
        while (answerFile.hasNext()){
            answerFile.nextLine();
            j++;
        }
        System.out.println(j);
        int k = 0;
        answerFile = new Scanner(aFileName);
        while (inputFile.hasNext()) {
            word = inputFile.nextLine();
            if(k<j){
                madLibs = answerFile.nextLine();
                System.out.print(word+madLibs);}
            else {System.out.print(word);}
            k++;
        }
    }
}
