package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05),
    NONE(0, 0);

    private int paymentNumber;
    private double discountRatio;

    Payment(int paymentNumber, double discountRatio) {
        this.paymentNumber = paymentNumber;
        this.discountRatio = discountRatio;
    }

    public static Payment getPayment(int paymentNumber) {
        return Arrays.stream(Payment.values())
                .filter(pay -> pay.paymentNumber == paymentNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int totalPriceAfterPaymentDiscount (int totalPriceDiscountedByChickenCount) {
        return (int) ((1 - this.discountRatio) * totalPriceDiscountedByChickenCount);
    }
}
