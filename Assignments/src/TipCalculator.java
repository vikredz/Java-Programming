/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-3       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/14/2023                                    *
 *                                                        *
 * Purpose:To encapsulate the tip calculation logic       *
 *                                                        *
 **********************************************************/

public class TipCalculator

{
    //private data members
    private double billAmount;
    private int tipPercentage;
    private int partySize;


    //default constructor
    public TipCalculator()
    {
        billAmount = 0;
        tipPercentage = 20;
        partySize = 1;
    }


    //setter and getter methods for BillAmount
    public double getBillAmount()//getter
    {
        return billAmount;
    }

    public void setBillAmount(double billAmount)//setter
    {
        this.billAmount = billAmount;
    }


    //setter and getter methods for TipPercentage
    public int getTipPercentage()//getter
    {
        return tipPercentage;
    }

    public void setTipPercentage(int tipPercentage)//setter
    {
        this.tipPercentage = tipPercentage;
    }


    //setter and getter methods for PartySize
    public int getPartySize()//getter
    {
        return partySize;
    }

    public void setPartySize(int partySize)//setter
    {
        this.partySize = partySize;
    }


    public double getTotalBill()//returns final bill
    {
        double finalBill;
        finalBill = billAmount + (billAmount * tipPercentage / 100);
        return finalBill;
    }


    public double getIndividualShare()//returns per person share.
    {
        double perPerson;
        perPerson = getTotalBill() / partySize;
        return perPerson;
    }

}



