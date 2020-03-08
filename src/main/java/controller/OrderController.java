package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class OrderController implements PosController {
    final Tables tables = new Tables(TableRepository.tables());
    final Menus menus = new Menus(MenuRepository.menus());

    @Override
    public TableNumber controlAction(TableNumber tableNumber) {
        OutputView.printTables(tables, tableNumber);
        tableNumber = inputTableNumberWithValidation(tableNumber);
        OutputView.printMenus(menus);
        MenuNumber menuNumber = inputMenuNumberWithValidation();
        Count count = inputCountWithValidation();
        Table currentTable = tables.getTableByNumber(tableNumber);
        currentTable.addToOrders(menus.getMenuByNumber(menuNumber), count);
        return tableNumber;
    }

    private static Count inputCountWithValidation() {
        try {
            return new Count(InputView.inputCount());
        } catch(IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputCountWithValidation();
        }
    }

    private static MenuNumber inputMenuNumberWithValidation() {
        try {
            return new MenuNumber(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputMenuNumberWithValidation();
        }
    }

    private static TableNumber inputTableNumberWithValidation(final TableNumber tableNumber) {
        try {
            int inputNumber = InputView.inputTableNumber();
            return new TableNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return inputTableNumberWithValidation(tableNumber);
        }
    }
}
