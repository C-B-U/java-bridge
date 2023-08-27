package bridge.domain;

import bridge.Keyword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeMakerTest {
    @DisplayName("무작위 값 1은 U를 의미한다.")
    @Test
    void makeUpPosition() {
        int input = 1;
        String expect = "U";
        assertThat(Keyword.convert(input)).isEqualTo(expect);
    }

    @DisplayName("무작위 값 0은 D를 의미한다.")
    @Test
    void makeDownPosition() {
        int input = 0;
        String expect = "D";
        assertThat(Keyword.convert(input)).isEqualTo(expect);
    }
}