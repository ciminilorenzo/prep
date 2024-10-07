package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static prep.SlidingWindow.findSubarrayWithMinimumDistinctIntegers;

class SlidingWindowTests {
    
    @Test 
    void testFindSubarrayWithMinimumDistinctIntegers() {
        int[] array = new int[]{1,2,2,2,5,2};
        int series1 = 1;
        int series2 = 5;
        int output = 3;
        
        assertEquals(output, findSubarrayWithMinimumDistinctIntegers(array, series1, series2));
    }
}