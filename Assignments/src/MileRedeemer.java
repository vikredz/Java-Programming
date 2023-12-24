/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-4       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/21/2023                                    *
 *                                                        *
 * Purpose: To manage the logic related to redeeming      *
 *          frequent flyer miles for travel destinations. *
 *                                                        *
 **********************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MileRedeemer
{
    private Destination[] destinations;
    private int remainingMiles;


    //Method to read the destinations
    public void readDestinations(Scanner fileScanner)
    {
        ArrayList<Destination> destinationList = new ArrayList<>();

        while (fileScanner.hasNextLine())
        {
            String line = fileScanner.nextLine();
            String[] parts = line.split(";");
            String name = parts[0];

            int normalMiles = Integer.parseInt(parts[1]);
            int superSaverMiles = Integer.parseInt(parts[2]);
            int upgradeMiles = Integer.parseInt(parts[3]);
            int startMonth = Integer.parseInt(parts[4].split("-")[0]);
            int endMonth = Integer.parseInt(parts[4].split("-")[1]);

            Destination destination = new Destination(name, normalMiles, superSaverMiles, upgradeMiles, startMonth, endMonth);
            destinationList.add(destination);
        }
        this.destinations = destinationList.toArray(new Destination[0]);

        //Sorting the array as we will always traverse in descending order of the normal miles and alphabetical order of the destinations
        Arrays.sort(this.destinations, new MileageComparator());
    }



    //method to get city names
    public String[] getCityNames()
    {
        //create an array of String objects from the city names
        String[] cityNames = new String[destinations.length];

        //iterating through the destinations and getting corresponding name
        for (int i = 0; i < destinations.length; i++)
        {
            cityNames[i] = destinations[i].getName();
        }
        //Sorting the city names in aphabetical order
        Arrays.sort(cityNames);
        return cityNames;
    }



    //Method to redeem miles
    public String[] redeemMiles(int miles, int month)
    {
        ArrayList<String> redeemedTickets = new ArrayList<>();
        int remainingMiles = miles;

        for (int i = 0; i < destinations.length; i++)
        {
            Destination destination = destinations[i];

            //condition to check month so that we can decide to use super saver miles.
            if (month >= destination.getStartMonth() && month <= destination.getEndMonth())
            {
                if (miles >= destination.getSuperSaverMiles())
                {
                    //Appending corresponding destination with Economy class ticket
                    redeemedTickets.add("* A trip to " + destination.getName() + " in Economy Class");
                    miles = miles - destination.getSuperSaverMiles();
                }
            }
            else
            {
                if (miles >= destination.getNormalMiles())
                {
                    //Appending corresponding destination with Economy class ticket
                    redeemedTickets.add("* A trip to " + destination.getName() + " in Economy Class");
                    miles = miles - destination.getNormalMiles();
                }
            }
        }

        //Iterating through destinations and checking the possible  condition for ticket upgradation
        for (int i = 0; i < redeemedTickets.size(); i++)
        {
            if (miles >= destinations[i].getUpgradeMiles())
            {
                redeemedTickets.set(i, redeemedTickets.get(i).replace("Economy", "First"));
                miles = miles - destinations[i].getUpgradeMiles();
            }
        }
        this.remainingMiles = miles;

        return redeemedTickets.toArray(new String[0]); //returns array of string objects of redemeed tickets
    }



    //method to get the remaining miles
    public int getRemainingMiles()
    {
        return remainingMiles; //returns  the saved remaining miles.
    }
}
