public class ica71
{
	public static int[] array1 = new int[]{1,2,3};
	public static int[] array2 = new int[]{1,2,3};
	public static boolean isequal = false;

	public static void main(String[] args)
	{
		bothequal(array1, array2);

		if(isequal)
			System.out.printf("Both arrays are equal.%n");
		else
			System.out.printf("Both arrays are not equal.%n");
	}

	public static void bothequal(int array1[], int array2[])
	{
		for (int i = 0; i<3; i++)
		{
			if(array1[i] == array2[i])
				isequal = true;
			else
				isequal = false;
		}
	}
}
