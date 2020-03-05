package domain;

public class PaymentWay {
    private static final int CARD = 1;
    private static final int CASH = 2;

    private int paymentWay;

    public PaymentWay(int paymentWay) {
        this.paymentWay = validatePaymentWay(paymentWay);
    }

    private int validatePaymentWay(int paymentWay) {
        if (paymentWay != CARD && paymentWay != CASH) {
            throw new IllegalArgumentException(String.format("결제 수단으로는 1 또는 2만 입력해야 합니다. 입력값 : %d", paymentWay));
        }
        return paymentWay;
    }

    public boolean isCash() {
        return paymentWay == CASH;
    }
}
