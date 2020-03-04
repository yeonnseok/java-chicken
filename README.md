# java-chicken
온라인 코드리뷰 스터디  
치킨집 TDD 연습

### 요구사항

---
- 기능은 주문등록, 결제하기, 프로그램 종료 세 가지
- 주문이 가능한 메뉴 번호는 기존에 등록 되어있는 메뉴들이다
- 한 메뉴의 최대 수량은 99개이다
- 주문이 이루어진 테이블은 결제가 이루어지기 전까지 별도의 표시를 한다
- 치킨 종료의 메뉴는 10개당 10,000원씩 할인한다
- 현금 결제 시 최종 할인 금액에서 5%를 더 할인한다
- 주문 혹은 결제가 불가능한 경우 그 이유를 보여주고 다시 주문 혹은 결제가 되도록 한다
- 최종 결제 금액을 출력한다

### 프로그램 설계

---
- FunctionType
    - 사용자가 선택하는 주문, 등록, 종료의 enum
    - 사용자가 입력한 기능이 유효한 기능인지 검사
    
- Menus
    - MenuRepository 를 이용해 만든 일급 콜렉션
    - 사용자가 입력한 메뉴 번호가 있는지 검사

- Tables
    - TableRepository 를 이용해 만든 일급 콜렉션
    - 사용자가 입력한 테이블 번호가 있는지 검사

- PaymentType
    - 결제수단 enum
    - 사용자가 입력한 결제 수단이 유효한지 검사

- Order
    - 테이블이 갖고 있는 주문 내역
    - 메뉴와 수량을 갖는다

- Quantity
    - 수량 원시값을 포장하는 객체
    - 0 이상 99개 이하의 값만이 유효한 값이다
    
- Calculator
    - 최종 결제할 금액을 계산하는 클래스
    - 선택한 테이블의 Order 를 이용하여 계산한다
    - 계산하는 금액은 int 로 출력한다
    
    
