abstract class Product {
    protected String productID;
    protected String name;
    protected double price;
    
    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }
    
    abstract double calculateDiscount();
    
    public double getFinalPrice() {
        return price - calculateDiscount();
    }
    
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Original Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Final Price: " + getFinalPrice());
    }
}

class Electronics extends Product {
    public Electronics(String productID, String name, double price) {
        super(productID, name, price);
    }
    
    double calculateDiscount() {
        return price * 0.15;
    }
}

class Clothing extends Product {
    public Clothing(String productID, String name, double price) {
        super(productID, name, price);
    }
    
    double calculateDiscount() {
        return price * 0.20;
    }
}

class Books extends Product {
    public Books(String productID, String name, double price) {
        super(productID, name, price);
    }
    
    double calculateDiscount() {
        return price * 0.10;
    }
}

class ShoppingMain {
    public static void main(String[] args) {
        Electronics laptop = new Electronics("E001", "Laptop", 50000);
        laptop.displayDetails();
        System.out.println();
        
        Clothing shirt = new Clothing("C001", "Shirt", 2000);
        shirt.displayDetails();
        System.out.println();
        
        Books novel = new Books("B001", "Novel", 500);
        novel.displayDetails();
    }
}