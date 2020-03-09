package domain;

import java.util.Arrays;

public enum FunctionType {
    ORDER_ENROLL(1),
    PAY(2),
    TERMINATE(3);

    private int functionType;

    FunctionType(int functionType) {
        this.functionType = functionType;
    }

    public static FunctionType getFunctionType(int functionType) {
        return Arrays.stream(values())
                .filter(ft -> ft.functionType == functionType)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 기능 번호 입니다."));
    }
}
