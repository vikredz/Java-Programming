/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-3       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/14 /2023                                   *
 *                                                        *
 * Purpose: Payroll Birthday Bonus App                    *
 *                                                        *
 **********************************************************/

import java.util.Comparator;

public class MileageComparator implements Comparator<Destination>
{
    //method to compare d1&d2  destination parameters.
    @Override
    public int compare(Destination d1, Destination d2)
    {
        return d2.getNormalMiles() - d1.getNormalMiles();
    }
}
