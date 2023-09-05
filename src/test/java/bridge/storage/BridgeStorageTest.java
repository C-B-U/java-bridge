package bridge.storage;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BridgeStorage의")
class BridgeStorageTest {
    private final BridgeStorage bridgeStorage = new BridgeStorage();

    @Test
    @DisplayName("Bridge 저장이 수행되는가")
    void saveBridge() {
        //given
        final Bridge bridge = new Bridge(List.of("D", "U", "D"));

        //when
        bridgeStorage.saveBridge(bridge);

        //then
        final Bridge expected = bridgeStorage.findBridge();
        assertThat(bridge).isEqualTo(expected);
    }

    @Test
    @DisplayName("Bridge 조회가 수행되는가")
    void findBridge() {
        //given
        final Bridge expected = new Bridge(List.of("D", "U", "D"));
        bridgeStorage.saveBridge(expected);

        //when
        final Bridge bridge = bridgeStorage.findBridge();

        //then
        assertThat(bridge).isEqualTo(expected);
    }

    @Test
    @DisplayName("GameResult 저장이 수행되는가")
    void saveGameResult() {
        //given
        final GameResult gameResult = new GameResult();

        //when
        bridgeStorage.saveGameResult(gameResult);

        //then
        final GameResult expected = bridgeStorage.findGameResult();
        assertThat(gameResult).isEqualTo(expected);
    }

    @Test
    @DisplayName("GameResult 조회가 수행되는가")
    void findGameResult() {
        //given
        final GameResult expected = new GameResult();
        bridgeStorage.saveGameResult(expected);

        //when
        final GameResult gameResult = bridgeStorage.findGameResult();

        //then
        assertThat(gameResult).isEqualTo(expected);
    }
}
