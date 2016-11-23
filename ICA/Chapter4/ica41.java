public class ica41
{
	public static void main(String [] args)
	{
		int x = 0;

		while ( x<=122 )
		{
			for (int i = 1; i<=50; i++)
			{
				x++;
				System.out.print((char) x);
					
				if (i % 10 == 0)
				{
					System.out.print("\n");
				}
			}

		}
	}
}
