package domain;

import controller.ExitController;
import controller.OrderController;
import controller.PayController;
import controller.PosController;

import java.util.Arrays;

public enum Pos {
    ORDER(1, new OrderController()),
    PAY(2, new PayController()),
    EXIT(3, new ExitController());

    private int posNumber;
    private PosController controller;

    Pos(int posNumber, PosController controller) {
        this.posNumber = posNumber;
        this.controller = controller;
    }

    public static Pos getPos(final int posNumber) {
        try {
            return Arrays.stream(Pos.values())
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
}
