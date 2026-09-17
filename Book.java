import java.util.Scanner;
public class Book {
    String title;
    String author;
    double price;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Book b = new Book();
        System.out.println("Enter title: ");
        b.title = s.nextLine();
        System.out.println("Enter author: ");
        b.author = s.nextLine();
        System.out.println("Enter price: ");
        b.price = s.nextDouble();
        System.out.println("\nTitle: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Price: " + b.price);
    }
}
