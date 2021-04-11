package entity.payment;

import java.util.Date;

public class DebitCard implements Card {
    private String type;
    private String issuingBank;
    private int cardNumber;
    private Date validFromDate;

    public DebitCard() {
    }
}
