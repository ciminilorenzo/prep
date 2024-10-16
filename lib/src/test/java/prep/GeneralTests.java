package prep;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static prep.General.*;

class GeneralTests {

    private static Stream<Arguments> provideInputForGoogleScoreTokenTest() {
        return Stream.of(
            Arguments.of(new int[]{3, 4, 5, 2, 3},  "TEETT", 9),
            Arguments.of(new int[]{3, 2, 1, 2, 2},  "ETTTE", 7),
            Arguments.of(new int[]{2, 2, 2, 2},  "TTTT", 11)
        );
    }
    
    @Test 
    void testsMaxCaughtFishFirstCase() {
        int[] fishing = new int[]{1, 2, 3};
        int[] baits = new int[]{1};
        int output = 2;
        
        assertEquals(output, maximumFishCaught(fishing, baits));
    }

    @ParameterizedTest
    @MethodSource("provideInputForGoogleScoreTokenTest")
    void testGoogleScoreToken(int[] points, String tokens, int expected) {
        assertEquals(expected, googleScoreToken(points, tokens));
    }
}
