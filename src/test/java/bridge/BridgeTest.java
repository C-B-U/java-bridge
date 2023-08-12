package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

class BridgeTest {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("다리가 'U', 'D' 형태로 랜덤 생성 되었는지 확인한다.")
    void makeBridge(){
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).contains("U", "D");
    }

    @Test
    @DisplayName("이동할 수 있는 칸을 입력했을 때 True를 반환한다.")
    void moveBridge(){
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        //when
        boolean isMove = bridgeGame.move("D", 1);

        //then
        assertThat(isMove).isTrue();
    }

    @Test
    @DisplayName("생성된 Bridge가 BridgeGame에 저장이 되는지 확인한다.")
    void saveBridgeInBridgeGame(){
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));

        List<String> saveBridge = bridgeGame.getBridge();

        assertThat(saveBridge).contains("U", "D");
    }
}
