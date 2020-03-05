package controller;

import domain.Menu;
import domain.Menus;
import domain.Table;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final int REGISTER = 1;
    private static final int PAY = 2;
    private static final int EXIT = 3;

    public static void main(String[] args) {
        Tables tables = new Tables();
        do {
            runApplication(tables);
        } while(true);
    }

    private static void runApplication(Tables tables) {
        OutputView.printMain();
        int toDo = InputView.inputToDo();
        if (toDo == REGISTER) {
            Menus menus = new Menus();
            RegisterController.startRegister(tables, menus);
        }
        if (toDo == PAY) {

        }
        if (toDo == EXIT) {

        }
    }
}
