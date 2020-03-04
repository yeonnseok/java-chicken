# java-chicken
온라인 코드리뷰 스터디  
치킨집 TDD 연습

## 필요 기능

포스기의 기능에는 주문 등록, 결제하기, 종료가 있다.

메뉴는 번호, 종류, 이름, 가격으로 이루어져 있다.

테이블은 고유의 테이블 번호가 있다(현 요구사항에서는 1-8)

테이블은 주문이 들어갔다면 별도로 ₩ 표시를 한다.

주문은 한 메뉴당 최대 99개까지 주문할 수 있다.

결제는 치킨 종류 10개 당 10,000원 할인이 들어간다.
추가로 현금으로 결제시 5%의 중복할인도 가능하다. 

올바르지 않은 입력으로 주문, 결제 실패시 사용자에게 다시 물어보도록 구성한다.

최종 결제금액을 표시한다.

## 세부 구현 과정

### Order

Menu menu  
Integer amount

validate(Integer) → void :  if amount > 99 then throw exception  

addOrder(amount) → void : validate 거쳐서 추가하기. 

### Orders

createBill () → Orders : new ArrayList<Order>

hasOrder() → boolean : size > 0


order(menu, int amount) → void : add on hashmap

reset() → void : new HashMap or clear?

### Table

Table () → Table : Bill을 생성해서 포함시키기 

isOrder() → boolean : bill.hasOrder()

### Tables

Tables (List Table) → Tables : null 처리  

### PaymentCalculator

discount에 관한 List를 만들어서 멤버로 두기

pay(Table) → void : 테이블을 전달받아서 돈 계산 시작하기 

### Discountable    
인터페이스  
discount()가 있음

### DiscountChickenStrategy 
implements Discountable 
치킨에 관한 할인 전략 

### DiscountCardStrategy
implements Discountable
카드에 관한 할인 전략 