/**********************************************************
 *                                                        *
 * CSCI 502           Assignment-5       Summer 2023      *
 *                                                        *
 * Developers:Vikramaditya Reddy Varkala                  *
 *            Venkata Narasimha Rao Miryala               *
 *                                                        *
 * Due Date:07/28/2023                                    *
 *                                                        *
 * Purpose: a test driver for the employee payroll system *
 *                                                        *
 **********************************************************/

import java.util.Scanner;

public class PayrollSystemTest
{

    public static void main(String[] args)
    {

        // create subclass objects
        SalariedEmployee salariedEmployee =
                new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, new Date(6, 15, 1944));
        HourlyEmployee hourlyEmployee =
                new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, new Date(12, 29, 1960));
        CommissionEmployee commissionEmployee =
                new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06, new Date(9, 8, 1954));
        BasePlusCommissionEmployee basePlusCommissionEmployee =
                new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, new Date(3, 2, 1965));

        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n",
                salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n",
                basePlusCommissionEmployee,
                "earned", basePlusCommissionEmployee.earnings());

        // create four-element Employee array
        Employee[] employees = new Employee[4];

        // initialize array with Employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the current month (1 - 12): ");
        int currentMonth = scanner.nextInt();

        System.out.printf("Employees processed polymorphically:%n%n");

        // generically process each element in array employees
        for (Employee currentEmployee : employees)
        {

            System.out.println(currentEmployee); // invokes toString

            // determine whether element is a BasePlusCommissionEmployee
            if (currentEmployee instanceof BasePlusCommissionEmployee)
            {

                // downcast Employee reference to
                // BasePlusCommissionEmployee reference
                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                        "new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }

            double earnings = currentEmployee.earnings();

            // Check if it's the employee's birth month and apply the birthday bonus
            if (currentMonth == currentEmployee.getBirthDate().getMonth())
            {

                System.out.printf("earned $%,.2f plus $100.00 birthday bonus%n%n", earnings);
            } else {
                System.out.printf("earned $%,.2f%n%n", earnings);
            }
        }

        // get type name of each object in employees array
        for (int j = 0; j < employees.length; j++)
            System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
    }
}









