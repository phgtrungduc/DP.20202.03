package subsystem.interbank;

import entity.payment.Card;
<<<<<<< HEAD
import entity.payment.CreditCard;
=======
>>>>>>> 862f2f3681bd5185d1bd05b3a7d9f3fa3cbf7ebc
import entity.payment.PaymentTransaction;


/**
 * SOLID: Vi pham OCP va DIP: phu thuoc truc tiep vao CreditCard
 * Thay doi phuong thuc thanh toan se phai thay doi code class nay
 * */

/**
 *
 * */
public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(Card card, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
