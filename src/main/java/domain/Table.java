package domain;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class Table {
	private final int number;
	private Orders orders;

	public Table(final int number) {
		this.number = number;
		this.orders = Orders.createOrders();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
