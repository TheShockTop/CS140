/*************************************************************** 
* file: Diaz_Invoice.java 
* author: T. Diaz 
* class: CS 140 – Intro to CS 
* 
* assignment: program 3
* date last modified: 10/28/2013 
* 
* purpose: The purpose is to print out an invoice for gas based
* on membership status, quality of gas, and quantity of gas
* 
****************************************************************/ 

import java.util.Scanner;

public class Diaz_Invoice{

    final static double MEMBER_DISCOUNT = 0.10;
    final static double UNLEADED = 2.47;
    final static double UNLEADED_PLUS = 2.58;
    final static double PREMIUM = 2.61;
    final static double COUNTY_TAX = 0.07;
    final static double CITY_TAX = 0.0375;
	
    // method: main
    // purpose: prints out the invoice as described above

    public static void main(String[] args){
	Scanner kb = new Scanner(System.in);
	String memberStatus = "";
	int gasQuality = 0;
	double gallonsSold = 0.0;

	double gasPrice = 0.0;
	double subtotal = 0.0;
	double countyTaxTotal = 0.0;
	double cityTaxTotal = 0.0;
	double total = 0.0;

	System.out.printf("\n%21s","Are you a member? ");
	memberStatus = kb.nextLine();

	System.out.printf("%21s","Quality of gas: ");
	gasQuality = kb.nextInt();
	kb.nextLine();

	System.out.printf("%21s","Gallons sold: ");
	gallonsSold = kb.nextDouble();
	kb.nextLine();		

	if(memberStatus.equals("yes")){
            switch(gasQuality){
		case 87:
		    gasPrice = Math.round(100*(UNLEADED - MEMBER_DISCOUNT))/100.0;
		    break;
		case 89:
		    gasPrice = Math.round(100*(UNLEADED_PLUS - MEMBER_DISCOUNT))/100.0;
		    break;
		case 91:
		    gasPrice = Math.round(100*(PREMIUM - MEMBER_DISCOUNT))/100.0;
		    break;
	    }
	}
	else {
	    switch(gasQuality){
		case 87:
		    gasPrice = Math.round(100*(UNLEADED))/100.0;
		    break;
		case 89:
		    gasPrice = Math.round(100*(UNLEADED_PLUS))/100.0;
		    break;
		case 91:
		    gasPrice = Math.round(100*(PREMIUM))/100.0;
		    break;
	    }
	}
		
	subtotal = Math.round(100*(gasPrice * gallonsSold))/100.0;
	countyTaxTotal = Math.round(100*(subtotal*COUNTY_TAX))/100.0;
	cityTaxTotal = Math.round(100*(subtotal*CITY_TAX))/100.0;
	total = subtotal+countyTaxTotal+cityTaxTotal;

	System.out.println("\n\n         INVOICE FOR GASOLINE");
	System.out.printf("%21s"+memberStatus+"\n", "Member Status: ");
	System.out.printf("%21s"+gallonsSold+" @ $"+gasPrice+"\n", "Gasoline Sold/Price: ");

	System.out.printf("\n%21s$%6.2f","Subtotal: ",subtotal);
	System.out.printf("\n%21s$%6.2f","County Tax: ",countyTaxTotal);
	System.out.printf("\n%21s$%6.2f","City Tax: ",cityTaxTotal);

	System.out.printf("\n%21s-------","");
	System.out.printf("\n%21s$%6.2f\n","Total: ",total);
    }
}