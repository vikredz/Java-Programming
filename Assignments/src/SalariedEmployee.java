/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-5       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/28/2023                                    *
 *                                                        *
 * Purpose:To declare SalariedEmployee subclass which has *
 *          methods and properties of salaried employee   *
 **********************************************************/

public class SalariedEmployee extends Employee
{

   private double weeklySalary;

   // constructor
   public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary, Date birthDate)
   {

      super(firstName, lastName, socialSecurityNumber, birthDate);

      if (weeklySalary < 0.0)
         throw new IllegalArgumentException("Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   }

   // set salary
   public void setWeeklySalary(double weeklySalary)
   {

      if (weeklySalary < 0.0)
         throw new IllegalArgumentException("Weekly salary must be >= 0.0");

      this.weeklySalary = weeklySalary;
   }

   // return salary
   public double getWeeklySalary()
   {

      return weeklySalary;
   }

   // calculate earnings; override abstract method earnings in Employee
   @Override
   public double earnings()
   {

      return getWeeklySalary();
   }

   // return String representation of SalariedEmployee object
   @Override
   public String toString()
   {

      return String.format("Salaried Employee : %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
   }
}
