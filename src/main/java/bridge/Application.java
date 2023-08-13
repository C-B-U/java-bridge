package bridge;

public class Application {

    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        componentFactory.bridgeGameManager().playBridgeGame();
    }
}
