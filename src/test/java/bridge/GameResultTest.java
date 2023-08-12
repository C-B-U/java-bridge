package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    GameResult gameResult = new GameResult();
    BridgeStatus bridgeStatus = new BridgeStatus();

    @Test
    @DisplayName("게임 시도 횟수가 하나씩 증가하는지 확인한다.")
    void upAttemptCount(){
        // given
        gameResult.upAttemptCount();

        //when
        int attemptCount = gameResult.getAttemptCount();

        //then
        assertThat(attemptCount).isEqualTo(1);
    }

    @Test
    @DisplayName("윗 칸을 누르고 실패했을 때 게임 화면이 만들어지는지 확인한다.")
    void upStairFail(){
        //given
        bridgeStatus.failStair("U");

        //when
        String upStairSuccess = bridgeStatus.toString();

        //then
        assertThat(upStairSuccess).contains("[ X ]\n[   ]\n");

    }

    @Test
    @DisplayName("아랫 칸을 누르고 실패했을 때 게임 화면이 만들어지는지 확인한다.")
    void downStairFail(){
        //given
        bridgeStatus.failStair("D");

        //when
        String upStairSuccess = bridgeStatus.toString();

        //then
        assertThat(upStairSuccess).contains("[   ]\n[ X ]\n");

    }

    @Test
    @DisplayName("윗 칸을 누르고 성공했을 때 게임 화면이 만들어지는지 확인한다.")
    void upStairSuccess(){
        //given
        bridgeStatus.successStair("U");

        //when
        String upStairSuccess = bridgeStatus.toString();

        //then
        assertThat(upStairSuccess).contains("[ O ]\n[   ]\n");

    }

    @Test
    @DisplayName("아랫 칸을 누르고 성공했을 때 게임 화면이 만들어지는지 확인한다.")
    void downStairSuccess(){
        //given
        bridgeStatus.successStair("D");

        //when
        String upStairSuccess = bridgeStatus.toString();

        //then
        assertThat(upStairSuccess).contains("[   ]\n[ O ]\n");

    }

    @Test
    @DisplayName("게임 클리어 실패시 '성공'에서 '실패'로 변하는지 확인한다.")
    void gameClearFail(){
        assertThat(gameResult.getGameClear()).isEqualTo("성공");

        gameResult.gameClearFail();

        assertThat(gameResult.getGameClear()).isEqualTo("실패");
    }

    @Test
    @DisplayName("게임 재시작 시 다리는 초기화된다.")
    void gameReset(){
        gameResult.restartGameSet();

        BridgeStatus bridgeStatus = gameResult.getBridgeStatus();

        assertThat(bridgeStatus.toString()).isEqualTo("[  ]\n[  ]\n");
    }



}
