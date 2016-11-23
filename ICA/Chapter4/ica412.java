public class ica412
{
    public static void main (String[] args)
    {
        int i = 1;
        while (i <=122)
        {
            System.out.print((char)i+"\t");
            if (i % 10 == 0)
            System.out.println();
            i++;
        }
    }
}