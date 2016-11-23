import java.io.*;
import java.util.Random;

public class ica51b
{

	public static void main(String[] args)

	{
		rollFor();
	}
	public static void rollFor()

	{
		int die1, die2;  // Numbers between 1 and 6 representing the dice.
		int roll;        // Total showing on dice.
		int rollCt;      // Number of rolls made
		int k = 0;
		int l = 0;
		int m = 0;
		int n = 0;
		int o = 0;
		int p = 0;
		int q = 0;
		int r = 0;
		int s = 0;
		int t = 0;
		int u = 0;
		Random rand = new Random();
		rollCt = 0;

        	for (int i = 0; i<10000; i++)
		{
           		die1 = (int)(rand.nextInt(6)) + 1;
           		die2 = (int)(rand.nextInt(6)) + 1;
           		roll = die1 + die2;
			if(roll==2)
			k++;
			if(roll==3)
			l++;
			if(roll==4)
			m++;
			if(roll==5)
			n++;
			if(roll==6)
			o++;
			if(roll==7)
			p++;
			if(roll==8)
			q++;
			if(roll==9)
			r++;
			if(roll==10)
			s++;
			if(roll==11)
			t++;
			if(roll==12)
			u++;
        	}

		double rolls = 10000;
		System.out.println("Total On Dice     Average Number of Rolls");
		System.out.println("-------------     -----------------------");
		System.out.println("2                 " + (rolls/k));
		System.out.println("3                 " + (rolls/l));
		System.out.println("4                 " + (rolls/m));
		System.out.println("5                 " + (rolls/n));
		System.out.println("6                 " + (rolls/o));
		System.out.println("7                 " + (rolls/p));
		System.out.println("8                 " + (rolls/q));
		System.out.println("9                 " + (rolls/r));
		System.out.println("10                " + (rolls/s));
		System.out.println("11                " + (rolls/t));
		System.out.println("12                " + (rolls/u));

		
	}

}
