package domain;

import java.util.Arrays;

public enum PosFunction {
    REGISTER(1),
    PAY(2),
    EXIT(3);

    private int posFunction;

    PosFunction(int posFunction) {
        this.posFunction = posFunction;
    }

    public static PosFunction getPosFunction(int posFunction) {
        return Arrays.stream(PosFunction.values())
                .filter(pf -> pf.posFunction == posFunction)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1,2,3 중 하나의 작업을 선택해주세요."));
    }

    public boolean isRegister() {
        return this == REGISTER;
    }

    public boolean isPay() {
        return this == PAY;
    }

    public boolean isExit() {
        return this == EXIT;
    }
}
