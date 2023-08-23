package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(3);


    @Test
    @DisplayName("다리가 'U','D'로 구성되어 있는지 확인한다.")
    void BridgeComposeByUAndD(){
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    @DisplayName("입력된 길이 만큼 다리가 크기가 생성이 된는지 확인한다.")
    void makeBridgeSize(){
        assertThat(bridge.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("생성된 다리가 Bridge에 저장이 되는지 확인한다.")
    void saveBridge(){
        //given
        Bridge saveBridge = new Bridge(bridge);

        //when
        List<String> savedBridge = saveBridge.getBridge();

        //then
        assertThat(savedBridge).isEqualTo(bridge);
    }

}
