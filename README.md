## 미션 - 자동차 경주 게임

### 구현 기능 목록

### *<span style = 'color : #FFCD28'>Model</span>*<br/>

#### *<span style = 'color : #A8F552'>Codition</span>*<br/>
**🔆 역할 : 0-9까지의 숫자 중 임의의 숫자를 생성하고 4 이상인 경우, True를 반환한다.**<br/>

- [X] 인터페이스로 구현한다.<br/>

#### *<span style = 'color : #A8F552'>Car</span>*<br/>
**🔆 역할 : 전진할 수 있는 조건에 해당한 경우 전진한다.(아닌 경우에는 이동하지 않는다.)**<br/>

- [X] Car 객체의 필드는 얼마큼 전진했는지에 대한 정보를 갖는다.<br/>

### *<span style = 'color : #FFCD28'>Controller</span>*<br/>

#### *<span style = 'color : #A8F552'>GameController</span>*<br/>
**🔆 역할 : 플레이어로부터 받은 입력을 Service에 전달하고, Service로부터 받은 결값을 View에 전달한다.**<br/>

- [X] 플레이어로부터 자동차 대수를 입력받는다.<br/>
- [X] 플레이어로부터 시도 횟수를 입력받는다.<br/>
- [X] Service로부터 시도 횟수만큼 전체 Car의 경주결과를 받아 View에 전달한다.<br/>
- [X] 올바른 입력을 검증하며, 올바른 입력을 받을 때까지 재입력을 받는다.<br/>

### *<span style = 'color : #FFCD28'>Service</span>*<br/>

#### *<span style = 'color : #A8F552'>GameService</span>*<br/>
**🔆 역할 : 자동차 대수만큼 CarList를 생성, 관리, 제거하고 Car에게 이동할지 안 할지 결정하도록 명령한다.**<br/>

- [X] CarList가 비어있다면 자동차 대수만큼 CarList를 생성한다.<br/>
- [X] CarList에 있는 전체 Car에게 이동할지 안 할지 결정하도록 한다.<br/>
- [X] 이동 결과를 Controller에 전달한다.<br/>
- [X] 시도 횟수만큼 경주를 진행했다면 CarList 경주 결과를 리셋한다.<br/>
