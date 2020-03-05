package domain.payment;

/**
 * 현금 할인에 관한 객체
 *
 * @author 토니
 * @versin 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public class CashDiscountStrategy {
	private CashDiscountStrategy() {}

	public static CashDiscountStrategy create() {
		return new CashDiscountStrategy();
	}

	public static int discount(int inputPrice, PaymentType paymentType) {
		return (int) ((inputPrice * paymentType.getDiscountRate()));
	}
}
