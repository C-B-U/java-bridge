package bridge;

import bridge.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("다리 길이가 숫자가 아니면 에러가 발생한다.")
    void validateBridgeIsNumber(){
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("ㅁ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 길이가 3~20사이가 아니면 에러가 발생한다.")
    void validateBridgeLength(){
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동할 칸은 대문자 영어가 아니면 에러가 발생한다.")
    void validateBridgeStageUpperEnglish(){
        assertThatThrownBy(() -> inputValidator.validateBridgeStage("u"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동할 칸은 'U' 혹은 'D'가 아니면 에러가 발생한다.")
    void validateBridgeStage(){
        assertThatThrownBy(() -> inputValidator.validateBridgeStage("T"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시도 여부 명령어가 대문자 영어가 아니면 에러가 발생한다.")
    void validateBridgeRetryUpperEnglish(){
        assertThatThrownBy(() -> inputValidator.validateBridgeRetry("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시도 여부 명령어가 'R' 혹은 'Q'가 아니면 에러가 발생한다.")
    void validateBridgeRetry(){
        assertThatThrownBy(() -> inputValidator.validateBridgeRetry("T"))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
