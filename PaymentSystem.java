abstract class PaymentMethod {
    protected String transactionID;
    protected double amount;
    
    public PaymentMethod(String transactionID, double amount) {
        this.transactionID = transactionID;
        this.amount = amount;
    }
    
    abstract void makePayment();
    
    public void displayDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
    }
}

class UPI extends PaymentMethod {
    private String upiID;
    
    public UPI(String transactionID, double amount, String upiID) {
        super(transactionID, amount);
        this.upiID = upiID;
    }
    
    void makePayment() {
        System.out.println("Payment done via UPI");
        displayDetails();
        System.out.println("UPI ID: " + upiID);
    }
}

class CreditCard extends PaymentMethod {
    private String cardNumber;
    
    public CreditCard(String transactionID, double amount, String cardNumber) {
        super(transactionID, amount);
        this.cardNumber = cardNumber;
    }
    
    void makePayment() {
        System.out.println("Payment done via Credit Card");
        displayDetails();
        System.out.println("Card Number: " + cardNumber);
    }
}

class NetBanking extends PaymentMethod {
    private String bankName;
    
    public NetBanking(String transactionID, double amount, String bankName) {
        super(transactionID, amount);
        this.bankName = bankName;
    }
    
    void makePayment() {
        System.out.println("Payment done via Net Banking");
        displayDetails();
        System.out.println("Bank: " + bankName);
    }
}

class PaymentMain {
    public static void main(String[] args) {
        UPI upi = new UPI("TXN001", 500, "user@upi");
        upi.makePayment();
        System.out.println();
        
        CreditCard card = new CreditCard("TXN002", 1000, "1234567890123456");
        card.makePayment();
        System.out.println();
        
        NetBanking netbank = new NetBanking("TXN003", 2000, "State Bank of India");
        netbank.makePayment();
    }
}