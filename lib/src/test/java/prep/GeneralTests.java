package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static prep.General.maximumFishCaught;

class GeneralTests {
    
    @Test 
    void testsMaxCaughtFishFirstCase() {
        int[] fishing = new int[]{1, 2, 3};
        int[] baits = new int[]{1};
        int output = 2;
        
        assertEquals(output, maximumFishCaught(fishing, baits));
    }
}
