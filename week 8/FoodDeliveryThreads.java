public class FoodDeliveryThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread orderProcessing = new OrderProcessing();
        Thread deliveryTracking = new DeliveryTracking();
        Thread notification = new Notification();

        orderProcessing.setPriority(Thread.MAX_PRIORITY);
        deliveryTracking.setPriority(Thread.NORM_PRIORITY);
        notification.setPriority(Thread.MIN_PRIORITY);

        displayThread(orderProcessing);
        displayThread(deliveryTracking);
        displayThread(notification);

        orderProcessing.start();
        deliveryTracking.start();
        notification.start();

        orderProcessing.join();
        deliveryTracking.join();
        notification.join();
    }

    private static void displayThread(Thread thread) {
        System.out.println(thread.getName() + " priority: " + thread.getPriority());
    }
}

class OrderProcessing extends Thread {
    OrderProcessing() {
        super("OrderProcessing");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is processing a customer order.");
    }
}

class DeliveryTracking extends Thread {
    DeliveryTracking() {
        super("DeliveryTracking");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is tracking a delivery location.");
    }
}

class Notification extends Thread {
    Notification() {
        super("Notification");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is sending an order-status notification.");
    }
}