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
        PosNumber posNumber;

        do {
            posNumber = getPosWithValidation();
            PosController controller = posNumber.getController();
            controller.controlAction(tables, menus);
        } while (posNumber.isNotExit());
    }

    private static PosNumber getPosWithValidation() {
        try {
            return PosNumber.getPosNumber(InputView.inputPosNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPosWithValidation();
        }
    }
}
