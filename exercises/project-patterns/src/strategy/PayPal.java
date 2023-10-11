package strategy;

public class PayPal implements IPaymentStrategy {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        // Process the PayPal payment
        System.out.println("used PayPal to pay $" + amount);
    }
}
