import controller.PosMachine;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            PosMachine posMachine = new PosMachine();
            posMachine.run();
        } catch (IllegalArgumentException | NullPointerException e) {
            OutputView.printExceptionMessage(e.getMessage());
            main(args);
        }
    }
}
