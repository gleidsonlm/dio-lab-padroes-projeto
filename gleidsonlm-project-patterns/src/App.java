import contact.Contact;
import facade.Payment;
import singleton.UserRepository;
import strategy.CreditCard;

public class App {
    public static void main(String[] args) throws Exception {
        UserRepository userRepository = UserRepository.getInstance();
        Contact contact = new Contact("John Doe", "johndoe@example.com", "password");

        // ask user on console to input payment method (credit card, paypal, bitcoin)
        System.out.println("Please, choose a payment method *Strategy* (1: credit card, 2: paypal, 3: bitcoin): ");
        String paymentMethodInput = System.console().readLine();
        String paymentMethod = null;

        switch (paymentMethodInput) {
            case "1":
                CreditCard credictCard = new CreditCard(contact.getName(), "1234567890123456", "123", "12/22");
                contact.setCreditCard(credictCard);
                paymentMethod = "credit card";
                break;
            case "2":
                paymentMethod = "paypal";
                contact.setPayPal(contact.getEmail());
                break;
            case "3":
                String wallet = "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa";
                contact.setBitcoin(wallet);
                paymentMethod = "bitcoin";
                break;

            default:
                System.out.println("Invalid payment method");
                return;
        }
        ;

        System.out.println("Please, choose the amount to pay: ");
        double amount = 0;
        try {
            amount = Double.parseDouble(System.console().readLine());
        } catch (Exception e) {
            System.out.println("Invalid amount");
            return;
        }

        Payment payment = new Payment();

        System.out.println("Processing payment for " + contact.getName() + " ...");
        payment.processPayment(contact, paymentMethod, amount);

    }
}