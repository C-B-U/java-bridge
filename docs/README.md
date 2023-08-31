## 기능 목록
- [x] 게임 시작
    - [x] 게임 시작 메시지 출력
- [x] 다리 길이 설정
    - [x] 다리 길이 입력요청 메시지 출력
    - [x] 다리 길이 입력
        - [x] 입력값 숫자 여부 검증
        - [x] 입력 숫자 3 이상 20 이하 숫자인지 검증
- [x] 다리 생성
    - [x] 길이에 따른 랜덤 다리 생성
- [x] 플레이어 이동
    - [x] 이동할 칸 입력
        - [x] 입력값이 U 혹은 D 인지 검증
    - [x] 이동 가능한 칸인 경우 O 표시
    - [x] 이동 불가능한 칸인 경우 X 표시
    - [x] 현황 출력
- [x] 게임 성공 여부 판단
    - [x] 이동 불가능한 칸으로 이동한 경우 실패
    - [x] 모두 이동 가능한 칸으로만 이동한 경우 성공
        - [x] 성공 메시지 출력
        - [x] 총 시도 횟수 출력
- [x] 실패시 게임 재시작 여부 판단
    - [x] 게임 재시작 여부 입력
        - [x] 입력값 R 혹은 Q 인지 검증
- [x] 게임 재시작
    - [x] 게임 시도 횟수 증가
- [x] 게임 종료

## 구현 클래스 목록
- ComponentFactory
    - bridgeGameManager()

- InputProvider
  - bridgeSize()
  - moveCommand()
  - retryCommand()

- InputValidator
  - validateBridgeSize()
  - validateMoving()
  - validateRetryCommand()

- InputView
  - readBridgeSize()
  - readMoving()
  - readGameCommand()

- OutputView
  - printMap()
  - printResult()
  - printGameStart()
  - printBridgeSizeRequest()
  - printMovingRequest()
  - printRetryRequest()

- BridgeGameManager
  - playGame()

- Application
  - main()

- BridgeGame
  - move()
  - retry()
  - makeBridge()
  - findGameResult()

- BridgeMaker
  - makeBridge()

- BridgeRandomNumberGenerator
  - generate()

- Bridge
  - getCurrentElement()
  - compareToInput()
  - clearIndex()

- GameResult
  - addResultStatus()
  - toString()
  - clearAndAddCount()
  - findTryCount()

- TryCount
  - nextCount()
  - toString()

- BridgeStorage
  - saveBridge()
  - findBridge()
  - saveGameResult()
  - findGameResult()

## 구현 열거형 목록
- GameMessage
- RetryCommand
- ErrorMessage
- MoveCommand
- BridgeSize
- BridgeType
