package controller;

import domain.TableNumber;

public class ExitController implements PosController {
    @Override
    public TableNumber controlAction(TableNumber tableNumber) {
        return tableNumber;
    }
}
