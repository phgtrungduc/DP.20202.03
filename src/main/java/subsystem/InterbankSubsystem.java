package subsystem;

<<<<<<< HEAD
import entity.payment.Card;
=======
import entity.payment.CreditCard;
>>>>>>> cleancode/subteam1
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 *
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the controller of the subsystem
	 * Singleton: Lop interbanksubsystem chi nen tao 1 lan vi nghiep vu
	 */
	private InterbankSubsystemController ctrl;
	private static InterbankSubsystem interbankSubsystem;

	public static InterbankSubsystem getInstance() {
		if (interbankSubsystem == null) {
			interbankSubsystem = new InterbankSubsystem();
		}
		return interbankSubsystem;
	}

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
