package domain;

public class Count {
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 99;

    private int count;

    public Count(int count) {
        checkCountRange(count);
        this.count = count;
    }

    private void checkCountRange(int count) {
        if (count < MIN_COUNT | count > MAX_COUNT) {
            throw new IllegalArgumentException(String.format("주문 가능한 수량이 아닙니다. 현재 입력 : %d", count));
        }
    }

    public int priceTimesCount(int price) {
        return count * price;
    }

    public int getCount() {
        return count;
    }
}
