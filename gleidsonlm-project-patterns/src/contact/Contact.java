package contact;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import strategy.Bitcoin;
import strategy.CreditCard;
import strategy.PayPal;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.UUID;

public class Contact implements IContact {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private CreditCard creditCard = null;
    private PayPal payPal = null;
    private Bitcoin bitcoin = null;

    public Contact(String name, String email, String password) {
        // generate id with uuidv4
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getId() {
        return this.id.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String setEmail(String email) {
        this.email = email;
        return this.email;
    }

    @Override
    public String setPassword(String password) {
        try {
            // Generate a salt
            byte[] salt = new byte[16];
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);

            // Hash the password
            char[] passwordChars = password.toCharArray();
            PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey key = factory.generateSecret(spec);
            byte[] hash = key.getEncoded();

            // Convert the salt and hash to strings and store them
            String saltString = Base64.getEncoder().encodeToString(salt);
            String hashString = Base64.getEncoder().encodeToString(hash);
            this.password = saltString + ":" + hashString;
            return this.password;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean validPassword(String password) {
        String givenPassword = this.setPassword(password);
        return this.password.equals(givenPassword);
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    @Override
    public String setPhone(String phone) {
        this.phone = phone;
        return this.phone;
    }

    @Override
    public CreditCard getCreditCard() {
        return this.creditCard;
    }

    @Override
    public CreditCard setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
        return this.creditCard;
    }

    @Override
    public Bitcoin getBitcoin() {
        return this.bitcoin;
    }

    @Override
    public Bitcoin setBitcoin(String bitcoin) {
        Bitcoin wallet = new Bitcoin(bitcoin);
        this.bitcoin = wallet;
        return this.bitcoin;
    }

    @Override
    public PayPal getPayPal() {
        return this.payPal;
    }

    @Override
    public PayPal setPayPal(String email) {
        PayPal payPal = new PayPal(email);
        this.payPal = payPal;
        return this.payPal;
    }
}