package contact;

import strategy.Bitcoin;
import strategy.CreditCard;
import strategy.PayPal;

public interface IContact extends IUser {
    public String getName();

    public String setName(String name);

    public String getEmail();

    public String setEmail(String email);

    public String getPhone();

    public String setPhone(String phone);

    public Boolean validPassword(String password);

    public String setPassword(String password);

    public CreditCard getCreditCard();

    public CreditCard setCreditCard(CreditCard creditCard);

    public PayPal getPayPal();

    public PayPal setPayPal(String email);

    public Bitcoin getBitcoin();

    public Bitcoin setBitcoin(String bitcoin);
}
