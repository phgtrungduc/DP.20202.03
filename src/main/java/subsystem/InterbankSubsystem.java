package subsystem;

import entity.payment.Card;
<<<<<<< HEAD
import entity.payment.CreditCard;
=======
>>>>>>> 862f2f3681bd5185d1bd05b3a7d9f3fa3cbf7ebc
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
	 */
	private static InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	private InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}
<<<<<<< HEAD
	public static InterbankSubsystem getInstance(){
		if (interbankSubsystem==null)  interbankSubsystem = new InterbankSubsystem();
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
=======

>>>>>>> 862f2f3681bd5185d1bd05b3a7d9f3fa3cbf7ebc
	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

<<<<<<< HEAD
	/**
	 * @see InterbankInterface#refund(Card, int,
	 *      String)
	 */
=======
>>>>>>> 862f2f3681bd5185d1bd05b3a7d9f3fa3cbf7ebc
	public PaymentTransaction refund(Card card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
