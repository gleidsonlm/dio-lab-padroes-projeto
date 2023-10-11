package strategy;

public class CreditCard implements IPaymentStrategy {

    private String name;
    private String card;
    private String cvv;
    private String expiration;

    public CreditCard(String name, String card, String cvv, String expiration) {
        this.name = name;
        this.card = card;
        this.cvv = cvv;
        this.expiration = expiration;
    }

    public void pay(double amount) {
        // Process the credit card payment
        System.out.println("used credit card to pay $" + amount);
    }
}