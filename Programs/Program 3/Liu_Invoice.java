/**************************************************************************************
 * file              : Liu_Invoice.java
 * author            : B. Liu
 * class             : CS 140 - Introduction to Computer Science
 *
 * assignment        : Program 3
 * date last modified: 25 Oct 2016
 *
 * purpose           : This program will prompt for input for the gas sold,
 * 					   whether you're a member, and amount of gas sold. It will then
 * 					   print out an invoice for the user, with all applicable taxes.
 *
 **************************************************************************************/
import java.util.Scanner;

public class Liu_Invoice
{
    public static void main(String[] args)
    {
		final double membershipDiscount = -0.1000;
		final double gasRegular         =  2.4700;
		final double gasPlus            =  2.5800;
		final double gasPremium         =  2.6100;
		final double countyTax          =  0.0700;
		final double cityTax            =  0.0375;
	
		double gasPrice                 = 0;
		double subtotal;
		double countyTaxSubtotal;
		double cityTaxSubtotal;
		double total;
		
		int gasSold;        	
		int gasOctane;

		String yes                      = "Yes";
		String membershipValue;
	
		Scanner userInput = new Scanner(System.in);

        System.out.print("Are you a member? ");
		membershipValue = userInput.nextLine();
		
		if (membershipValue.equalsIgnoreCase(yes))
		{
			membershipValue = "Yes";
			
			System.out.print("Quality of Gas: ");
			gasOctane = userInput.nextInt();
			
			if (gasOctane == 87)
			{
				gasPrice = gasRegular + membershipDiscount;
			}
			else if (gasOctane == 89)
			{
				gasPrice = gasPlus + membershipDiscount;
			}
			else if (gasOctane == 91)
			{
				gasPrice = gasPremium + membershipDiscount;
			}
			else
			{
				System.out.println("Error");
			}			
		}

		else
		{
			System.out.print("Quality of Gas: ");
			gasOctane = userInput.nextInt();
			
			if (gasOctane == 87)
			{
				gasPrice = gasRegular;
			}
			else if (gasOctane == 89)
			{
				gasPrice = gasPlus;
			}
			else if (gasOctane == 91)
			{
				gasPrice = gasPremium;
			}
			else
			{
				System.out.println("Error");
			}			
		}

		System.out.print("Gallons sold: ");
        gasSold = userInput.nextInt();
		
		subtotal          = gasPrice * gasSold;
        countyTaxSubtotal = subtotal * countyTax;
        cityTaxSubtotal   = subtotal * cityTax;
		
		subtotal          = Math.round(subtotal * 100);
        subtotal          = subtotal / 100;

        countyTaxSubtotal = Math.round(countyTaxSubtotal * 100);
        countyTaxSubtotal = countyTaxSubtotal / 100;

        cityTaxSubtotal   = Math.round(cityTaxSubtotal * 100);
        cityTaxSubtotal   = cityTaxSubtotal / 100;

        total             = subtotal + countyTaxSubtotal + cityTaxSubtotal;
        total             = Math.round(total * 100);
        total             = total / 100;

		System.out.println();
        System.out.println("INVOICE FOR GASOLINE");
        System.out.println("Member Status      : " + membershipValue);
        System.out.println("Gasoline Sold/Price: " + gasSold + " @ $" + gasPrice);
        System.out.println();
        System.out.println("Subtotal           : $" + subtotal);
        System.out.println("County Tax         : $ " + countyTaxSubtotal);
        System.out.println("City Tax           : $ " + cityTaxSubtotal);
        System.out.println("----------------------------------");
        System.out.println("Total              : $" + total);
	}
}
