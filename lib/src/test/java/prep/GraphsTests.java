package prep;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static prep.Graphs.friendRecommendationSystem;

public class GraphsTests {

    private static Stream<Arguments> provideInputForRecommendationSystem() {
        return Stream.of(
            Arguments.of(new int[][]{
                new int[]{0, 1}, 
                new int[]{0, 2}, 
                new int[]{1, 3}, 
                new int[]{2, 3}, 
                new int[]{3, 4}
            }, 5, 5, new int[]{3, 2, 1, 0, 1}),
            Arguments.of(new int[][]{
                new int[]{0, 1}, 
                new int[]{0, 2}, 
                new int[]{1, 3}, 
                new int[]{2, 3}
            }, 5, 4, new int[]{3, 2, 1, 0, -1}),
            Arguments.of(new int[][]{
                new int[]{0,1},
                new int[]{1,2},
                new int[]{2,0}
            }, 3, 3, new int[]{-1, -1, -1})
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideInputForRecommendationSystem")
    void testRecommendationSystem(int[][] friendships, int n, int m, int[] expected) {
        assertArrayEquals(expected, friendRecommendationSystem(n, m, friendships));
    }
}
