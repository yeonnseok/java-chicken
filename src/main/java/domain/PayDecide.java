package domain;

import java.util.Arrays;

public enum PayDecide {
    YES(1) {
        public void finalAction(Table table) {
            table.clearOrders();
        }
    },
    NO(2) {
        public void finalAction(Table table) {
        }
    };

    private int payDecide;

    PayDecide(int payDecide) {
        this.payDecide = payDecide;
    }

    public static PayDecide getPayDecide(final int payDecide) {
        try {
            return Arrays.stream(PayDecide.values())
                    .filter(pay -> pay.payDecide == payDecide)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("선택할 수 없는 번호 입니다.");
        }
    }

    public abstract void finalAction(final Table table);
}
