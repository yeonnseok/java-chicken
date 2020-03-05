package domain;

public enum PaymentDiscount {
    CARD(1), CASH(0.95);

    private double discountRatio;

    PaymentDiscount(double discountRatio) {
        this.discountRatio = discountRatio;
    }

    public double getDiscountRatio() {
        return this.discountRatio;
    }
}
