package prep;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    /* 
        Rock jumping: IMC OA 
        
        You need to cross a river by jumping on rocks, and some rocks may get submerged as water rises. Each rock has a height, 
        and the water level starts to rise after you make your first jump. The goal is to determine the maximum water level such
        that you can still jump across the river without exceeding the maximum jump distance (maxJump) and total energy (maxEnergy).
        
        Constraints:
	        1.	You can jump a maximum of maxJump distance at once.
	        2.	The total energy used in your jumps cannot exceed maxEnergy. The energy to jump between two positions is 
                equal to the square of the distance.
	        3.	A rock is submerged if the water level is equal to or greater than its height, making it unusable for jumps.

        Inputs:
	        •	width: The width of the river (distance from x = 0 to x = width).
	        •	numRocks: Number of rocks in the river.
	        •	maxJump: Maximum jump distance.
	        •	maxEnergy: Maximum total energy you can use.
	        •	Two arrays:
	            •	x: The x-coordinates of the rocks.
	            •	height: The height of each rock (in non-decreasing order)
    */
    public static double rockJumping(int width, int[] heights, int[] rocks, int maxEnergy, int maxJump) throws Exception {
        // let's see if we can jump at least on the first rock
        if (Math.pow(rocks[0], 2) > maxEnergy || rocks[0] > maxJump) return -1;

        // let's see if we can jump directly to the other side of the river
        if (Math.pow(width, 2) <= maxEnergy && width <= maxJump) return Math.pow(10, 9);

        int left = 0;
        int right = heights[heights.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            // we need only rocks with height above the current water level
            ArrayList<Integer> rocksLeft = new ArrayList<>();

            for (int idx = 0; idx < heights.length; idx++) {
                if (heights[idx] >= mid) {
                    for(int idy = idx; idy < heights.length; idy++) {
                        rocksLeft.add(heights[idy]);
                    }
                    break;
                }
            }

            boolean isPossible = isGoalReachable(width, rocksLeft, maxEnergy, maxJump);

            if (isPossible && left == right) {
                return mid;
            } else if (isPossible) {
                 left = mid;
            } else {
                right = mid - 1;
            }
        }
        throw new Exception("exception"); // not reachable
    }

    public static boolean isGoalReachable(int width, List<Integer> rocks, int maxEnergy, int maxJump) {
        int pos = 0;
        int energyLeft = maxEnergy;

        for (int idx = 0; idx < rocks.size(); idx ++) {
            if (Math.pow(rocks.get(idx) - pos, 2) > energyLeft || rocks.get(idx) - pos > maxJump) return false;

            energyLeft -= Math.pow(rocks.get(idx) - pos, 2);
            pos = rocks.get(idx);
        }

        // last jump
        return Math.pow(width - pos, 2) <= energyLeft && width - pos <= maxJump;
    }
}