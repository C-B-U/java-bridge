package bridge.service;

import bridge.BridgeMaker;
import bridge.constant.BridgeType;
import bridge.constant.ResultStatus;
import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.domain.TryCount;
import bridge.storage.BridgeStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BridgeGame의")
class BridgeGameTest {
    private final BridgeStorage bridgeStorage = new BridgeStorage();
    private final BridgeGame bridgeGame = new BridgeGame(bridgeStorage, new BridgeMaker(() -> 1));

    @Nested
    @DisplayName("유저의 이동 시도 중")
    class Move {
        @Test
        @DisplayName("유저의 이동 시도가 수행되는가")
        void moveD() {
            //given
            bridgeGame.makeBridge(3);

            //when
            final ResultStatus resultStatus = bridgeGame.move(BridgeType.D);

            //then
            assertThat(resultStatus).isEqualTo(ResultStatus.X);
        }

        @Test
        @DisplayName("유저의 이동 시도가 수행되는가")
        void moveU() {
            //given
            bridgeGame.makeBridge(3);

            //when
            final ResultStatus resultStatus = bridgeGame.move(BridgeType.U);

            //then
            assertThat(resultStatus).isEqualTo(ResultStatus.CONTINUE);
        }

        @Test
        @DisplayName("유저의 이동 시도가 수행되는가")
        void moveUUU() {
            //given
            bridgeGame.makeBridge(3);

            //when
            final ResultStatus resultStatus1 = bridgeGame.move(BridgeType.U);
            final ResultStatus resultStatus2 = bridgeGame.move(BridgeType.U);
            final ResultStatus resultStatus3 = bridgeGame.move(BridgeType.U);

            //then
            assertThat(resultStatus3).isEqualTo(ResultStatus.O);
        }
    }

    @Test
    @DisplayName("재시도 로직이 수행되는가")
    void retry() {
        //given
        bridgeGame.makeBridge(3);
        bridgeGame.move(BridgeType.U);

        //when
        bridgeGame.retry();

        //then
        final GameResult gameResult = bridgeGame.findGameResult();
        final TryCount tryCount = gameResult.findTryCount();
        assertThat(tryCount).hasToString(Integer.toString(2));
    }

    @Test
    @DisplayName("다리 생성이 수행되는가")
    void makeBridge() {
        //given

        //when
        bridgeGame.makeBridge(3);

        //then
        final Bridge bridge = bridgeStorage.findBridge();
        final BridgeType bt1 = bridge.getCurrentElement();
        final BridgeType bt2 = bridge.getCurrentElement();
        final BridgeType bt3 = bridge.getCurrentElement();
        assertThat(List.of(bt1, bt2, bt3)).containsExactly(BridgeType.U, BridgeType.U, BridgeType.U);
    }

    @Test
    @DisplayName("결과 조회가 수행되는가")
    void findGameResult() {
        //given
        final GameResult expected = new GameResult();
        bridgeStorage.saveGameResult(expected);

        //when
        final GameResult gameResult = bridgeGame.findGameResult();

        //then
        assertThat(gameResult).isEqualTo(expected);
    }
}
