package strategy;

public class Bitcoin implements IPaymentStrategy {
    private String wallet;

    public Bitcoin(String wallet) {
        this.wallet = wallet;
    }

    public void pay(double amount) {
        // Process the Bitcoin payment
        System.out.println("used Bitcoin to pay $" + amount);
    }
}
