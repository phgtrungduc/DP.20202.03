package subsystem.interbank;

import common.exception.*;
import entity.payment.Card;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import utils.MapData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author
 */
public class InterbankPayloadConverter {

    /**
     * Convert from native entity into interbank required format
     * @param card
     * @param amount
     * @param contents
     * @return
     */
    String convertToRequestPayload(Card card, int amount, String contents) {
        Map<String, Object> transaction = new MapData();

        try {
            transaction.putAll(MapData.convertObjectToMapData(card));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new InvalidCardException();
        }
        transaction.put("command", InterbankConfigs.PAY_COMMAND);
        transaction.put("transactionContent", contents);
        transaction.put("amount", amount);
        transaction.put("createdAt", getToday());

        Map<String, Object> requestMap = new MapData();
        requestMap.put("version", InterbankConfigs.VERSION);
        requestMap.put("transaction", transaction);

        return ((MapData) requestMap).toJSON();
    }

    /**
     * Read the response from interbank server
     * @param responseText
     * @return
     */
    PaymentTransaction extractPaymentTransaction(String responseText) {
        MapData response = convertJSONResponse(responseText);

        if (response == null)
            return null;
            MapData transaction = (MapData) response.get("transaction");
        CreditCard card = new CreditCard(
                (String) transaction.get("cardCode"),
                (String) transaction.get("owner"),
                (String) transaction.get("dateExpired"),
                Integer.parseInt((String) transaction.get("cvvCode")));

        PaymentTransaction trans = new PaymentTransaction(
                (String) response.get("errorCode"),
                card,
                (String) transaction.get("transactionId"),
                (String) transaction.get("transactionContent"),
                Integer.parseInt((String) transaction.get("amount")),
                (String) transaction.get("createdAt"));

        switch (trans.getErrorCode()) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        return trans;
    }

    /**
     * Convert response from interbank server as JSON-formatted String into a proper Map
     * @param responseText
     * @return
     */
    private MapData convertJSONResponse(String responseText) {
        MapData response = null;
        try {
            response = MapData.convertObjectToMapDataStartedAtIndex(responseText, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new UnrecognizedException();
        }
        return response;
    }

    /**
     * Return a {@link String String} that represents the current time in the format of yyyy-MM-dd HH:mm:ss.
     *
     * @author hieudm
     * @return the current time as {@link String String}.
     */


    /**
     * Coincidental Cohesion
     * Hàm này đang thức hiện chức năng không liên quan đến tất cả các hàm còn lại
     * */
    private String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
