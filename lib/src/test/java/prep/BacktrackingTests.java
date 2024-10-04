package prep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import static prep.Backtracking.maxWallHits;

class BacktrackingTests {
    
    @Test 
    void testsMaxHitWallsWorks() {
        float[] walls = new float[]{-1.5f, 0.5f, 1.5f, 5.5f};
        int[] thickness = new int[]{2, 4, 8, 3};
        int maxEnergy = 3;
        int output = 1;

        assertEquals(output, maxWallHits(walls, thickness, maxEnergy));
    }
}