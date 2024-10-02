package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static prep.Greedy.maxProfit;

class GreedyTests {
    @Test 
    void testsMaxProfitWorksProperly() {
        int[] throughput = new int[]{4, 2, 7};
        int[] scaling_cost = new int[]{3, 5, 6};
        int budget = 32;
        int expectedOutput = 10;
        
        assertEquals(expectedOutput, maxProfit(throughput, scaling_cost, budget));
    }
}
