package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPosNumber() {
        try {
            OutputView.printPosMenus();
            return inputIntegerWithValidation();
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputPosNumber();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            return inputIntegerWithValidation();
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요.");
            return inputIntegerWithValidation();
        } catch (NumberFormatException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputTableNumber();
        }
    }

    private static int inputIntegerWithValidation() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해 주세요");
        }
    }
}
