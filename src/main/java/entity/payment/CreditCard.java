package entity.payment;

/**
 *
 * SOLID: Vi phạm nguyên lý OCP vì Khi them 1 loai the moi thi chua ke thua duoc the Credit Card
 * @author
 */
public class CreditCard {

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
