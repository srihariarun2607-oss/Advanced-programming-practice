interface Payment {
    void pay(double amount);
}

interface SecurePayment extends Payment {
    void verifyPayment();
}

interface OnlineTransaction { }

class Account {
    String accountNumber;
    String holderName;

    Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber, String holderName, double interestRate) {
        super(accountNumber, holderName);
        this.interestRate = interestRate;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Savings Account Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountNumber, String holderName, double overdraftLimit) {
        super(accountNumber, holderName);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

class UPIPayment implements SecurePayment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI.");
    }

    public void verifyPayment() {
        System.out.println("UPI Payment verified successfully.");
    }
}

class CardPayment implements Payment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Card.");
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("S101", "Varun", 5.0);
        Account acc2 = new CurrentAccount("C202", "Priya", 20000);

        acc1.displayDetails();
        acc2.displayDetails();

        Payment p1 = new UPIPayment();
        Payment p2 = new CardPayment();

        p1.pay(1000);
        p2.pay(2000);

        if (p1 instanceof OnlineTransaction) {
            System.out.println("UPI Payment is an online transaction.");
        }
        if (p2 instanceof OnlineTransaction) {
            System.out.println("Card Payment is an online transaction.");
        }

        SecurePayment sp = new UPIPayment();
        sp.verifyPayment();
    }
}
