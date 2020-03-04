import controller.PosController;

/**
 * 프로그램의 실행을 담당하는 main이 있는 클래스
 *
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020/03/04
 */
public class Application {
	public static void main(String[] args) {
		PosController posController = new PosController();
		posController.run();
	}
}
