package domain;

import java.util.Arrays;

public enum Pos {
    ORDER(1),
    PAY(2),
    EXIT(3),
    NONE(0);

    private int posNumber;

    Pos(int posNumber) {
        this.posNumber = posNumber;
    }

    public static Pos getPos(int posNumber) {
        return Arrays.stream(Pos.values())
                .filter(pos -> pos.posNumber == posNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
