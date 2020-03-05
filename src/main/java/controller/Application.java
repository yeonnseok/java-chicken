package controller;

import domain.Menu;
import domain.Menus;
import domain.Table;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
//        final List<Table> tables = Tables.tables();
//        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = Menus.menus();
        OutputView.printMenus(menus);
    }
}
