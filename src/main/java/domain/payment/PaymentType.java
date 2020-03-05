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
	CREDIT_CARD(1, 0.95),
	CASH(2, 1);

	private int paymentNumber;
	private double discountRate;

	PaymentType(final int paymentNumber, final double discountRate) {
	}

	public PaymentType of(int inputPaymentNumber) {
		return Arrays.stream(PaymentType.values())
				.filter(paymentType -> this.paymentNumber == inputPaymentNumber)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("입력 번호에 해당하는 지불방식이 없습니다."));
	}
}
