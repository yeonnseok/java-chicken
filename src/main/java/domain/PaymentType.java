package domain;

import java.util.Arrays;

public enum PaymentType {
    CREDIT(1),
    CASH(2);

    private int type;

    PaymentType(int type) {
        this.type = type;
    }

    public static PaymentType getPaymentType(int type) {
        return Arrays.stream(values())
                .filter(pt -> pt.type == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 결제 수단 입니다."));
    }
}
