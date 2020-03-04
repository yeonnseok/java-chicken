package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MIN_QUANTITY = 0;

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        int tableNumber = validateNumber(scanner.nextLine());
        validateNegativeNumber(tableNumber);
        return tableNumber;
    }

    public static int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("입력값은 숫자로만 입력해야합니다. 입력값 : %s", input));
        }
    }

    public static void validateNegativeNumber(int input) {
        if (input < MIN_QUANTITY) {
            throw new IllegalArgumentException(String.format("수량은 0이상의 수를 입력해야 합니다. 입력한 수 : %d", input));
        }
    }
}
