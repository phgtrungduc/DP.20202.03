package entity.payment;

import java.util.Date;

public class DomesticCard implements Card  {
    private String type;
    private String issuingBank;
    private String cardNumber;
    private Date validFromDate;
    private String cardHolderName;
}
