package view;

import java.util.Scanner;

/**
 * 입력을 담당하는 클래스
 *
 * @author  토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {}

	public static int askIntegerInput() {
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException e) {
			OutputView.printExceptionMessage("정수만 입력해주세요");
			return askIntegerInput();
		}
	}
}
