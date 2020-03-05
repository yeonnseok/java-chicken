package domain;

import java.util.Arrays;

public enum Pos {
    ORDER(1),
    PAY(2),
    EXIT(3);

    private int posNumber;

    Pos(int posNumber) {
        this.posNumber = posNumber;
    }

    public static Pos getPos(final int posNumber) {
        try {
            return Arrays.stream(Pos.values())
                    .filter(pos -> pos.posNumber == posNumber)
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("선택할 수 없는 메뉴 번호 입니다.");
        }
    }
}
