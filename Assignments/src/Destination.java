/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-4       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/21/2023                                    *
 *                                                        *
 * Purpose: To Implement Destination Objects to retrieve  *
 *          data from file.                               *
 *                                                        *
 **********************************************************/
public class Destination
{
    //declaring all variables
    private String name;//destination name
    private int superSaverMiles, normalMiles, startMonth, endMonth, upgradeMiles;

    public Destination(String name, int normalMiles, int superSaverMiles, int upgradeMiles, int startMonth, int endMonth)
    {
        this.name = name;
        this.normalMiles = normalMiles;
        this.superSaverMiles = superSaverMiles;
        this.upgradeMiles = upgradeMiles;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    //Method to get destination name
    //Need not implement setter methods as we used destinations.txt as input file.
    public String getName() //getter
    {
        return name;
    }


    //method to get normal miles
    public int getNormalMiles() //getter
    {
        return normalMiles;
    }


    //method to get super saver miles
    public int getSuperSaverMiles() //getter
    {
        return superSaverMiles;
    }


    //method to get upgraded miles
    public int getUpgradeMiles() //getter
    {
        return upgradeMiles;
    }


    //method to get starting month of super saver duration
    public int getStartMonth()  //getter
    {
        return startMonth;
    }


    //method to get ending month of super saver duration
    public int getEndMonth() //getter
    {
        return endMonth;
    }

}
