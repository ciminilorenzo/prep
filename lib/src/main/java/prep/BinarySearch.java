package prep;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    
    // rockJumping - IMC (look the problem's description up in the README)
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