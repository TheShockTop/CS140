import java.util.*;
import java.io.*;

public class ica43
{
	public static void main(String[] args) throws IOException
	{
		final int times = 100;
		int j = 1;

		PrintWriter fileOutput = new PrintWriter("NumberList.txt");

		for (int i=0; i<times; i++)
		{
			fileOutput.println(i+1);
			j++;
		}

		fileOutput.close();
	}
}
