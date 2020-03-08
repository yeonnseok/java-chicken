# java-chicken
온라인 코드리뷰 스터디  
치킨집 TDD 연습
---
## 기능 구현 목록
1. 주문 등록, 결제, 프로그램 종료 중 하나의 기능을 선택한다.
    - [x] 입력 값이 숫자인지 검증
    - [x] 입력 값이 1,2,3 중 하나인지 검증
2. 선택에 따른 기능을 수행한다.

### 1. 주문 등록 선택시
1. 현재 테이블 상태를 출력하여 보여준다.
2. 테이블 번호를 선택한다.
    - [x] 테이블 번호가 숫자인지 검증
    - [x] 테이블 번호가 존재하는 테이블 번호인지 검증
3. 치킨집의 메뉴를 출력하여 보여준다.
4. 등록할 메뉴의 번호를 입력받는다
    - [x] 메뉴 번호가 숫자인지 검증
    - [x] 메뉴 번호가 존재하는 메뉴 번호인지 검증
5. 메뉴의 수량을 입력받는다.
    - [x] 수량이 숫자인지 검증
    - [x] 수량이 0이상인지 검증
    - [x] 해당 테이블에 입력한 수량을 넣었을 때, 99를 초과하지 않는지 검증

### 2. 결제 기능 선택시
1. 현재 테이블 상태를 출력하여 보여준다.
2. 결제를 진행할 테이블 번호를 입력받는다.
    - [x] 테이블 번호가 숫자인지 검증
    - [x] 테이블 번호가 존재하는 테이블 번호인지 검증
    - [x] 선택한 테이블에 주문 내역이 있는지 검증
3. 해당 테이블의 주문 내역을 출력하여 보여준다.
4. 결제 수단을 신용카드와 현금 중 선택한다.
    - [x] 결제 수단이 숫자인지 검증
    - [x] 결제 수단이 존재하는 결제 수단(1 또는 2)인지 검증
5. 주문 내역에 따른 할인 진행
    - [x] 치킨 종류 수량 10개 당 1만원씩 할인한다. ex) 23개 치킨 -> 2만원 할인
    - [x] 치킨 종류 할인을 한 후, 결제 수단이 현금이면 추가로 5%의 할인을 적용한다.
6. 최종 결제 금액을 출력하여 보여준다.
7. 결제가 완료되었으면 해당 테이블의 주문 내역을 삭제한다.
    
### 3. 프로그램 종료 선택시
1. 프로그램을 종료한다.

### controller(main)
- Application : 주문 등록, 결제, 프로그램 종료에 따른 기능을 수행한다.
- RegisterController : 손님에게 주문 받는 기능을 수행한다.
- PayController : 주문 내역에 대한 결제 기능을 수행한다.

### domain
- Table : 한 테이블에 대한 정보를 담고 있다.
    - OrderList bill : 한 테이블의 주문 내역
    - int number : 테이블의 번호
    - 한 테이블의 총 주문 금액을 알려주는 기능
    - 한 테이블의 치킨 메뉴 개수를 계산하는 기능
    - 한 테이블에 들어온 메뉴와 수량을 orderList에 등록하는 기능
    - 결제가 끝나면 한 테이블의 주문 내역을 초기화하는 기능
- Tables : 모든 테이블의 List를 갖는 일급 콜렉션
    - List<Table> tables
    - 테이블 번호가 존재하는지 매치하는 기능
    - 주문된 메뉴 번호와 일치하는 메뉴를 찾는 기능
    - 주문된 메뉴와 수량을 등록하는 기능
    - 전체 테이블의 치킨 메뉴 개수를 계산하는 기능
    - 지정한 테이블의 결제 총액을 계산하는 기능
    - 지정한 테이블의 주문 내역을 초기화하는 기능
    
- OrderList : 주문 내역을 가진 일급콜렉션이다.
    - List<OrderedMenu> bill
- OrderedMenu : 주문된 메뉴에 대한 정보를 담고 있다.
    - Menu Menu
    - int quantity
    - 수량이 추가되는 기능
    - 수량이 99가 넘는 경우 예외 발생시키는 기능
- Menu : 한 메뉴에 대한 정보를 가지고 있다.
- Menus : 모든 메뉴의 List를 갖는다.
    - List<Menu> menus
    - 메뉴 번호가 존재하는지 매치하는 기능
- Category : 치킨과 음료에 대한 정보를 가진 enum이다.
- paymentWay : 결제 수단(현금, 카드)에 대한 정보를 가지고 있다.
    - int paymentWay
    - 결제 수단으로 1 또는 2만 입력했는지 검증하는 기능
    - 결제 수간이 현금인지 알려주는 기능
- TotalMoneyCalculator : 적용할 수 있는 할인을 적용하여 최종 금액을 계산을 한다.
    - 치킨 카테고리 할인을 적용하여 계산하는 기능
    - 결제 수단 할인을 적용하여 계산하는 기능
    - 모든 할인을 순차적으로 적용해 최종 금액을 반환하는 기능

### view
- InputView
    - 어떤 작업을 할지 입력받는 기능
    - 테이블 번호를 입력받는 기능
    - 메뉴 번호를 입력받는 기능
    - 음식 수량을 입력받는 기능
    - 결제 수단을 입력받는 기능
    - 숫자가 아니면 예외를 발생시키는 기능
    - 수량이 음수면 예외를 발생시키는 기능

- OutputView
    - 메인 화면을 출력하는 기능
    - 테이블 상태 출력하는 기능
    - 메뉴판 출력하는 기능
    - 에러 메세지를 출력하는 기능
    - 주문을 받는 메세지들을 출력하는 기능
    - 주문 내역을 출력하는 기능
    - 결제 방법을 받는 메세지 출력 기능
    - 최종 금액을 출력하는 기능
    - 프로그램 종료 메세지 출력 기능