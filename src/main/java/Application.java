import controller.PosController;
import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Pos pos = getPosWithValidation();
        do {
            PosController controller = pos.getController();
            controller.controlAction();
            pos = getPosWithValidation();
        } while (pos != Pos.EXIT);
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
