package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static prep.BinarySearch.*;

import java.util.stream.Stream;

class BinarySearchTests {

    private static Stream<Arguments> provideInputForNumberOfSuitablePlaces() {
        return Stream.of(
            Arguments.of(new int[]{-2, 1, 0}, 8, 3),
            Arguments.of(new int[]{2, 0, 3, -4}, 22, 5),
            Arguments.of(new int[]{-3, 2, 2}, 8, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputForNumberOfSuitablePlaces") 
    void testNumberOfSuitablePlaces(int[] center, int d, int expectedOutput) {
        assertEquals(expectedOutput, numberOfSuitablePlaces(center, d));
    }
}