package domain;

public class PaymentTypeDiscountStrategy{
    private static final double CASH_DISCOUNT_RATE = 0.95;

    private PaymentTypeDiscountStrategy() {
    }

    public static int discountByPaymentType(int allMenuPrice, PaymentType paymentType) {
        if (PaymentType.CASH.equals(paymentType)) {
            return (int) (allMenuPrice * CASH_DISCOUNT_RATE);
        }
        return allMenuPrice;
    }
}
