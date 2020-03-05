package domain.payment;

import java.util.Arrays;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public enum PaymentType {
	CREDIT_CARD(1, 1),
	CASH(2, 0.95);

	private int paymentNumber;
	private double discountRate;

	PaymentType(final int paymentNumber, final double discountRate) {
		this.paymentNumber = paymentNumber;
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return this.discountRate;
	}

	public static PaymentType of(int inputPaymentNumber) {
		return Arrays.stream(PaymentType.values())
				.filter(paymentType -> paymentType.paymentNumber == inputPaymentNumber)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("입력 번호에 해당하는 지불방식이 없습니다."));
	}
}
