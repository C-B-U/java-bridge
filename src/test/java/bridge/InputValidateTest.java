package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {

    @Test
    @DisplayName("다리의 길이가 3~20사이의 숫자가 아니면 에러가 발생한다.")
    void validateBridgeSize(){
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.inputBridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
