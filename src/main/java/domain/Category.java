package domain;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */

public enum Category {
	CHICKEN("치킨"),
	BEVERAGE("음료");

	private final String name;

	Category(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}
}
