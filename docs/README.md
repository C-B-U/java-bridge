## 기능 목록
- [ ] 게임 시작
  - [ ] 게임 시작 메시지 출력
- [ ] 다리 길이 설정
  - [ ] 다리 길이 입력요청 메시지 출력
  - [ ] 다리 길이 입력
    - [ ] 입력값 숫자 여부 검증
    - [ ] 입력 숫자 3 이상 20 이하 숫자인지 검증
- [ ] 다리 생성
  - [ ] 길이에 따른 랜덤 다리 생성
- [ ] 플레이어 이동
  - [ ] 이동할 칸 입력
    - [ ] 입력값이 U 혹은 D 인지 검증
  - [ ] 이동 가능한 칸인 경우 O 표시
  - [ ] 이동 불가능한 칸인 경우 X 표시
  - [ ] 현황 출력
- [ ] 게임 성공 여부 판단
  - [ ] 이동 불가능한 칸으로 이동한 경우 실패
  - [ ] 모두 이동 가능한 칸으로만 이동한 경우 성공
    - [ ] 성공 메시지 출력
    - [ ] 총 시도 횟수 출력
- [ ] 실패시 게임 재시작 여부 판단
  - [ ] 게임 재시작 여부 입력
    - [ ] 입력값 R 혹은 Q 인지 검증
- [ ] 게임 재시작
  - [ ] 게임 시도 횟수 증가
- [ ] 게임 종료

## 구현 클래스 목록
- BridgeGame
  - move()
  - retry()

- BridgeGameManager
  - playBridgeGame() 게임 실행

- BridgeMaker
  - makeBridge()

- BridgeNumberGenerator
  - generate()

- BridgeRandomNumberGenerator
  - generate()

- InputView
  - readBridgeSize()
  - readMoving()
  - readGameCommand()

- OutputView
  - printGameStart()
  - printBridgeLengthRequest()
  - printMap()
  - printResult()

- ComponentFactory
  - bridgeGameManager() BridgeGameManager 생성

## 열거형 목록
- BridgeGameMessage
  - 게임 메시지
