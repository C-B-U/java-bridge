package bridge;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

class BridgeTest {


    @Test
    @DisplayName("다리가 'U', 'D' 형태로 랜덤 생성 되었는지 확인한다.")
    void makeBridge(){
        //given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        //when
        List<String> bridge = bridgeMaker.makeBridge(3);

        //then
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
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        //when
        int countStage = bridgeGame.stages();

        //then
        assertThat(countStage).isEqualTo(3);
    }

    @Test
    @DisplayName("재시작/종료 명령어가 R이면 true, Q이면 false를 반환한다.")
    void retryCommandIsR(){
        //given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

        //when
        boolean isRetryTrue = bridgeGame.retry("R");
        boolean isRetryFalse = bridgeGame.retry("Q");

        //then
        assertThat(isRetryTrue).isTrue();
        assertThat(isRetryFalse).isFalse();

    }
}
