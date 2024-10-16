package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static prep.Backtracking.*;

import java.util.stream.Stream;

class BacktrackingTests {

    private static Stream<Arguments> provideInputForGoogleCountCodeWithSum() {
        return Stream.of(
            Arguments.of(4, 35),
            Arguments.of(35, 4),
            Arguments.of(10, 2)
        );
    }
    
    @Test 
    void testsMaxHitWallsWorks() {
        float[] walls = new float[]{-1.5f, 0.5f, 1.5f, 5.5f};
        int[] thickness = new int[]{2, 4, 8, 3};
        int maxEnergy = 3;
        int output = 1;

        assertEquals(output, maxWallHits(walls, thickness, maxEnergy));
    }

    @ParameterizedTest
    @MethodSource("provideInputForGoogleCountCodeWithSum")
    void testGoogleCountCodeWithSum(int expected, int s) {
        assertEquals(expected, googleCountCodeWithSum(s));
    }

}