package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputManager {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeStatus bridgeStatus;

    public InputManager() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeStatus = new BridgeStatus();
    }

    public List<String> makeBridge(){
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.inputBridgeSize(Console.readLine());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void moveBridge(BridgeGame bridgeGame){
        int count = 0;
        while (true){
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String bridgeMoveStep = inputView.inputBridgeMoveStep(Console.readLine());
            boolean isProceed = bridgeGame.move(bridgeMoveStep, count);
            if (!isProceed){
                bridgeStatus.failStair(bridgeMoveStep);
                bridgeStatus.reset();
            }
            bridgeStatus.successStair(bridgeMoveStep);
        }
    }




}
