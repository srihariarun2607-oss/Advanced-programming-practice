class Vehicle {
    String vehicleNumber;
    String brand;
    int speed;

    Vehicle(String vehicleNumber, String brand, int speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String vehicleNumber, String brand, int speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(String vehicleNumber, String brand, int speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Has Gear: " + hasGear);
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C101", "Toyota", 120, 4);
        Vehicle v2 = new Bike("B202", "Yamaha", 80, true);

        v1.displayDetails();
        v2.displayDetails();
    }
}
