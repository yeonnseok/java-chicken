package controller;

import domain.Menus;
import domain.Tables;
import view.InputView;
import view.OutputView;

public class Application {
    private static final int REGISTER = 1;
    private static final int PAY = 2;
    private static final int EXIT = 3;

    public static void main(String[] args) {
        Tables tables = new Tables();
        int toDo;
        do {
            OutputView.printMain();
            toDo = inputToDo();
            runApplication(tables, toDo);
        } while(toDo != EXIT);
        OutputView.printExitMessage();
    }

    private static int inputToDo() {
        try {
            int toDo = InputView.inputToDo();
            return validateToDo(toDo);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputToDo();
        }
    }

    private static int validateToDo(int toDo) {
        if (toDo != REGISTER && toDo != PAY && toDo != EXIT) {
            throw new IllegalArgumentException("1,2,3 중 하나의 기능을 선택해주세요.");
        }
        return toDo;
    }

    private static void runApplication(Tables tables, int toDo) {
        if (toDo == REGISTER) {
            Menus menus = new Menus();
            RegisterController.startRegister(tables, menus);
        }
        if (toDo == PAY) {
            PayController.startPay(tables);
        }
    }
}
