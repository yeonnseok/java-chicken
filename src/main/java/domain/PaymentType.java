package domain;

import java.util.Arrays;

public enum PaymentType {
    CREDIT(1),
    CASH(2);

    private int paymentType;

    PaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public static PaymentType getPaymentType(int paymentType) {
        return Arrays.stream(values())
                .filter(pt -> pt.paymentType == paymentType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결제 수단 입니다."));
    }
}
