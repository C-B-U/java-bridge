package bridge.domain;

import bridge.constant.BridgeType;
import bridge.constant.ResultStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bridge의")
class BridgeTest {

    @Nested
    @DisplayName("사이즈 검증 중")
    class Validate {
        @Test
        @DisplayName("3 이하의 size의 리스트가 들어올시 예외가 던져지는가")
        void validateSizeLessThan3() {
            assertThatThrownBy(() -> new Bridge(List.of("U", "U")))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3 이하의 size의 리스트가 들어올시 예외가 던져지는가")
        void validateSizeGreaterThan20() {
            assertThatThrownBy(() -> new Bridge(
                    List.of("U", "U", "U", "U", "U",
                            "U", "U", "U", "U", "U",
                            "U", "U", "U", "U", "U",
                            "U", "U", "U", "U", "U",
                            "U")))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("현재 원소 조회 중")
    class GetCurrentElement {
        @Test
        @DisplayName("횟수 내 조회가 수행되는가")
        void getCurrentElement() {
            //given
            final Bridge bridge = new Bridge(List.of("U", "D", "U"));

            //when
            final BridgeType U1 = bridge.getCurrentElement();
            final BridgeType D = bridge.getCurrentElement();
            final BridgeType U2 = bridge.getCurrentElement();

            //then
            assertThat(List.of(U1, D, U2)).containsExactly(BridgeType.U, BridgeType.D, BridgeType.U);
        }

        @Test
        @DisplayName("현재 원소 조회 횟수 초과시 예외가 던져지는가")
        void getCurrentElementException() {
            //given
            final Bridge bridge = new Bridge(List.of("U", "D", "U"));

            final BridgeType U1 = bridge.getCurrentElement();
            final BridgeType D = bridge.getCurrentElement();
            final BridgeType U2 = bridge.getCurrentElement();

            //when
            //then
            assertThatThrownBy(bridge::getCurrentElement)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("입력값 비교 중")
    class CompareToInput {
        @Test
        @DisplayName("정답과 다른 입력값 비교가 수행되는가")
        void compareToInput1() {
            //given
            final Bridge bridge = new Bridge(List.of("U", "D", "U"));

            //when
            final ResultStatus resultStatus = bridge.compareToInput(BridgeType.U, BridgeType.D);

            //then
            assertThat(resultStatus).isEqualTo(ResultStatus.X);
        }

        @Test
        @DisplayName("정답과 동일한 입력값 비교가 수행되는가")
        void compareToInput2() {
            //given
            final Bridge bridge = new Bridge(List.of("U", "D", "U"));

            //when
            final ResultStatus resultStatus = bridge.compareToInput(BridgeType.U, BridgeType.U);

            //then
            assertThat(resultStatus).isEqualTo(ResultStatus.CONTINUE);
        }

        @Test
        @DisplayName("정답과 동일한 입력값 비교가 수행되는가")
        void compareToInput3() {
            //given
            final Bridge bridge = new Bridge(List.of("U", "D", "U"));

            //when
            final ResultStatus resultStatus1 = bridge.compareToInput(BridgeType.U, BridgeType.U);
            final ResultStatus resultStatus2 = bridge.compareToInput(BridgeType.U, BridgeType.U);
            final ResultStatus resultStatus3 = bridge.compareToInput(BridgeType.D, BridgeType.U);

            //then
            assertThat(resultStatus3).isEqualTo(ResultStatus.X);
        }
    }

    @Test
    @DisplayName("Bridge의")
    void clearIndex() {
        //given
        final Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.getCurrentElement();

        //when
        bridge.clearIndex();

        //then
        final BridgeType U = bridge.getCurrentElement();
        assertThat(U).isEqualTo(BridgeType.U);
    }
}
