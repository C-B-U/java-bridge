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
- BridgeGame
  - move()
  - retry()
  - getGameResultMap() result map 문자열 반환

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

- InputValidator
  - validateBridgeSizeInput() 다리 길이 입력값 검증

- OutputView
  - printGameStart()
  - printBridgeSizeRequest()
  - printMap()
  - printResult()
  - printMovingRequest() 이동할 칸 입력 요청 출력

- ComponentFactory
  - bridgeGameManager() BridgeGameManager 생성

- Bridge
  - create() Bridge 객체 생성 팩토리 메서드

- GameResult
  - addResultStatus() 결과 상태 추가
  - getFirstBridgeElement() 다리의 첫번째 요소 조회
  - getBridgeLeftSize() 다리 잔여 사이즈 조회

- MoveResultMapper
  - mapToMoveResult() MoveResult로 매핑

- TryCount
  - increment() 시도 횟수 증가
  - toString() 시도 횟수 문자열로 반환

## 열거형 목록
- GameMessage
  - 게임 메시지

- BridgeType
  - 다리의 윗 칸과 아래칸

- ErrorMessage
  - 에러 메시지

- MoveResult
  - 이동 결과

- GameResultStatus
  - 결과 상태

- RetryCommand
  - 재시도 입력값
