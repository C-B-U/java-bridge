package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LocationConverterTest {

    @DisplayName("0을 입력할 경우 D로 변환한다.")
    @Test
    void convertToD() {
        int bridge = 0;
        String convertContent = LocationConverter.convert(bridge);
        assertThat(convertContent).isEqualTo("D");
    }

    @DisplayName("1을 입력할 경우 U로 변환한다.")
    @Test
    void convertToU() {
        int bridge = 1;
        String convertContent = LocationConverter.convert(bridge);
        assertThat(convertContent).isEqualTo("U");
    }
}
