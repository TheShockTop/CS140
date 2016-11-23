import java.util.*;

public class ica42
{
	public static void main(String[] args)
	{

		int n = 10;
		int x = 0;
		int temp;

		Scanner read = new Scanner(System.in);
		int a[] = new int[10];
		for( int i=0; i < n; i++)
		{
			System.out.println("Please enter number:");
			while (!read.hasNextInt() && !(x > 0))
			{
				System.out.println("Not a valid number!");
				read.next();
				break;
			}
			a[i] = read.nextInt();
		}

		for ( int i = 0; i < n; i++)
		{
			for (int j=i ; j<n ; j++)
			{
				if (a[i] > a[j])
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.print("Sorted in asending order: ");
		for (int i = 0; i < n - 1; i++)
		{
			System.out.print(a[i] + ", ");
		}

		System.out.print(a[9]);
		System.out.println();
	}
}
