import java.util.Scanner;
public class Rectangle {
    double len;
    double wid;
    
    void area(){
        System.out.println("Area: " + (len * wid));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Rectangle r = new Rectangle();
        System.out.println("Enter length: ");
        r.len = s.nextDouble();
        System.out.println("Enter width: ");
        r.wid = s.nextDouble();
        r.area();
    }
}
