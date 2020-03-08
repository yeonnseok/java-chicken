package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PosMachine {
    private static Tables tables;
    private static Menus menus;

    static {
        tables = new Tables(TableRepository.tables());
        menus = new Menus(MenuRepository.menus());
    }

    public void run() {
        Pos pos;

        do {
            pos = getPosWithValidation();
            PosController controller = pos.getController();
            controller.controlAction(tables, menus);
        } while (pos.isNotExit());
    }

    private static Pos getPosWithValidation() {
        try {
            return Pos.getPos(InputView.inputPosNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPosWithValidation();
        }
    }
}
