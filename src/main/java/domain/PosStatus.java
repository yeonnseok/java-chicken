package domain;

import java.util.Arrays;

/**
 * 포스기의 상태를 나타내는 Enum
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/05
 */
public enum PosStatus {
	STATUS_ORDER(1),
	STATUS_PAYING(2),
	STATUS_TERMINATION(3);

	private int statusNumber;

	PosStatus(int statusNumber) {
		this.statusNumber = statusNumber;
	}

	public static PosStatus of(int inputStatusNumber) {
		return Arrays.stream(values())
				.filter(posStatus -> posStatus.statusNumber == inputStatusNumber)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("기능번호가 유효하지 않습니다."));
	}
}
