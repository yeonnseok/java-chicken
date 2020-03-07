package controller;

import domain.Menus;
import domain.PosFunction;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Tables tables = new Tables();
        PosFunction posFunction;
        do {
            OutputView.printMain();
            posFunction = inputPosFunction();
            runApplication(tables, posFunction);
        } while (!posFunction.isExit());
        OutputView.printExitMessage();
    }

    private static PosFunction inputPosFunction() {
        try {
            int posFunction = InputView.inputToDo();
            return PosFunction.getPosFunction(posFunction);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputPosFunction();
        }
    }

    private static void runApplication(Tables tables, PosFunction posFunction) {
        if (posFunction.isRegister()) {
            Menus menus = new Menus();
            RegisterController.startRegister(tables, menus);
        }
        if (posFunction.isPay()) {
            PayController.startPay(tables);
        }
    }
}
