package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

// Ap dung Singleton
public class InterbankSubsystemController {

	private static InterbankSubsystemController instance=null;

	private InterbankSubsystemController() {

	}

	public static InterbankSubsystemController getInstance() {
		if (instance==null) instance =new InterbankSubsystemController();
		return instance;
	};


	private static InterbankPayloadConverter interbankPayloadConverter = InterbankPayloadConverter.getInstance();
	private static InterbankBoundary interbankBoundary = InterbankBoundary.getInstance();

	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
