import java.util.Scanner;

public class EmployeeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] employeeId = new int[5];
        String[] name = new String[5];
        double[] monthlySalary = new double[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter details of Employee " + (i + 1));

            System.out.print("Employee ID: ");
            employeeId[i] = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            name[i] = sc.nextLine();

            System.out.print("Monthly Salary: ");
            monthlySalary[i] = sc.nextDouble();
        }

        System.out.println("\n===== EMPLOYEE DETAILS =====");

        for (int i = 0; i < 5; i++) {

            double annualSalary = monthlySalary[i] * 12;
            double bonus;
            String eligibility;

            if (monthlySalary[i] >= 30000) {
                bonus = annualSalary * 0.10;
                eligibility = "Eligible";
            } else {
                bonus = 0;
                eligibility = "Not Eligible";
            }

            System.out.println("\nEmployee ID: " + employeeId[i]);
            System.out.println("Name: " + name[i]);
            System.out.println("Monthly Salary: Rs." + monthlySalary[i]);
            System.out.println("Annual Salary: Rs." + annualSalary);
            System.out.println("Bonus: Rs." + bonus);
            System.out.println("Bonus Eligibility: " + eligibility);
            System.out.println("-------------------------");
        }

        sc.close();
    }
}