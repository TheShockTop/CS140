/***************************************************************
 * file: Liu_Grading.java
 * author: B. Liu
 * class: CS 140 - Introduction to Computer Science
 *
 * assignment: program 5
 * date last modified: 27 - Nov - 2016
 *
 * purpose: This program reads lines of input from a file with information about grades, extra credit, and id
 * and will output the mean, mode, min, and max of the grades, except for those rejected.
 *
 ****************************************************************/
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.*;

public class Liu_Grading
{
	//debug
	static final int DEBUG = 0;

	static int countValid = 0;
	static int countLines = 0;
	static int minIDEC, minID; //min ID value
	static int maxIDEC, maxID;

	static double gradeAverageExtraCredit = 0.0;
	static double gradeAverage = 0;

	// method: main
// purpose: this method runs validatedata and validatefile
	public static void main(String[] args) throws IOException
	{
		Scanner fileRead = new Scanner(new File("gradeInput.txt"));
		validateFile(new File("gradeInput.txt"));
		validateData(new File("gradeInput.txt"));
		printData();
		fileRead.close();
		delete();
		System.exit(0);
	}

	// method: validatefile
// purpose: this method validates if the file gradeinput is there, if not, program is killed
	public static void validateFile(File inputFile) throws IOException
	{
		File debug = new File("debug");

		//debug
		if (DEBUG == 1)
		{
			PrintWriter debugpw = new PrintWriter(new FileWriter("debug"));
			debugpw.println("running validateFile");
			debugpw.close();
		}

		if (DEBUG == 0 && debug.exists())
		{
			debug.delete();
		}

		if (!inputFile.exists())
		{
			System.out.print("File does not exist. Ending program.");
			System.exit(0);
		}
	}

