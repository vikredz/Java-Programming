/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-4       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/21/2023                                    *
 *                                                        *
 * Purpose: To handle the user interface and application  *
 *          including reading input from the user and     *
 *          displaying the results                        *
 *                                                        *
 **********************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MileRedeemerApp
{
    public static void main(String[] args)
    {
        // Scanner class instance to read the input text file
        // prompts the travel agent for the name of the .txt file
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the name of the file: ");
        String fileName = sc.nextLine();
        MileRedeemer mileRedeemer = new MileRedeemer();


        // used exception handling to catch FileNotFoundException
        try
        {
            File f = new File(fileName);
            Scanner fileScanner = new Scanner(f);
            mileRedeemer.readDestinations(fileScanner);
            fileScanner.close();
        }

        catch (FileNotFoundException e)
        {
            // Message displaying when the file not present in the specific path
            System.out.println("File not found in the path,Enter correct name.");
            sc.close();
            return;
        }


        System.out.println("-".repeat(75));
        System.out.println("        WELCOME TO THE JAVA AIRLINES MILES REDEEMER APP");
        System.out.println("-".repeat(75));


        // storing all the city names from text files
        String[] cityNames = mileRedeemer.getCityNames();
        System.out.println("List of destination cities your client can travel to:");

        for (int i = 0; i < cityNames.length; i++)
        {
            System.out.println(cityNames[i]);
        }


        String input = "y";
        while (input.equalsIgnoreCase("y"))
        {
            System.out.println("-".repeat(75));
            System.out.print("Please enter your client's accumulated Frequent Flyer Miles: ");
            int miles = sc.nextInt();

            System.out.print("Please enter your client's month of departure (1-12): ");
            int month = sc.nextInt();
            sc.nextLine();

            String[] redeemedTickets = mileRedeemer.redeemMiles(miles, month);


            // Condition to check whether the client can able to redeem miles or not
            if (redeemedTickets.length == 0)
            {
                System.out.println("*** Your client has not accumulated enough Frequent Flyer Miles ***");
            }
            else
            {
                System.out.println("Your client's Frequent Flyer Miles can be used to redeem the following tickets:");
                for (int i = 0; i < redeemedTickets.length; i++)
                {
                    System.out.println(redeemedTickets[i]);
                }
                System.out.println("Your client's remaining Frequent Flyer Miles: " + mileRedeemer.getRemainingMiles());
            }


            System.out.println("-".repeat(75));
            System.out.print("Do you want to continue (y/n)? ");
            input = sc.nextLine();
        }


        System.out.println("-".repeat(75));
        System.out.println("        THANK YOU FOR USING THE JAVA AIRLINES MILES REDEEMER APP");
        System.out.println("-".repeat(75));

        sc.close();
    }
}

