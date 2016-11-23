import java.util.*;
import java.io.*;

public class ica42b
{
	public static void main(String[] args) throws IOException
	{
		int count = 0;
		String fileName;
		String character;
		Scanner read = new Scanner(System.in);

		System.out.println("Enter a file name:");
		fileName = read.nextLine();
		File fileName2 = new File(fileName);
		Scanner fileScanner = new Scanner(fileName2);
		System.out.println("What character do you want to be analyzed?");
		character = read.nextLine();

		char z = character.charAt(0);

		while( fileScanner.hasNext() )
		{
			String readFile =  fileScanner.nextLine();
			for( int i = 0; i<readFile.length(); i++)
			{
				if (readFile.charAt(i) == z)
				{
					count++;
				}
			}
		}

		System.out.printf("There are %i %s's", count, character);
		fileScanner.close();
	}
}
