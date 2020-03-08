package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05);

    private static final int DISCOUNT_FROM = 1;

    private int paymentNumber;
    private double discountRatio;

    Payment(final int paymentNumber, final double discountRatio) {
        this.paymentNumber = paymentNumber;
        this.discountRatio = discountRatio;
    }

    public static Payment getPayment(final int paymentNumber) {
        return Arrays.stream(Payment.values())
                .filter(pay -> pay.paymentNumber == paymentNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 번호 입니다."));
    }

    public int totalPriceAfterDiscount(final int totalPrice) {
        return (int) ((DISCOUNT_FROM - this.discountRatio) * totalPrice);
    }
}