	// method: validatedata
// purpose: this method validates data in the file gradeinput
	public static void validateData(File inputFile) throws IOException
	{
		String id0 = "";
		String ecString = "";
		String grade0 = "";
		String stringStorage = "";
		String stringStorageIdentification = "";
		String stringStorageExtraCredit = "";
		String stringStorageGrade = "";

		int extraCredit = 0;
		int idNumber = 0;
		double grade = 0.0;

		Scanner fileRead = new Scanner(inputFile);

		PrintWriter fileOutputInvalidID = new PrintWriter(new FileWriter("invalidID", false));

		PrintWriter fileOutputInvalidEC = new PrintWriter(new FileWriter("invalidEC", false));

		PrintWriter fileOutputInvalidG = new PrintWriter(new FileWriter("invalidG", false));

		PrintWriter fileOutputValidID = new PrintWriter(new FileWriter("validID", false));

		PrintWriter fileOutputValidEC = new PrintWriter(new FileWriter("validEC", false));

		PrintWriter fileOutputValidG = new PrintWriter(new FileWriter("validG", false));

		if (DEBUG == 1)
		{
			PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
			debugpw.println("running validateData");
			debugpw.close();
		}

		while (fileRead.hasNext())
		{
			stringStorage = fileRead.nextLine();
			stringStorageIdentification = stringStorage.substring(0, 5);
			stringStorageExtraCredit = stringStorage.substring(7, 8);
			stringStorageGrade = stringStorage.substring(10, 15);

			countLines++;

			if (DEBUG == 1) System.out.printf("DEBUG: %s, %s, %s countLines: %d%n", stringStorageIdentification,
					stringStorageExtraCredit, stringStorageGrade, countLines);

			extraCredit = Integer.parseInt(stringStorageExtraCredit);
			grade = Double.parseDouble(stringStorageGrade);


			//implement validation here for function
			if ((stringStorageIdentification.matches("^[0-9]*$") && stringStorageIdentification.length() == 5))
			{
				idNumber = Integer.parseInt(stringStorageIdentification);

				if (idNumber <= 99999)
				{
					if (extraCredit >= 0 && extraCredit <= 5)
					{
						if (grade >= 0.0 && grade <= 100.00)
						{
							id0 += stringStorageIdentification + "; ";
							ecString += stringStorageExtraCredit + "; ";
							grade0 += stringStorageGrade + "; ";
							countValid++;
//							ecAverage += extraCredit;
							gradeAverage += grade;
							gradeAverageExtraCredit += (grade + (double)extraCredit);

							fileOutputValidID.println(stringStorageIdentification);
							fileOutputValidEC.println(stringStorageExtraCredit);
							fileOutputValidG.println(stringStorageGrade);

							if (DEBUG == 1)
							{
								PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
								debugpw.println("nested ifs validateData");
								debugpw.printf("countValid:%d%nGrade:%f%ngradeAverage:%f%n", countValid, grade, gradeAverageExtraCredit);
								debugpw.close();
							}

						}
						else
						{
							//invalid grade
							fileOutputInvalidG.print(stringStorageIdentification + " ");
							fileOutputInvalidG.print(stringStorageExtraCredit+ " ");
							fileOutputInvalidG.println(stringStorageGrade + " ");
						}
					}
					else
					{
						//invalid extra credit
						fileOutputInvalidEC.print(stringStorageIdentification + " ");
						fileOutputInvalidEC.print(stringStorageExtraCredit + " ");
						fileOutputInvalidEC.println(stringStorageGrade + " ");
					}
				}
				else
				{
					//invalid id number
					fileOutputInvalidID.print(stringStorageIdentification + " ");
					fileOutputInvalidID.print(stringStorageExtraCredit + " ");
					fileOutputInvalidID.println(stringStorageGrade + " ");
				}
			}
			else
			{
				//invalid id number
				fileOutputInvalidID.print(stringStorageIdentification + " ");
				fileOutputInvalidID.print(stringStorageExtraCredit + " ");
				fileOutputInvalidID.println(stringStorageGrade + " ");

			}
		}

		if (DEBUG == 1)
		{
			PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
			debugpw.println("finished while loop in validateData");
			debugpw.println("ID: " + id0 + "\n" + "EC: " + ecString + "\n" + "Grade: " + grade0);
			debugpw.close();
		}


		fileRead.close();
		fileOutputInvalidID.close();
		fileOutputInvalidG.close();
		fileOutputInvalidEC.close();
		fileOutputValidEC.close();
		fileOutputValidG.close();
		fileOutputValidID.close();
	}


	// method: mean
// purpose: this method calculates the mean of the file
	public static double mean(Boolean gradeType) throws IOException
	{
		double ecGradeMean, gradeMean;

		if (gradeType)
		{
			ecGradeMean = (double)((double)gradeAverageExtraCredit / (double)countValid);
			return ecGradeMean;
		}
		else
		{
			gradeMean = (double)((double)gradeAverage / (double)countValid);
			return gradeMean;
		}

	}

