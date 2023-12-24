/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-3       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/14 /2023                                   *
 *                                                        *
 * Purpose: To encapsulates the user interface of the app *
 *                                                        *
 **********************************************************/

import java.util.Scanner;

public class TipApp
{

    public static void main(String[] args)
    {
        //instance of TipApp to call calculateTips().
        TipApp tipApp = new TipApp();
        tipApp.calculateTips();
    }


    public void calculateTips()
    {
        int tipPercentage;
        int partySize;

        //Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);
        TipCalculator tipCalculator = new TipCalculator();


        System.out.println("***** TIP CALCULATOR *****");

        // Takes Bill amount as input and sets it to TipCalculator object.
        //Returns error message if invalid amount is entered
        while (true)
        {
            try
            {
                System.out.print("Enter the bill amount: ");
                double billAmount = Double.parseDouble(scanner.next());
                tipCalculator.setBillAmount(billAmount);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid bill amount.");
            }
        }


        // Takes Tip percentage as input and sets it to TipCalculator object.
        //Returns error message if invalid tip is entered
        while (true)
        {
            try
            {
                System.out.print("Enter your desired tip percentage (20 equals 20%): ");
                tipPercentage = Integer.parseInt(scanner.next());
                tipCalculator.setTipPercentage(tipPercentage);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid tip percentage.");
            }
        }


        // Takes no of people in a party as input and sets it to TipCalculator object.
        //Returns error message if invalid party size is entered
        while (true)
        {
            try
            {
                System.out.print("Enter the size of your party: ");
                partySize = Integer.parseInt(scanner.next());
                tipCalculator.setPartySize(partySize);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid party size.");
            }
        }


        // Prints Bill Details
        System.out.println();
        System.out.println("********* YOUR BILL *****");
        System.out.println("Bill Amount: $" + tipCalculator.getBillAmount());
        System.out.println("Tip Percentage: " + tipPercentage + "%");
        System.out.println("Party Size: " + partySize);
        System.out.println("Total Bill (with Tip): $" + tipCalculator.getTotalBill());
        System.out.println("Share for Each Individual: $" + tipCalculator.getIndividualShare());


        // For New Bill
        System.out.print("Another bill? (y/n): ");
        String input = scanner.next();


        // equals() method to compare two strings
        // compares given input with Y and y. if it doesn't match prints else statement.
        if (input.equals("Y") || input.equals("y"))
        {
            calculateTips();
        }
        else
        {
            System.out.println("Goodbye!");
        }
        scanner.close();

    }
}

//References: https://www.w3schools.com/java/ref_string_equals.asp (.equals method)