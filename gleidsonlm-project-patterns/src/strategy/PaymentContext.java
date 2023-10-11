package strategy;

public class PaymentContext {
    private IPaymentStrategy paymentStrategy;

    public void setIPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}