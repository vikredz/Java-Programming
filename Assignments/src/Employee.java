/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-5       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/28/2023                                    *
 *                                                        *
 * Purpose: To declare an Employee class that has methods *
 *          and properties of an employee                 *
 **********************************************************/

public abstract class Employee
{

   private final String firstName;
   private final String lastName;
   private final String socialSecurityNumber;
   private final Date birthDate; // New private instance variable for birth date

   // constructor with birth date parameter
   public Employee(String firstName, String lastName, String socialSecurityNumber, Date birthDate) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      this.birthDate = birthDate;
   }

   // return first name
   public String getFirstName()
   {
      return firstName;
   }

   // return last name
   public String getLastName()
   {
      return lastName;
   }

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   }

   // return birth date
   public Date getBirthDate()
   {
      return birthDate;
   }

   public boolean isBirthMonth(int currentMonth)
   {
      return birthDate.getMonth() == currentMonth;
   }

   // abstract method must be overridden by concrete subclasses
   public abstract double earnings();

   // return String representation of Employee object
   @Override
   public String toString()
   {
      return String.format("%s %s%nSocial Security Number: %s%nBirth Date: %s",
              getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
   }
}
