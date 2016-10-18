/**************************************************************************************
 * file              : Liu_Invoice.java
 * author            : B. Liu
 * class             : CS 140 - Introduction to Computer Science
 *
 * assignment        : Program 3
 * date last modified: 07 Oct 2016
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
        String membershipValue;
        String Yes       = "Yes";
        String yes       = "yes";
        String YES       = "YES";
        double gasPrice  = 0;
        double countyTax = .07;
        double cityTax   = .0375;
        double gasSoldWithDiscount;
        double countyTaxSubtotal;
        double cityTaxSubtotal;
        double subtotal;
        double total;
        int gasOctane;
        int gasSold ;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Are you a member?");
        membershipValue = userInput.nextLine();

        System.out.println("Quality of Gas:");
        gasOctane = userInput.nextInt();

        System.out.println("Gallons sold:");
        gasSold = userInput.nextInt();

        if (gasOctane == 87)
        {
            gasPrice = 2.47;
        }
        else if (gasOctane == 89)
        {
            gasPrice = 2.58;
        }
        else if (gasOctane == 91)
        {
            gasPrice = 2.61;
        }
        else
        {
            gasPrice = 0;
        }

        if (membershipValue.equals(Yes) || membershipValue.equals(YES) || membershipValue.equals(yes))
        {
            gasSoldWithDiscount = (gasPrice - .10);
            membershipValue = "Yes";
        }
        else
        {
            gasSoldWithDiscount = gasPrice;
        }

        subtotal          = gasSoldWithDiscount * gasSold;
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

        System.out.println("Are you a member? " + membershipValue);
        System.out.println("Quality of gas: " + gasOctane);
        System.out.println("Gallons sold: " + gasSold);
        System.out.println();
        System.out.println("INVOICE FOR GASOLINE");
        System.out.println("Member Status      : " + membershipValue);
        System.out.println("Gasoline Sold/Price: " + gasSold + " @ $" + gasSoldWithDiscount);
        System.out.println();
        System.out.println("Subtotal           : $" + subtotal);
        System.out.println("County Tax         : $ " + countyTaxSubtotal);
        System.out.println("City Tax           : $ " + cityTaxSubtotal);
        System.out.println("----------------------------------");
        System.out.println("Total              : $" + total);
    }
}