	// method: mode
// purpose: this method calculates the mode of the file
	public static double mode(Boolean gradeType) throws IOException
	{

		int ec0 = 0,ec1 = 0,ec2 = 0,ec3 = 0,ec4 = 0,ec5 = 0,ec6 = 0,ec7 = 0;
		int c0 = 0,c1 = 0,c2 = 0,c3 = 0,c4 = 0,c5 = 0,c6 = 0,c7 = 0;
		double g0 = 0,g1 = 0,g2 = 0,g3 = 0,g4 = 0,g5 = 0,g6 = 0,g7 = 0;
		double add0 = 0,add1 = 0,add2 = 0,add3 = 0,add4 = 0,add5 = 0,add6 = 0,add7 = 0;
		double placeholder = 9002;

		if (gradeType)
		{
			Scanner validFileEC = new Scanner(new File("validEC")); //int
			Scanner validFileGrade = new Scanner(new File("validG")); //double

			ec0 = validFileEC.nextInt();
			ec1 = validFileEC.nextInt();
			ec2 = validFileEC.nextInt();
			ec3 = validFileEC.nextInt();
			ec4 = validFileEC.nextInt();
			ec5 = validFileEC.nextInt();
			ec6 = validFileEC.nextInt();
			ec7 = validFileEC.nextInt();

			g0 = validFileGrade.nextDouble();
			g1 = validFileGrade.nextDouble();
			g2 = validFileGrade.nextDouble();
			g3 = validFileGrade.nextDouble();
			g4 = validFileGrade.nextDouble();
			g5 = validFileGrade.nextDouble();
			g6 = validFileGrade.nextDouble();
			g7 = validFileGrade.nextDouble();

			add0 = ec0 + g0;
			add1 = ec1 + g1;
			add2 = ec2 + g2;
			add3 = ec3 + g3;
			add4 = ec4 + g4;
			add5 = ec5 + g5;
			add6 = ec6 + g6;
			add7 = ec7 + g7;

			validFileEC.close();
			validFileGrade.close();

			validFileEC = new Scanner(new File("validEC")); //int
			validFileGrade = new Scanner(new File("validG")); //double

			while(validFileEC.hasNext() && validFileGrade.hasNext())
			{
				double addition = validFileEC.nextInt() + validFileGrade.nextDouble();
				if (addition == add0) c0++;
				if (addition == add1) c1++;
				if (addition == add2) c2++;
				if (addition == add3) c3++;
				if (addition == add4) c4++;
				if (addition == add5) c5++;
				if (addition == add6) c6++;
				if (addition == add7) c7++;
			}

			PrintWriter counting = new PrintWriter(new FileWriter("COUNTING", false));
			counting.printf("%d%n%d%n%d%n%d%n%d%n%d%n%d%n%d%n", c0, c1, c2, c3, c4, c5, c6, c7);
			counting.close();

			Scanner counting1 = new Scanner(new File("COUNTING"));

			int b = 0;

			for (int k = 0; k < 8; k++)
			{
				int a = counting1.nextInt();

				if (a > b) b = a;
			}

			counting1.close();
			counting1 = new Scanner(new File("COUNTING"));

			while(counting1.hasNext())
			{
				if (b == c0) return add0;
				if (b == c1) return add1;
				if (b == c2) return add2;
				if (b == c3) return add3;
				if (b == c4) return add4;
				if (b == c5) return add5;
				if (b == c6) return add6;
				if (b == c7) return add7;

			}

			if (b == 9999999) return placeholder;
			validFileEC.close();
			validFileGrade.close();
		}
		else
		{
			Scanner validFileEC = new Scanner(new File("validEC")); //int
			Scanner validFileGrade = new Scanner(new File("validG")); //double

			c0 = 0; c1 = 0; c2 = 0; c3 = 0; c4 = 0; c5 = 0; c6 = 0; c7 = 0;
			g0 = 0; g1 = 0; g2 = 0; g3 = 0; g4 = 0; g5 = 0; g6 = 0; g7 = 0;
			add0 = 0; add1 = 0; add2 = 0; add3 = 0; add4 = 0; add5 = 0; add6 = 0; add7 = 0;
			placeholder = 9002;

			g0 = validFileGrade.nextDouble();
			g1 = validFileGrade.nextDouble();
			g2 = validFileGrade.nextDouble();
			g3 = validFileGrade.nextDouble();
			g4 = validFileGrade.nextDouble();
			g5 = validFileGrade.nextDouble();
			g6 = validFileGrade.nextDouble();
			g7 = validFileGrade.nextDouble();

			add0 = g0;
			add1 = g1;
			add2 = g2;
			add3 = g3;
			add4 = g4;
			add5 = g5;
			add6 = g6;
			add7 = g7;

			validFileEC.close();
			validFileGrade.close();

			validFileEC = new Scanner(new File("validEC")); //int
			validFileGrade = new Scanner(new File("validG")); //double

			while(validFileEC.hasNext() && validFileGrade.hasNext())
			{
				double addition = validFileGrade.nextDouble();
				if (addition == add0) c0++;
				if (addition == add1) c1++;
				if (addition == add2) c2++;
				if (addition == add3) c3++;
				if (addition == add4) c4++;
				if (addition == add5) c5++;
				if (addition == add6) c6++;
				if (addition == add7) c7++;
			}

			PrintWriter counting = new PrintWriter(new FileWriter("COUNTING1", false));
			counting.printf("%d%n%d%n%d%n%d%n%d%n%d%n%d%n%d%n", c0, c1, c2, c3, c4, c5, c6, c7);
			counting.close();

			Scanner counting2 = new Scanner(new File("COUNTING1"));

			int b = 0;

			for (int k = 0; k < 8; k++)
			{
				int a = counting2.nextInt();

				if (a > b) b = a;
			}

			counting2.close();
			counting2 = new Scanner(new File("COUNTING1"));

			if (b == c0) return g0;
			if (b == c1) return g1;
			if (b == c2) return g2;
			if (b == c3) return g3;
			if (b == c4) return g4;
			if (b == c5) return g5;
			if (b == c6) return g6;
			if (b == c7) return g7;

			validFileEC.close();
			validFileGrade.close();

		}

		return placeholder;
	}

