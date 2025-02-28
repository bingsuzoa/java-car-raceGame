## 미션 - 자동차 경주 게임

### 구현 기능 목록

### *<span style = 'color : #FFCD28'>Model</span>*<br/>

#### *<span style = 'color : #A8F552'>Computer</span>*<br/>
**🔆 역할 : 0-9까지의 숫자 중 임의의 숫자를 생성한다.**<br/>

- [ ] 인터페이스로 구현한다.<br/>

#### *<span style = 'color : #A8F552'>Car</span>*<br/>
**🔆 역할 : 입력받은 숫자가 4 이상인 경우 한칸 전진한다.**<br/>

- [ ] Car 객체의 필드는 얼만큼 전진했는지에 대한 정보를 갖는다.<br/>


#### *<span style = 'color : #A8F552'>Referee</span>*<br/>
**🔆 역할 : Computer로부터 얻은 랜덤 숫자를 Car에 제공한다.**<br/>

- [ ] Referee 객체 생성 시 외부로부터 Computer를 주입받는다.<br/>
- [ ] 전체 Car에게 Computer로부터 얻은 랜덤 숫자를 제공한다.<br/>

### *<span style = 'color : #FFCD28'>Controller</span>*<br/>

#### *<span style = 'color : #A8F552'>GameController</span>*<br/>
**🔆 역할 : 플레이어로부터 받은 입력을 Service에 전달하고, Service로부터 받은 결과값을 View에 전달한다.**<br/>

- [ ] 플레이어로부터 자동차 대수를 입력받는다.<br/>
- [ ] 플레이어로부터 시도 횟수를 입력받는다.<br/>
- [ ] Service로부터 시도 횟수만큼 전체 Car의 경주결과를 받아 View에 전달한다.<br/>
- [ ] 올바른 입력을 검증하며, 올바른 입력을 받을 때까지 재입력을 받는다.<br/>

### *<span style = 'color : #FFCD28'>Service</span>*<br/>

#### *<span style = 'color : #A8F552'>GameService</span>*<br/>
**🔆 역할 : 자동차 대수만큼 CarList를 생성, 관리, 제거하고 Referee에게 Car 경주결과를 업데이트하도록 한다.**<br/>

- [ ] CarList가 비어있다면 자동차 대수만큼 CarList를 생성하고 Referee에게 제공한다.<br/>
- [ ] Referee로부터 받은 CarList 경주 결과를 업데이트한다.<br/>
- [ ] 시도횟수만큼 경주를 진행했다면 CarList 경주 결과를 리셋한다.<br/>
