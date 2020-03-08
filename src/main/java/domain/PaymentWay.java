package domain;

import java.util.Arrays;

public enum PaymentWay {
    CARD(1, 1),
    CASH(2, 0.95);

    private int paymentWay;
    private double discountRatio;

    PaymentWay(int paymentWay, double discountRatio) {
        this.paymentWay = paymentWay;
        this.discountRatio = discountRatio;
    }

    public static PaymentWay getPayment(int paymentWay) {
        return Arrays.stream(PaymentWay.values())
                .filter(p -> p.paymentWay == paymentWay)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("결제 수단으로는 1 또는 2만 입력해야 합니다. " +
                        "입력값 : %d", paymentWay)));
    }

    public double applyPaymentWayDiscount(double totalMoney) {
        return totalMoney * this.discountRatio;
    }

    public boolean isCash() {
        return this == CASH;
    }
}
