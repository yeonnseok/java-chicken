package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int MIN_QUANTITY = 0;

    public static int inputTableNumber() {
        OutputView.printInputTableNumber();
        return validateNumber(SCANNER.nextLine());
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("입력값은 숫자로만 입력해야합니다. 입력값 : %s", input));
        }
    }

    public static int validateNegativeNumber(int input) {
        if (input < MIN_QUANTITY) {
            throw new IllegalArgumentException(String.format("수량은 0이상의 수를 입력해야 합니다. 입력한 수 : %d", input));
        }
        return input;
    }

    public static int inputToDo() {
        OutputView.printInputToDo();
        return validateNumber(SCANNER.nextLine());
    }

    public static int inputRegisterMenu() {
        OutputView.printInputRegisterMenu();
        return validateNumber(SCANNER.nextLine());
    }

    public static int inputMenuQuantity() {
        OutputView.printInputMenuQuantity();
        int menuQuantity = validateNumber(SCANNER.nextLine());
        return validateNegativeNumber(menuQuantity);
    }
}
