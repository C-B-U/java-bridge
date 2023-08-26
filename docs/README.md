## 기능 목록

### input 
- [x] 다리 길이를 입력 받는다.
    - 3~20 사이의 숫자이다. 
- [x] 이동할 칸을 입력 받는다.
   - 위 칸 -> U, 아래 칸 -> D 
- [x] 재시작 여부를 입력 받는다.
   - 재시작 -> R, 종료 -> Q

### inputValidator
- [x] 다리 길이 validate
  - 숫자이다.
  - 3~20사이의 숫자이다.
- [x] 이동할 칸 validate
  - 대문자 영어이다.
  - U or D이다.
- [x] 재시작 validate
  - 대문자 영어이다.
  - R or Q이다.

### output
1. 다리 화면 출력한다.
- [x] 이동한 칸을 건널 수 있다면 -> O 건널 수 없다면 X
- [x] 결과 출력한다.
- [x] 에러 출력한다.
- [x] 진행 메시지 출력한다.

### bridge
1. 다리 길이 만큼 다리를 저장한다.
- [x] List<String> 위 칸 -> U, 아래 칸 -> D
  - 재시작해도 처음에 만든 다리로 재사용한다.

### BridgeMaker
- [x] 다리를 만든다.
     - 랜덤 숫자  1 -> 위 칸, 0 -> 아래 칸

### BridgeMap
- [x] 게임 화면을 만든다.

### BridgeStageRecord
- [x] 게임 진행 결과를 기록한다.

## 상수 처리

### BridgeMapElement
-[x] 게임 화면 요소

### ErrorMessage
-[x] 에러 메시지 

### GameCommand
-[x] 게임 명령어

### GameProgressMessage
-[x] 게임 진행 메시지

### GameResult
-[x] 게임 결정

## 에러 처리
- [x] 에러 발생시 [ERROR] 단어가 포함 되어있어야 한다.
- [x] 그 부분 부터 다시 입력 받는다.

- [x] 다리 길이는 3~20 사이의 숫자이다.
- [x] 이동할 칸 명령어는 'U', 'D' 이다.
- [x] 재시작 여부 명령어는 'R', 'Q' 이다.