	// method: min
// purpose: this method calculates the min of the file
	public static double min(Boolean gradeType) throws IOException
	{
		double minValue = 100;

		if(gradeType)
		{
			Scanner validFileID = new Scanner(new File("validID")); //int
			Scanner validFileEC = new Scanner(new File("validEC")); //int
			Scanner validFileGrade = new Scanner(new File("validG")); //double

			do
			{
				double holderGrade = validFileGrade.nextDouble();
				int holderEC = validFileEC.nextInt();
				int holderID = validFileID.nextInt();

				double added = (holderGrade + holderEC);

				if (added <  minValue)
				{
					minValue = added;
					minIDEC = holderID;
				}

				if (DEBUG == 1)
				{
					PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
					debugpw.println("running min(true)");
					debugpw.close();
				}

			}while(validFileID.hasNext() && validFileEC.hasNext() && validFileGrade.hasNext());

			if (DEBUG == 1)
			{
				PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
				debugpw.println("finished min(true)");
				debugpw.close();
			}

			validFileID.close();
			validFileEC.close();
			validFileGrade.close();

			return minValue;
		}
		else
		{
			Scanner validFileID = new Scanner(new File("validID"));
			Scanner validFileGrade = new Scanner(new File("validG"));

			minValue = 100;

			do
			{
				double holderGrade = validFileGrade.nextDouble();
				int holderID = validFileID.nextInt();

				double added = (holderGrade);

				if (added <  minValue)
				{
					minValue = added;
					minID = holderID;
				}

				if (DEBUG == 1)
				{
					PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
					debugpw.println("running min(true)");
					debugpw.close();
				}

			}while(validFileID.hasNext() && validFileGrade.hasNext());

			validFileID.close();
			validFileGrade.close();

			return minValue;
		}

	}

	// method: max
// purpose: this method calculates the max of the file
	public static double max(Boolean gradeType) throws IOException
	{

		if(gradeType)
		{
			double maxValue = 0;
			Scanner validFileID = new Scanner(new File("validID")); //int
			Scanner validFileEC = new Scanner(new File("validEC")); //int
			Scanner validFileGrade = new Scanner(new File("validG")); //double

			do
			{
				double holderGrade = validFileGrade.nextDouble();
				int holderEC = validFileEC.nextInt();
				int holderID = validFileID.nextInt();

				double added = (holderGrade + holderEC);

				if (added >  maxValue)
				{
					maxValue = added;
					maxIDEC = holderID;
				}

				if (DEBUG == 1)
				{
					PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
					debugpw.printf("running max(true)");
					debugpw.close();
				}

			}while(validFileID.hasNext() && validFileEC.hasNext() && validFileGrade.hasNext());

			if (DEBUG == 1)
			{
				PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
				debugpw.println("finished max(true)");
				debugpw.close();
			}

			validFileID.close();
			validFileEC.close();
			validFileGrade.close();

			return maxValue;
		}
		else
		{
			double maxValue = 0;
			Scanner validFileID = new Scanner(new File("validID"));
			Scanner validFileGrade = new Scanner(new File("validG"));

			do
			{
				double holderGrade = validFileGrade.nextDouble();
				int holderID = validFileID.nextInt();

				double added = (holderGrade);

				if (added > maxValue)
				{
					maxValue = added;
					maxID = holderID;
				}

				if (DEBUG == 1)
				{
					PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
					debugpw.println("running max(true)");
					debugpw.close();
				}

			}while(validFileID.hasNext() && validFileGrade.hasNext());

			validFileID.close();
			validFileGrade.close();

			return maxValue;
		}

	}

