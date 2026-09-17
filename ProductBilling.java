import java.util.Scanner;

public class ProductBilling {

    static int[] productId = new int[5];
    static String[] productName = new String[5];
    static double[] price = new double[5];
    static int[] quantity = new int[5];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEnter details of Product " + (i + 1));

            System.out.print("Product ID: ");
            productId[i] = sc.nextInt();

            sc.nextLine();

            System.out.print("Product Name: ");
            productName[i] = sc.nextLine();

            System.out.print("Price: ");
            price[i] = sc.nextDouble();

            System.out.print("Quantity: ");
            quantity[i] = sc.nextInt();
        }

        System.out.println("\n===== PRODUCT BILL =====");

        for (int i = 0; i < 5; i++) {

            double totalPrice = price[i] * quantity[i];
            double discount;

            if (totalPrice >= 5000) {
                discount = totalPrice * 0.10;
            } else {
                discount = totalPrice * 0.05;
            }

            double finalPrice = totalPrice - discount;

            System.out.println("\nProduct ID: " + productId[i]);
            System.out.println("Name: " + productName[i]);
            System.out.println("Total Price: Rs." + totalPrice);
            System.out.println("Discount: Rs." + discount);
            System.out.println("Final Price: Rs." + finalPrice);
            System.out.println("-------------------------");
        }

        sc.close();
    }
}