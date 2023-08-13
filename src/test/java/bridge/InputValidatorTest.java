package bridge;

import bridge.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();
    String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("위치 이동 시 U, D 이외 입력이 들어올 경우 예외 발생")
    @Test
    void movingInputException() {
        assertThatThrownBy(() -> inputValidator.validateMoving("K"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("재시작 시 R, Q 이외 입력이 들어올 경우 예외 발생")
    @Test
    void retryInputException() {
        assertThatThrownBy(() -> inputValidator.validateRetry("K"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리 길이 입력 시 숫자 외 문자 입력이 들어올 경우 예외 발생")
    @Test
    void bridgeLengthException() {
        assertThatThrownBy(() -> inputValidator.validateBridgeLength("K"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리 길이기 3~20 이외의 숫자일 경우 예외 발생")
    @Test
    void bridgeLengthRangeException() {
        assertThatThrownBy(() -> inputValidator.validateBridgeLength("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
