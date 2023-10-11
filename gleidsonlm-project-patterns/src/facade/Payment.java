package facade;

import contact.Contact;
import strategy.Bitcoin;
import strategy.CreditCard;
import strategy.IPaymentStrategy;
import strategy.PayPal;
import strategy.PaymentContext;

public class Payment {
    private PaymentContext paymentContext;

    public Payment() {
        paymentContext = new PaymentContext();
    }

    public void processPayment(Contact contact, String paymentMethod, double amount) {
        IPaymentStrategy paymentStrategy = null;

        // Set the payment strategy based on the payment method chosen by the user
        if (paymentMethod.equals("credit card")) {
            CreditCard creditCard = contact.getCreditCard();
            paymentStrategy = creditCard;
        } else if (paymentMethod.equals("paypal")) {
            PayPal payPal = contact.getPayPal();
            paymentStrategy = payPal;
        } else if (paymentMethod.equals("bitcoin")) {
            Bitcoin bitcoin = new Bitcoin("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
            paymentStrategy = bitcoin;
        }

        // Process the payment using the selected payment strategy
        paymentContext.setIPaymentStrategy(paymentStrategy);
        paymentContext.pay(amount);
    }
}