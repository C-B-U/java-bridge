package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeWindowMaker bridgeWindowMaker) {
        System.out.println(bridgeWindowMaker);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }

    public void printGameStart() {
        System.out.println(GameProgressMessage.BRIDGE_GAME_START);
    }

    public void printInputBridgeSize() {
        System.out.println(GameProgressMessage.INPUT_BRIDGE_LENGTH);
    }

    public void printInputBridgeStage(){
       String message = String.format(GameProgressMessage.INPUT_BRIDGE_STAGE.toString()
               , GameCommand.UP_STAIR, GameCommand.DOWN_STAIR);
        System.out.println(message);
    }
}
