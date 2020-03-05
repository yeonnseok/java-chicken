package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1, 0),
    CASH(2, 0.05);

    private int paymentNumber;
    private double discountRatio;

    Payment(int paymentNumber, double discountRatio) {
        this.paymentNumber = paymentNumber;
        this.discountRatio = discountRatio;
    }

    public static Payment getPayment(int paymentNumber) {
        try {
            return Arrays.stream(Payment.values())
                    .filter(pay -> pay.paymentNumber == paymentNumber)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("선택할 수 없는 번호 입니다.");
        }
    }

    public int totalPriceAfterPaymentDiscount (int totalPriceDiscountedByChickenCount) {
        return (int) ((1 - this.discountRatio) * totalPriceDiscountedByChickenCount);
    }
}
