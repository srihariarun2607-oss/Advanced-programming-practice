import java.util.Scanner;

public class StudentPerformance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] rollNumber = new int[5];
        String[] name = new String[5];
        int[][] marks = new int[5][3];
        double[] attendance = new double[5];
        double[] average = new double[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Roll Number: ");
            rollNumber[i] = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            name[i] = sc.nextLine();

            for (int j = 0; j < 3; j++) {
                System.out.print("Mark " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
            }

            System.out.print("Attendance: ");
            attendance[i] = sc.nextDouble();

            int total = 0;

            for (int j = 0; j < 3; j++) {
                total = total + marks[i][j];
            }

            average[i] = total / 3.0;
        }

        System.out.println("\n===== STUDENT PERFORMANCE =====");

        int highestIndex = 0;

        for (int i = 0; i < 5; i++) {

            int total = 0;

            for (int j = 0; j < 3; j++) {
                total = total + marks[i][j];
            }

            String result;
            if (average[i] >= 50) {
                result = "Pass";
            } else {
                result = "Fail";
            }

            String scholarship;
            if (average[i] >= 75 && attendance[i] >= 80) {
                scholarship = "Eligible";
            } else {
                scholarship = "Not Eligible";
            }

            String performance;
            if (average[i] >= 85) {
                performance = "Excellent";
            } else {
                performance = "Good";
            }

            System.out.println("\nRoll Number: " + rollNumber[i]);
            System.out.println("Name: " + name[i]);
            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + average[i]);
            System.out.println("Attendance: " + attendance[i] + "%");
            System.out.println("Result: " + result);
            System.out.println("Scholarship: " + scholarship);
            System.out.println("Performance: " + performance);
            System.out.println("-------------------------");

            if (average[i] > average[highestIndex]) {
                highestIndex = i;
            }
        }

        System.out.println("\n===== HIGHEST AVERAGE =====");
        System.out.println("Name: " + name[highestIndex]);
        System.out.println("Roll Number: " + rollNumber[highestIndex]);
        System.out.println("Highest Average: " + average[highestIndex]);

        sc.close();
    }
}