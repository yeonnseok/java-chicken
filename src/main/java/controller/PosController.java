package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PosController {
    private static Tables tables;
    private static Menus menus;

    static {
        tables = new Tables(TableRepository.tables());
        menus = new Menus(MenuRepository.menus());
    }

    public static void run() {
        OutputView.printFunctionType();
        FunctionType functionType = createFunctionType();
        executeByFunctionType(functionType);
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

    private static void executeByFunctionType(FunctionType functionType) {
        if (FunctionType.ORDER_ENROLL.equals(functionType)) {
            executeOrderEnroll();
        }
        if (FunctionType.PAY.equals(functionType)) {
            executePay();
        }
        if (FunctionType.TERMINATE.equals(functionType)) {
            return;
        }
        run();
    }

    private static void executeOrderEnroll() {
        OutputView.printTables(tables.getTables());
        Table table = selectTable();
        OutputView.printMenus(menus.getMenus());
        Menu menu = selectMenu();
        addMenu(table, menu);
    }

    private static Table selectTable() {
        try {
            int tableNumber = InputView.inputTableNumber();
            return tables.getTableByTableNumber(tableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return selectTable();
        }
    }

    private static Menu selectMenu() {
        try {
            int menuNumber = InputView.inputMenuNumber();
            return menus.getMenuByMenuNumber(menuNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return selectMenu();
        }
    }

    private static Quantity createQuantity() {
        try {
            int quantityNumber = InputView.inputQuantity();
            return new Quantity(quantityNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createQuantity();
        }
    }

    private static void addMenu(Table table, Menu menu) {
        try {
            Quantity quantity = createQuantity();
            table.addMenu(menu, quantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            addMenu(table, menu);
        }
    }

    private static void executePay() {
        OutputView.printTables(tables.getTables());
        Table table = selectTable();
        OutputView.printOrder(table);
        PaymentType paymentType = createPaymentType();
        int amount = Calculator.calculate(table, paymentType);
        OutputView.printAmount(amount);
        table.clearOrder();
    }

    private static PaymentType createPaymentType() {
        try {
            int paymentTypeNumber = InputView.inputPaymentType();
            return PaymentType.getPaymentType(paymentTypeNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return createPaymentType();
        }
    }
}
