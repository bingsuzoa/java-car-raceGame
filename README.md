## 미션 - 자동차 경주 게임

### 구현 기능 목록

### *<span style = 'color : #FFCD28'>Condition</span>*<br/>

#### *<span style = 'color : #A8F552'>RandomNumberCondition</span>*<br/>

**🔆 역할 : 1 - 9까지의 랜덤 숫자를 생성한다.**<br/>

- [X] Condition은 인터페이스로 생성해 추후 숫자 생성 방식이 바뀔 경우를 고려한다.<br/>

### *<span style = 'color : #FFCD28'>Car</span>*<br/>

#### *<span style = 'color : #A8F552'>Car</span>*<br/>

**🔆 역할 : 매 라운드 경기가 시작될 때마다 랜덤 값을 얻고, 4 이상인 경우 앞으로 전진한다.**<br/>

- [X] Car 객체의 필드는 Car의 이름과 얼마큼 전진했는지에 대한 정보를 갖는다.<br/>
- [X] Car가 전진한 만큼 "-" 형태로 출력할 수 있다.<br/>

#### *<span style = 'color : #A8F552'>Cars</span>*<br/>

**🔆 역할 : Car들의 정보를 관리한다.**<br/>

- [X] 라운드 경기가 시작하면 Car들에게 경주를 시작하라고 알린다.<br/>
- [X] 제일 멀리 이동한 Car들(우승자)의 정보를 갖는다.<br/>
- [X] 라운드 종료 시 Cars 정보를 초기화한다.<br/>

#### *<span style = 'color : #A8F552'>CarName</span>*<br/>

**🔆 역할 : 올바른 자동차 입력인지 확인한다.**<br/>

- [X] 자동차 입력이 올바르지 않는 경우 예외를 발생시킨다.<br/>

### *<span style = 'color : #FFCD28'>GameController</span>*<br/>

**🔆 역할 : 플레이어로부터 받은 입력을 Service에 전달하고, Service로부터 받은 결과값을 View에 전달한다.**<br/>

- [X] 플레이어로부터 경주를 할 자동차 이름을 입력받는다.<br/>
- [X] 플레이어로부터 시도 횟수를 입력받는다.<br/>
- [X] Service로부터 시도 횟수만큼 전체 Car의 경주결과를 받아 View에 전달한다.<br/>
- [X] 시도 횟수만큼 경주를 완료하면 Service로부터 Winners를 받아 View에 전달한다.<br/>

### *<span style = 'color : #FFCD28'>GameService</span>*<br/>

**🔆 역할 : Controller로부터 CarNames와 시도 횟수를 전달받아 게임 로직을 수행한다.**<br/>

- [X] Controller로부터 CarNames를 전달받아 Cars를 생성한다.<br/>
- [X] 이동 결과를 Controller에 전달한다.<br/>
- [X] 우승자 리스트를 Controller에 전달한다.<br/>
