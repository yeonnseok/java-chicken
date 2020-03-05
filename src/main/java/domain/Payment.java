package domain;

import java.util.Arrays;

public enum Payment {
    CARD(1),
    CASH(2),
    NONE(0);

    private int paymentNumber;

    Payment(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public static Payment getPayment(int paymentNumber) {
        return Arrays.stream(Payment.values())
                .filter(pay -> pay.paymentNumber == paymentNumber)
                .findFirst()
                .orElse(NONE);
    }

}
