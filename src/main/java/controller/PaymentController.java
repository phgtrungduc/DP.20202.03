package controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */
public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */
	private CreditCard card;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbank;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link String String} representing the date in the
	 * required format "mmyy" .
	 *
	 * @return {@link String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */
	private boolean isMonth(int month) {
		if (month < 1 || month > 12)
			return false;
		return true;
	}

	private boolean isYear(int year) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100;
		int maxYear = 100;
		if (year < currentYear || year > maxYear) {
			return false;
		}
		return true;
	}

	//sua doi bieu thuc dieu kien thanh cac method lam ro y nghia cua dieu kien
	private String getExpirationDate(String date) throws InvalidCardException {
		String[] stringDate = date.split("/");

		if (stringDate.length != 2) {
			throw new InvalidCardException();
		}


		int month = -1;
		int year = -1;

		try {
			month = Integer.parseInt(strs[0]);
			year = Integer.parseInt(strs[1]);
			DateFormat dateFormat = new DateFormat(month, year);
			if (dateFormat.isInvalidDate()){
				throw new InvalidCardException();
			}
			return dateFormat.getExpirationDate();

		} catch (Exception ex) {
			throw new InvalidCardException();
		}
	}

	/**
	 * Pay order, and then return the result with a message.
	 * 
	 * @param amount         - the amount to pay
	 * @param contents       - the transaction contents
	 * @return {@link Map Map} represent the payment result with a
	 *         message.
	 */
	//qua nhieu tham so truyen vao cho payOrder, dong goi lai va truyen vao 1 object
	public Map<String, String> payOrder(int amount, String contents, CreditCard creditCard) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.card = new CreditCard(
					cardNumber,
					cardHolderName,
					getExpirationDate(expirationDate),
					Integer.parseInt(securityCode));

			this.interbank = InterbankSubsystem.getInstance();
			interbank.payOrder(card, amount, contents);

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}

	public void emptyCart(){
        SessionInformation.cartInstance.emptyCart();
    }
}