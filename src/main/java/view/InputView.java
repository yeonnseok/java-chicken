package view;

import java.util.Scanner;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int askTableNumber() { // TODO: 2020/03/04 아래와 겹치네?
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			OutputView.printExceptionMessage("정수만 입력해주세요");
			return askTableNumber();
		}
	}

	public static int askMenuNumber() {
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			OutputView.printExceptionMessage("정수만 입력해주세요");
			return askMenuNumber();
		}
	}

	public static int askAmount() {
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			OutputView.printExceptionMessage("정수만 입력해주세요");
			return askAmount();
		}
	}
}
