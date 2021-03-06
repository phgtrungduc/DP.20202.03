package controller;

import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import common.function.CommonFunctionDate;
import entity.payment.Card;
import entity.payment.CreditCard;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */

/**
 * SOLID: Vi pham nguyen ly OCP : khi thay doi phuong thuc thanh toan phai thay doi code cua class nay
 * Vi Pham nguyen ly: DIP : Phu thuoc truc tiep vao CreditCard khong qua mot module abstract
 * */
/**
 * Large class
 * ngoài method liên quan đến payment thì còn có
 * isValidMonthandYea
 * */
public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */

	private Card card;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbank;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link String String} representing the date in the
	 * required format "mmyy" .
	 * 
	 * @param date - the {@link String String} represents the input date
	 * @return {@link String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount         - the amount to pay
	 * @param contents       - the transaction contents
	 * @param cardNumber     - the card number
	 * @param cardHolderName - the card holder name
	 * @param expirationDate - the expiration date in the format "mm/yy"
	 * @param securityCode   - the cvv/cvc code of the credit card
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */
	/**
	 * bỏ biến thừa transaction không dùng đến nhưng vẫn giữ nguyên thực hiện hàm payOrder
	 * */
	public Map<String, String> payOrder(int amount, String contents, String cardNumber, String cardHolderName,
										String expirationDate, String securityCode) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = new CreditCard(
					cardNumber,
					cardHolderName,
					CommonFunctionDate.getExpirationDate(expirationDate),
					Integer.parseInt(securityCode));

			this.interbank =  InterbankSubsystem.getInstance();
			interbank.payOrder(card, amount, contents);
			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}

	public void emptyCart(){
        SessionInformation.getCartInstance().emptyCart();
    }
}