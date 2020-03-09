package domain;

import controller.OrderController;
import controller.PayController;
import controller.PosController;
import controller.TerminateController;

import java.util.Arrays;

public enum FunctionType {
    ORDER_ENROLL(1, new OrderController()),
    PAY(2, new PayController()),
    TERMINATE(3, new TerminateController());

    private int functionType;
    private PosController posController;

    FunctionType(int functionType, PosController posController) {
        this.functionType = functionType;
        this.posController = posController;
    }

    public static FunctionType getFunctionType(int functionType) {
        return Arrays.stream(values())
                .filter(ft -> ft.functionType == functionType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 기능 번호 입니다."));
    }

    public PosController getController() {
        return this.posController;
    }
}
