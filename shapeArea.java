import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();
    
    public void displayArea() {
        System.out.println("Area: " + calculateArea());
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    
    double calculateArea() {
        return (base * height) / 2;
    }
}

class ShapeAreaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Shape Area Calculator ===");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Choose shape (1-3): ");
        int choice = sc.nextInt();
        
        Shape shape = null;
        
        if (choice == 1) {
            System.out.print("Enter radius: ");
            double radius = sc.nextDouble();
            shape = new Circle(radius);
            System.out.println("Circle with radius " + radius);
        } else if (choice == 2) {
            System.out.print("Enter length: ");
            double length = sc.nextDouble();
            System.out.print("Enter width: ");
            double width = sc.nextDouble();
            shape = new Rectangle(length, width);
            System.out.println("Rectangle with length " + length + " and width " + width);
        } else if (choice == 3) {
            System.out.print("Enter base: ");
            double base = sc.nextDouble();
            System.out.print("Enter height: ");
            double height = sc.nextDouble();
            shape = new Triangle(base, height);
            System.out.println("Triangle with base " + base + " and height " + height);
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        
        shape.displayArea();
        sc.close();
    }
}