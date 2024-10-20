package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static prep.Greedy.*;

import java.util.stream.Stream;

class GreedyTests {

    @MethodSource
    private static Stream<Arguments> provideInputToTestSnowflakegetMinCost() {
        return Stream.of(
            Arguments.of(new int[]{1,1,3,4}, new int[]{3,1,2,3}, 1),
            Arguments.of(new int[]{1,2,3,2}, new int[]{1,2,3,2}, 3)
        );
    }
    
    @Test 
    void testsMaxProfitWorksProperly() {
        int[] throughput = new int[]{4, 2, 7};
        int[] scaling_cost = new int[]{3, 5, 6};
        int budget = 32;
        int expectedOutput = 10;
        
        assertEquals(expectedOutput, maxProfit(throughput, scaling_cost, budget));
    }

    @ParameterizedTest
    @MethodSource("provideInputToTestSnowflakegetMinCost")
    void testSnowflakegetMinCost(int[] cost, int[] time, int expected) {
        assertEquals(expected, snowflakegetMinCost(cost, time));
    }
}
