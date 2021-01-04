package example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class KitchenTest {

    @Test
    void name() {
        new Kitchen(
                Collections::emptyList,
                participations -> 0
        );
    }
}