/*************************************************************
 *                                                           *
 * CSCI 502           Assignment-2       Summer 2023         *
 *                                                           *
 * Developer:Vikramaditya Reddy Varkala                      *
 *                                                           *
 * Due Date:07/3/2023                                        *
 *                                                           *
 * Purpose:Classes and Objects.                              *
 *        Invoice class with four instance variable with     *
 *        their setter and getter methods for each variable  *
 *************************************************************/

public class Invoice

{
    //declaring instance variables
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double price;


    //constructor that initializes four instance variables
    public Invoice(String partNumber, String partDescription, int quantity, double price)
    {
       this.partNumber = partNumber;
       this.partDescription = partDescription;
       this.quantity = quantity;
       this.price = price;
    }


    //constructor with no arguments
    //assigning default values directly to instance variables.
    public Invoice()
    {
        this.partNumber = "";
        this.partDescription = "";
        this.quantity = 0;
        this.price = 0.0;
    }


    //setter and getter methods for partNumber

    public String getPartNumber() //getter
    {
        return partNumber;
    }
    public void setPartNumber(String partNumber) //setter
    {
        this.partNumber = partNumber;
    }


    //setter and getter methods for partDescription

    public String getPartDescription() //getter
    {
        return partDescription;
    }
    public void setPartDescription(String partDescription) //setter
    {
        this.partDescription = partDescription;
    }


    //setter and getter methods for quantity

    public int getQuantity() //getter
    {
        return quantity;
    }
    //if quantity is not positive it is set to 0.
    public void setQuantity(int quantity) //setter
    {
        if (quantity > 0)
        {
            this.quantity = quantity;
        }
        else
        {
            this.quantity = 0;
        }
    }


    //setter and getter methods for price

    public double getPrice() //getter
    {
        return price;
    }
    //if price is not positive it is set to 0.
    public void setPrice(double price) //setter
    {
        if (price > 0.0)
        {
            this.price = price;
        }
        else
        {
            this.price = 0.0;
        }
    }


    //Invoice amount can be calculated by product of price and quantity.
    //method to calculate invoice amount.
    //handles negative values.
    public double getInvoiceAmount()
    {
        double amount = quantity * price;
        if (amount < 0)
        {
            return 0.0;
        }
        else
        {
            return amount;
        }
    }

}


//Reference: https://www.w3schools.com/java/java_encapsulation.asp
//Blackboard:Classes, Objects & Methods-Slides(slide 3 get/set method,Fig 3.1)





