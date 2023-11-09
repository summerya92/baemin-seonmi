주제 : 배달의 민족

시나리오 
1. 고객이 메뉴를 선택하여 주문한다.
2. 주문이 완료되면 주문히스토리에서 결제를 진행한다.
3. 결제가 완료되면 주문의 상태를 업데이트한다.
4. 요리가 완료되면 고객 지역 인근 라이더들에게 배송 건 조회가 가능하다.
5. 라이더가 해당 요리를 Pick한 후 배달을 시작한다.
6. 배달이 끝나면 모든 거래가 완료된다.
   
1. EventStorming Model : Design Level
https://github.com/summerya92/baemin-seonmi/issues/1#issue-1986131867

2. Saga (Pub / Sub) 구현
결제가 완료되면 주문 상태를 "PAYMENT SUCCESS"로 업데이트한다.
https://github.com/summerya92/baemin-seonmi/issues/2#issue-1986132346
https://github.com/summerya92/baemin-seonmi/issues/3#issue-1986132841

3. Saga (Pub / Sub) 및 Compensation / Correlation 구현
주문이 취소되면 결제가 취소된다.
Correlation 키인 OrderID를 사용하여 해당 건의 결제취소 로직을 실행한다.
https://github.com/summerya92/baemin-seonmi/issues/4#issue-1986133275
https://github.com/summerya92/baemin-seonmi/issues/5#issue-1986133669

4. CQRS (실습과 동일하게 Design Level에서 구성)
