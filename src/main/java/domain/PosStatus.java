package domain;

import view.OutputView;

import java.util.Arrays;

/**
 * 클래스 이름 : .java
 *
 * @author
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

	public boolean isOrdering() {
		return this.statusNumber == 1;
	}

	public boolean isPaying() {
		return this.statusNumber == 2;
	}

	public boolean isTerminated() {
		return this.statusNumber == 3;
	}

}
