package controller;

import domain.Menus;
import domain.Tables;

public interface PosController {
    void execute(Tables tables, Menus menus);
}
