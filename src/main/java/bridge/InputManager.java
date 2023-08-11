package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputManager {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public InputManager(InputView inputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public List<String> makeBridge(){
        int bridgeSize = inputView.inputBridgeSize(Console.readLine());
        return bridgeMaker.makeBridge(bridgeSize);
    }



}
