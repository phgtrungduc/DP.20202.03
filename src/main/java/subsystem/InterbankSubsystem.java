package subsystem;

import entity.payment.Card;
import entity.payment.CreditCard;
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

	private static InterbankSubsystem interbankSubsystem=null;
	/**
	 * Represent the controller of the subsystem
	 * Singleton: Lop interbanksubsystem chi nen tao 1 lan vi nghiep vu
	 */
	private static InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	private InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}
	public static InterbankSubsystem getInstance(){
		if (interbankSubsystem==null) return interbankSubsystem;
		return interbankSubsystem;
	}
	/**
	 * @see InterbankInterface#payOrder(CreditCard, int,
	 *      String)
	 */

	/**
	 * SOLID: Vi pham OCP va DIP: phu thuoc truc tiep vao CreditCard
	 * Thay doi phuong thuc thanh toan se phai thay doi code class nay
	 * */
	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(Card, int,
	 *      String)
	 */
	public PaymentTransaction refund(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
