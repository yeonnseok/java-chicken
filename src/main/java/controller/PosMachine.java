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

    public static void run() {
        FunctionType functionType;

        do {
            OutputView.printFunctionType();
            functionType = createFunctionType();
            PosController posController = functionType.getController();
            posController.execute(tables, menus);
        } while (!FunctionType.TERMINATE.equals(functionType));
    }

    private static FunctionType createFunctionType() {
        try {
            int functionTypeNumber = InputView.inputFunctionType();
            return FunctionType.getFunctionType(functionTypeNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createFunctionType();
        }
    }
}
