import java.util.*;
import java.io.*;

public class ica51
{
	public int die1;
	public int die2;
	public int count;

	public static void main(String[] args)
	{
		System.out.println(diceroll());
	}
	public static int diceroll()
	{
		int die1;
		int die2;
		int count = 0;

		do
		{
			die1 = (int)((Math.random()*6+1));
			die2 = (int)((Math.random()*6+1));
			count++;
		}
		while (die1 != 1 && die2 != 1);

		return count;
	}
}
