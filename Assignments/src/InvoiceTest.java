/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-2       Summer 2023      *
 *                                                        *
 * Developer:Vikramaditya Reddy Varkala                   *
 *                                                        *
 * Due Date:07/3/2023                                     *
 *                                                        *
 * Purpose: Classes and Objects.                          *
 *           Demonstrating Invoice class capabilities     *
 **********************************************************/

import java.text.DecimalFormat;

public class InvoiceTest
{
    public static void main(String[] args)
    {
        //
        DecimalFormat decimalFormat = new DecimalFormat("$###,##0.00");

        Invoice invoice1 = new Invoice("AB-23-4312", "Cordless Drill", 10, 189.00);
        Invoice invoice2 = new Invoice("PH-34-5678", "Phillips Head Screwdriver", 3, 4.99);
        Invoice invoice3 = new Invoice("LS-11-9701", "Light Switch", 5, 1.99);
        Invoice invoice4 = new Invoice("HM-10-1121", "Hammer", 14, 19.99);
        Invoice invoice5 = new Invoice("CS-36-3140", "Carpenter's Square", 4, 102.99);

        Invoice invoice6 = new Invoice();  //test to check the constructor with no arguments


        // method for each invoice object passing invoice number,corresponding invoice object and decimal format

        printInvoice(1, invoice1, decimalFormat);
        printInvoice(2, invoice2, decimalFormat);
        printInvoice(3, invoice3, decimalFormat);
        printInvoice(4, invoice4, decimalFormat);
        printInvoice(5, invoice5, decimalFormat);
        printInvoice(6, invoice6, decimalFormat);


    }
    //method to print invoice details

    public static void printInvoice(int invoiceNumber,Invoice invoice, DecimalFormat decimalFormat)
    {
        System.out.println("Invoice #"+ invoiceNumber +"\n");
        System.out.println("Part No.: " + invoice.getPartNumber());
        System.out.println("Item Desc.: " + invoice.getPartDescription());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Item Price: " + invoice.getPrice()+"\n");
        System.out.println("Invoice Subtotal: " + decimalFormat.format(invoice.getInvoiceAmount()));
        System.out.println("******************************************");
    }

}

//I have added invoice 6 to check if default values are assigned in case no arguments are passed.
//Reason for adding Invoice6: to test capabilities of Invoice class constructor with no arguments passed.


//References: 3.Classes, Objects & Methods - Slide 33 Fig 3.6
//2.Java Syntax, Input-Output and Operators - Notes. Page 8(Decimal Format)
