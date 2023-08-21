# 기능 목록

## BridgeGameController
 - [x] 게임 시작 메서드(gameStart)

## InputManager
- [x] bridge 길이 반환(makeBridge)
- [x] 게임 성공/실패 여부 반환(isClearMoveBridge)
- [x] 게임 재시작/종료 여부 반환(isRetryGame)

## InputView
- [x] 길이 입력 에러 발생 시 이 부분에서 다시 시작(readBridgeSize)
- [x] 이동할 칸 입력 에러 발생 시 이 부분에서 다시 시작(readMoving)
- [x] 게임 재시도 여부 입력 에러 발생 시 이 부분에서 다시 시작(readGameCommand)
- [x] bridge 길이 입력(inputBridgeSize)
- [x] 사용자가 이동할 칸 입력(inputBridgeMoveStep)
- [x] 사용자가 게임을 재시도 여부 입력(inputRetryCommand)

## InputValidator
- [x] bridge 길이 validate(validateBridgeSize)
- [x] bridge 이동 명령어 validate(validateBridgeMoveStep)
- [x] bridge 재시작 명령어 validate(validateBridgeStartCommand)
- [x] bridge 길이 숫자 validate(validateInputNumber)
- [x] 명령어 대문자 영어 validate(validateInputUpperEnglish)

## BridgeGame
- [x] 칸 이동 성공/실패 반환(move)
- [x] bridge 재시도 여부 반환(retry)
- [x] bridge 길이(단계) 반환(stages)

## BridgeMaker
- [x] 생성된 bridge 반환(makeBridge)

## BridgeStatus
- [x] bridge 성공 시 게임화면 추가(successStair)
- [x] bridge 실패 시 게임 화면 추가(failStair)
- [x] bridge 중간 괄호 추가(inputDivision)
- [x] bridge 게임 화면 초기세팅(init)
- [x] bridge 게임 화면 초기화(reset)

## GameResultManager
- [x] bridge 실패 시 게임화면 출력(printFailBridge)
- [x] bridge 성공 시 게임화면 출력(printSuccessBridge)
- [x] bridge 게임 횟수 증가(upAttemptCount)
- [x] bridge 최종 게임 결과 출력(printGameResult)
- [x] bridge 게임 실패 여부(gameClearFail)

## OutputView
- [x] 진행 상황 게임 화면 출력(printMap)
- [x] 최종 게임 결과 출력(printResult)

## 열거형 목록
- [x] 게임 화면 요소(BridgeWindow)
- [x] 에러 메시지(ErrorMessage)
- [x] 게임 명령어(GameCommand)
- [x] 게임 진행 명령어(GameProgressMessage)