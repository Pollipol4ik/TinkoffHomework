package edu;

import edu.task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.task4.CallingInfo.callingInfo;
import static org.assertj.core.api.Assertions.assertThat;

public class CallingInfoTest {

    @Test
    @DisplayName("Тест локации вызова")
    public void callingInfoLastCalledMethod() {
        assertThat(callingInfo()).isEqualTo(new CallingInfo(
            "edu.CallingInfoTest",
            "callingInfoLastCalledMethod"
        ));
    }

}
