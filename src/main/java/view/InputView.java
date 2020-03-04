package view;

import java.util.Scanner;

public class InputView {
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputFunctionType() {
        System.out.println("## 원하는 기능을 선택하세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(NUMBER_FORMAT_ERROR_MESSAGE);
            return inputFunctionType();
        }
    }

    public static int inputTableNumber() {
        System.out.println("\n## 테이블을 선택하세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(NUMBER_FORMAT_ERROR_MESSAGE);
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(NUMBER_FORMAT_ERROR_MESSAGE);
            return inputMenuNumber();
        }
    }

    public static int inputQuantity() {
        System.out.println("\n## 메뉴의 수량을 입력하세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(NUMBER_FORMAT_ERROR_MESSAGE);
            return inputQuantity();
        }
    }
}
