import controller.PosController;
import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Tables tables = new Tables(TableRepository.tables());
        final Menus menus = new Menus(MenuRepository.menus());
        Pos pos;

        do {
            pos = getPosWithValidation();
            PosController controller = pos.getController();
            controller.controlAction(tables, menus);
        } while (pos.isNotExit());
    }

    private static Pos getPosWithValidation() {
        try {
            return Pos.getPos(InputView.inputPosNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return getPosWithValidation();
        }
    }
}
