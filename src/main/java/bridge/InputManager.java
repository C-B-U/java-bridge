package bridge;

public class InputManager {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public InputManager(InputView inputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void makeBridge(){
        bridgeMaker.makeBridge(inputView.inputBridgeSize());
    }



}