	// method: printData
// purpose: this method prints the mean, mode, min, and max of the file
	public static void printData() throws IOException
	{
		Scanner invalidFileID = new Scanner(new File("invalidID"));
		Scanner invalidFileEC = new Scanner(new File("invalidEC"));
		Scanner invalidFileGrade = new Scanner(new File("invalidG"));

		String nextLine, stringStorageIdentification, stringStorageExtraCredit, stringStorageGrade;

		do
		{
			nextLine = invalidFileID.nextLine();
			stringStorageIdentification = nextLine.substring(0, 5);

			System.out.printf("Ignoring student with invalid ID number %s.%n", stringStorageIdentification);
		} while (invalidFileID.hasNext());

		do
		{
			nextLine = invalidFileEC.nextLine();
			stringStorageIdentification = nextLine.substring(0, 5);
			stringStorageExtraCredit = nextLine.substring(8, 9);

			System.out.printf("Ignoring student %s with invalid extra credit %s.%n",stringStorageIdentification, stringStorageExtraCredit);
		} while (invalidFileEC.hasNext());

		do
		{
			nextLine = invalidFileGrade.nextLine();
			stringStorageIdentification = nextLine.substring(0, 5);
			stringStorageGrade = nextLine.substring(8, 13);

			System.out.printf("Ignoring student %s with invalid grade %s0.%n%n",stringStorageIdentification, stringStorageGrade);
		} while (invalidFileGrade.hasNext());

		//mean

		System.out.printf("Mean Earned Grade: %f%n", mean(false));
		System.out.printf("Mean Enhanced Grade: %f%n%n", mean(true));

		//mode

		System.out.printf("Mode Earned Grade: %f%n",mode(false));
		System.out.printf("Mode Enhanced Grade: %f%n%n",mode(true));

		//min

		System.out.printf("Minimum Earned Grade: %f (student %d)%n", min(false), minID);
		System.out.printf("Minimum Enhanced Grade: %f (student %d)%n%n", min(true), minIDEC);

		//max

		System.out.printf("Maximum Earned Grade: %f (student %d)%n", max(false), maxID);
		System.out.printf("Maximum Enhanced Grade: %f (student %d)%n%n", max(true), maxIDEC);

		invalidFileID.close();
		invalidFileEC.close();
		invalidFileGrade.close();

		if (DEBUG == 1)
		{
			PrintWriter debugpw = new PrintWriter(new FileWriter("debug", true));
			debugpw.println("finished printData()");
			debugpw.close();
		}
	}

	// method: delete
// purpose: this method deletes any remaining files
	public static void delete()
	{
		File foo = new File("COUNTING");
		foo.delete();
		File bar = new File("COUNTING1");
		bar.delete();
		File c = new File("invalidEC");
		c.delete();
		File d = new File("invalidG");
		d.delete();
		File e = new File("invalidID");
		e.delete();
		File fg = new File("validEC");
		fg.delete();
		File gg = new File("validG");
		gg.delete();
		File hg = new File("validID");
		hg.delete();
	}
}