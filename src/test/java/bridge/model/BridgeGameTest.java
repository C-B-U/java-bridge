package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    Bridge bridge;
    GameStatus gameStatus;
    AnswerTable answerTable;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUpGame() {
        BridgeNumberGenerator numberGenerator = new BridgeGameTest.TestNumberGenerator(newArrayList(1, 0, 0));
        bridge.BridgeMaker bridgeMaker = new bridge.BridgeMaker(numberGenerator);

        bridge = new Bridge(bridgeMaker.makeBridge(3));
        gameStatus = new GameStatus();
        answerTable = new AnswerTable();
        bridgeGame = new BridgeGame(bridge, gameStatus, answerTable);
    }

    @DisplayName("게임 진행 시 사용자가 입력한 내용과 다리의 내용이 일치하는지 확인")
    @Test
    void comparisonMoving() {
        String moving = "U";

        boolean movingResult = bridgeGame.move(moving);

        assertThat(movingResult).isTrue();
    }

    @DisplayName("정답 계산 이후 사용자 위치 움직였는지 확인")
    @Test
    void comparisonPosition() {
        String moving = "U";
        bridgeGame.move(moving);

        assertThat(gameStatus.getPosition()).isEqualTo(1);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
