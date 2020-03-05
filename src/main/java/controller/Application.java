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
        int toDo;
        do {
            OutputView.printMain();
            toDo = InputView.inputToDo();
            runApplication(tables, toDo);
        } while(toDo != EXIT);
        System.out.println("프로그램을 종료합니다.");
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
