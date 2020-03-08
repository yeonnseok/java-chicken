package domain;

import controller.ExitController;
import controller.OrderController;
import controller.PayController;
import controller.PosController;

import java.util.Arrays;

public enum PosNumber {
    ORDER(1, new OrderController()),
    PAY(2, new PayController()),
    EXIT(3, new ExitController());

    private int posNumber;
    private PosController controller;

    PosNumber(int posNumber, PosController controller) {
        this.posNumber = posNumber;
        this.controller = controller;
    }

    public static PosNumber getPosNumber(final int posNumber) {
        try {
            return Arrays.stream(PosNumber.values())
                    .filter(pos -> pos.posNumber == posNumber)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("선택할 수 없는 메뉴 번호 입니다.");
        }
    }

    public PosController getController() {
        return controller;
    }

    public boolean isNotExit() {
        return this != EXIT;
    }
}
