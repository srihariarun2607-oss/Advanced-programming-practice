import java.util.Scanner;

public class HospitalBilling {

    public static double calculateFinalAmount(double fee) {

        double discount;

        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }

        return fee - discount;
    }

    public static void display(String name, double fee) {

        double discount;

        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }

        double finalAmount = calculateFinalAmount(fee);

        System.out.println("\nPatient Name: " + name);
        System.out.println("Original Consultation Fee: Rs." + fee);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Amount: Rs." + finalAmount);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] patientName = new String[5];
        double[] consultationFee = new double[5];

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter details of Patient " + (i + 1));

            System.out.print("Patient Name: ");
            patientName[i] = sc.nextLine();

            System.out.print("Consultation Fee: ");
            consultationFee[i] = sc.nextDouble();

            sc.nextLine();
        }

        System.out.println("\n===== HOSPITAL BILLING =====");

        for (int i = 0; i < 5; i++) {
            display(patientName[i], consultationFee[i]);
        }

        sc.close();
    }
}