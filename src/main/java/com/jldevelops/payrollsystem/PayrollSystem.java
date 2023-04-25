package com.jldevelops.payrollsystem;


public class PayrollSystem {

    public static void main(String[] args) {
        // Get the current month
        int currentMonth = 3;

        // Create an array of Employee objects
        Employee[] employees = new Employee[5];

        // Add sample employees to the array
        employees[0] = new SalariedEmployee("John", "Doe", "123-45-6789", 800.0, new Date(3, 15, 1990));
        employees[1] = new HourlyEmployee("Jane", "Smith", "234-56-7890", 20.0, 40, new Date(3, 10, 1985));
        employees[2] = new CommissionEmployee("Alice", "Brown", "345-67-8901", 0.15, 340, new Date(7, 20, 2000));
        employees[3] = new BasePlusCommissionEmployee(300, 0.30, 5000, "Bob", "Johnson", "456-78-9012", new Date(12, 1, 1978));
        employees[4] = new SalariedEmployee("Johnson", "Li","232-234-2342", 1250.23, new Date(11,12,2001));
        // Calculate the payroll for each Employee and add a birthday bonus if applicable
        for (Employee employee : employees) {
            //polymorphism part
            double earnings = employee.earnings();

            // Check if the current month is the employee's birthday month
            if (currentMonth == employee.getBirthDate().getMonth()) {
                System.out.println("---Birthday Test Positive---");
                earnings += 100.0;
                System.out.printf("%s%n%s: $%,.2f (with birthday bonus)%n%n",
                                  employee, "earned", earnings);
            }
            //only show employees that have earnings that is 600 and less
            else if(earnings <= 600){
                System.out.println("---600 =< Test Positive---");
                System.out.printf("%s%n%s: $%,.2f%n%n",
                                  employee, "earned", earnings);
            }
        }
    }
}
