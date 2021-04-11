package entity.payment;

/**
 * @author
 */
<<<<<<< HEAD
public class CreditCard implements Card{
=======
public class CreditCard implements Card {
>>>>>>> 862f2f3681bd5185d1bd05b3a7d9f3fa3cbf7ebc

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
