package entity.payment;

import java.util.Date;

public class DomesticCard implements Card  {
    private String type;
    private String issuingBank;
    private String cardnumber;
    private Date validFromDate;
    private String cardHolderName;

    public DomesticCard(String type, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}