package domain.payment;

import java.util.Arrays;

/**
 * 지불 방식을 나타내는 Enum
 *
 * @author 토니
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

	public static PaymentType of(int inputPaymentNumber) {
		return Arrays.stream(PaymentType.values())
				.filter(paymentType -> paymentType.paymentNumber == inputPaymentNumber)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("입력 번호에 해당하는 지불방식이 없습니다."));
	}

	public int calculateDiscountedPrice(int inputPrice) {
		return (int) ((inputPrice * this.discountRate));
	}
}
