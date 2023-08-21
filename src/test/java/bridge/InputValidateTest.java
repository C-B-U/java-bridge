package bridge;

import bridge.io.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {

    InputValidator inputValidator = new InputValidator();


    @Test
    @DisplayName("다리의 길이가 3~20사이의 숫자가 아니면 에러가 발생한다.")
    void validateBridgeSize(){
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 길이가 숫자가 아니면 에러가 발생한다.")
    void validateBridgeIsNumber(){
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("ㅁ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동할 칸이 'U' 또는 'D'가 아니면 에러가 발생한다.")
    void validateBridgeMoveStep(){
        assertThatThrownBy(() -> inputValidator.validateBridgeMoveStep("Z"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임을 다시 시도 입력이 'R', 'Q'가 아니면 에러가 발생한다.")
    void validateBridgeRestartCommand(){
        assertThatThrownBy(() -> inputValidator.validateBridgeStartCommand("Z"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동할 칸이 대문자 영어가 아니면 에러가 발생한다.")
    void validateBridgeMoveStepIsUpperEnglish(){
        assertThatThrownBy(() -> inputValidator.validateBridgeMoveStep("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임을 다시 시도 입력이 대문자 영어가 아니면 에러가 발생한다.")
    void validateBridgeRestartCommandIsUpperEnglish(){
        assertThatThrownBy(() -> inputValidator.validateBridgeStartCommand("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
